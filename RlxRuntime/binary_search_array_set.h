#pragma once
#include "iterable_set.h"

struct binary_search_array_set;

struct bs_as_iterator {
    void* (*current)(struct set_iterator*);
    void (*next)(struct set_iterator*);
    void (*previous)(struct set_iterator*);
    bool (*hasNext)(struct set_iterator*);
    bool (*hasPrevious)(struct set_iterator*);
    void (*free)(struct set_iterator*);
    struct binary_search_array_set* set;
    int index;
};

struct binary_search_array_set {
    const struct set_ops* ops;

    int capacity;
    int size;
    void** data;
};

internal int bs_as_search(struct binary_search_array_set* set, void* element, char* exists) {
    int size = set->size;
//printf("Element %i\n", size);
    if (size == 0) {
//puts("No Elements\n");
        exists[0] = 0;
        return 0;
    }

    void** data = set->data;

//    if (size < 8) {
//        for (int i = 0; i < size; i++) {
//            void** elem = data[i];
//            int comparison = compare(element, elem);
//            if (comparison == 0) {
//                exists[0] = 1;
//                return i;
//            }
//            exists[0] = 0;
//            if (comparison > 0) return 0;
//        }
//    }

    size -= 1;

    int middle = size >> 1;
    int leftBound = 0;
    int rightBound = size;

    while (leftBound < rightBound) {
        void** elem = data[middle];
        int comparison = compare(element, elem);

        if (comparison == 0) {
            exists[0] = 1;
            return middle;
        }

        if (comparison > 0) {
            leftBound = middle + 1;
        } else {
            rightBound = middle - 1;
        }
        middle = (leftBound + rightBound) >> 1;

        if (middle < 0) {
            exists[0] = 0;
            return 0;
        } else if (middle > size) {
            exists[0] = 0;
            return size;
        }
    }

    void** elem = data[middle];
    int comparison = compare(element, elem);

    exists[0] = comparison == 0;
    if (comparison > 0) middle += 1;
    return middle;
}

internal void bs_as_ensure_capacity(struct binary_search_array_set* set, int size) {
    int capacity = set->capacity;
    if (size >= capacity) {
        int grow = capacity;
        void** old = set->data;
        int cap = capacity + grow;
        set->data = __builtin_realloc(set->data, cap * sizeof(void*));
        set->capacity = cap;
    }
}

internal bool bs_as_add_element(struct binary_search_array_set* set, void* element) {
//printf("Add element %i\n", set->size);
    char exists = 0;
    int index = bs_as_search(set, element, &exists);
//printf("Add element %i\n", set->size);
    if (!exists) {
        int size = set->size;
        if (index < 0) index = 0;
        if (index > size) index = size;

        bs_as_ensure_capacity(set, size);
        void** data = set->data;
        shift(set, index, 1, size, data);
        data[index] = element;
        set->size++;
    }
//    printf("Size: %i\n", set->size);
    return !(bool)exists;
}

internal void bs_as_shift(struct simpleSet* set, int index, int offset, int size, void** data) {
    if (index == 0 && offset < 0) return;
    if (index == size && offset > 0) return;
    int start = index;
    int dest = index + offset;
    int len = size - index;
    int delt = len;
    if (delt <= 0) {
        int count = -delt;
        for (int i = count - 1; i >= 0; i--) {
            data[dest + i] = data[start + i];
        }
    } else {
        __builtin_memmove(data + dest, data + start, (size_t)delt * sizeof(*data));
    }
}

internal bool bs_as_remove_element(struct binary_search_array_set* set, void* element) {
    char exists = 0;
    int index = bs_as_search(set, element, &exists);
    if (exists) {
        shift(set, index + 1, -1, set->size, set->data);
        set->size--;
    }
    return (bool)exists;
}

internal bool bs_as_remove_element_fast(struct binary_search_array_set* set, void* element) {
    // TODO: add support for removing without immediate consolidation
    char exists = 0;
    int index = bs_as_search(set, element, &exists);
    if (exists) {
        shift(set, index + 1, -1, set->size, set->data);
        set->size--;
    }
    return (bool)exists;
}

internal void bs_as_compact(struct binary_search_array_set* set) {
    int offset = 0;
    void** data = set->data;
    for (int i = 0; (i + offset) < set->size; i++) {
        bool done = false;
        while (data[i + offset] == 0) {
            offset += 1;
            if (i + offset >= set->size) {
                done = true;
                break;
            }
        }
        if (done) break;
        data[i] = data[i + offset];
    }
    set->size = set->size - offset;
}

internal bool bs_as_contains_element(struct binary_search_array_set* set, void* element) {
    char exists = 0;
    int index = bs_as_search(set, element, &exists);
    return (bool)exists;
}

internal void bs_as_clear(struct binary_search_array_set* set) {
    set->size = 0;
}

/* ITERATOR */
internal void* bs_as_current(struct bs_as_iterator* iterator) {
    if (iterator->index < 0) return 0;
    if (iterator->index >= iterator->set->size) return 0;
    return iterator->set->data[iterator->index];
}

internal void bs_as_next(struct bs_as_iterator* iterator) {
    iterator->index += 1;
}

internal void bs_as_previous(struct bs_as_iterator* iterator) {
    iterator->index -= 1;
}

internal bool bs_as_hasNext(struct bs_as_iterator* iterator) {
//    printf("Check has next\n");
    int size = iterator->set->size;
//    printf("SZ: %i\n", size);
    if (size == 0) return false;
//    printf("Indx: %i\n", iterator->index);
    if (iterator->index >= size) return false;
    return true;
}

internal bool bs_as_hasPrevious(struct bs_as_iterator* iterator) {
    return iterator->index >= 0;
}

internal void bs_as_free_iterator(struct bs_as_iterator* iterator) {
    free(iterator);
}

internal struct set_iterator* bs_as_createIterator(struct binary_search_array_set* set) {
    struct bs_as_iterator* iterator = malloc(sizeof(struct bs_as_iterator));

    iterator->current = (void* (*)(struct set_iterator*)) bs_as_current;
    iterator->next = (void (*)(struct set_iterator*)) bs_as_next;
    iterator->previous = (void (*)(struct set_iterator*)) bs_as_previous;
    iterator->hasNext = (bool (*)(struct set_iterator*)) bs_as_hasNext;
    iterator->hasPrevious = (bool (*)(struct set_iterator*)) bs_as_hasPrevious;
    iterator->free = (void (*)(struct set_iterator*)) bs_as_free_iterator;
    iterator->set = set;
    iterator->index = 0;

    return iterator;
}

internal struct set_iterator* bs_as_createReverseIterator(struct binary_search_array_set* set) {
    struct bs_as_iterator* iterator = malloc(sizeof(struct bs_as_iterator));

    iterator->current = (void* (*)(struct set_iterator*)) bs_as_current;
    iterator->next = (void (*)(struct set_iterator*)) bs_as_next;
    iterator->previous = (void (*)(struct set_iterator*)) bs_as_previous;
    iterator->hasNext = (bool (*)(struct set_iterator*)) bs_as_hasNext;
    iterator->hasPrevious = (bool (*)(struct set_iterator*)) bs_as_hasPrevious;
    iterator->free = (void (*)(struct set_iterator*)) bs_as_free_iterator;
    iterator->set = set;
    iterator->index = set->size - 1;

    return iterator;
}

static const struct set_ops bs_as_ops = {
    .add_element = (bool (*)(struct iterable_set*, void*)) bs_as_add_element,
    .remove_element = (bool (*)(struct iterable_set*, void*)) bs_as_remove_element,
    .remove_element_fast = (bool (*)(struct iterable_set*, void*)) bs_as_remove_element_fast,
    .compact = (void (*)(struct iterable_set*)) bs_as_compact,
    .contains_element = (bool (*)(struct iterable_set*, void*)) bs_as_contains_element,
    .clear = (void (*)(struct iterable_set*)) bs_as_clear,
    .createIterator = (struct set_iterator* (*)(struct iterable_set*)) bs_as_createIterator,
    .createReverseIterator = (struct set_iterator* (*)(struct iterable_set*)) bs_as_createReverseIterator,
};

internal struct iterable_set* createBinarySearchArraySet(int capacity) {
//puts("Create BS AS\n");
    struct binary_search_array_set* set = calloc(1, sizeof(struct binary_search_array_set));
    set->capacity = capacity;
    set->ops = &bs_as_ops;
    set->data = calloc(capacity, sizeof(void*));
//puts("Create BS AS1\n");

    return set;
}

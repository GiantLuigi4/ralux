#pragma once
#include "iterable_set.h"

struct array_set;

struct as_iterator {
    void* (*current)(struct set_iterator*);
    void (*next)(struct set_iterator*);
    void (*previous)(struct set_iterator*);
    bool (*hasNext)(struct set_iterator*);
    bool (*hasPrevious)(struct set_iterator*);
    struct array_set* set;
    int index;
};

struct array_set {
    const struct set_ops* ops;

    int capacity;
    int size;
    void** data;
};

internal void as_ensure_capacity(struct array_set* set, int size) {
    int capacity = set->capacity;
    if (size >= capacity) {
        int grow = capacity;
        void** old = set->data;
        int cap = capacity + grow;
        set->data = __builtin_realloc(set->data, cap * sizeof(void*));
        set->capacity = cap;
    }
}

internal bool as_add_element(struct array_set* set, void* element) {
    void** data = set->data;
    int slot = -1;

    for (int i = 0; i < set->size; i++) {
        void* obj = data[i];

        if (obj == element) {
            return false; // already present
        }

        if (slot == -1 && obj == 0) {
            slot = i;
        }
    }

    if (slot == -1) {
        as_ensure_capacity(set, set->size);
        slot = set->size;
        set->size += 1;
    }

    set->data[slot] = element;

    return true;
}

internal void as_shift(struct simpleSet* set, int index, int offset, int size, void** data) {
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

internal bool as_remove_element(struct array_set* set, void* element) {
    void** data = set->data;

    for (int i = 0; i < set->size; i++) {
        void* obj = data[i];

        if (obj == element) {
            data[i] = 0;
            as_shift(set, i + 1, -1, set->size, set->data);
            set->size -= 1;
//            data[set->size] = 0;
            return true; // already present
        }
    }

    return false;
}

internal bool as_remove_element_fast(struct array_set* set, void* element) {
    void** data = set->data;

    for (int i = 0; i < set->size; i++) {
        void* obj = data[i];

        if (obj == element) {
            data[i] = 0;
            return true; // already present
        }
    }

    return false;
}

internal void as_compact(struct array_set* set) {
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

internal bool as_contains_element(struct array_set* set, void* element) {
    void** data = set->data;

    for (int i = 0; i < set->size; i++) {
        void* obj = data[i];

        if (obj == element) {
            return true; // already present
        }
    }

    return false;
}

internal void as_clear(struct array_set* set) {
    set->size = 0;
}

/* ITERATOR */
internal void* as_current(struct as_iterator* iterator) {
    if (iterator->index < 0) return 0;
    if (iterator->index >= iterator->set->size) return 0;
    return iterator->set->data[iterator->index];
}

internal void as_next(struct as_iterator* iterator) {
    iterator->index += 1;
}

internal void as_previous(struct as_iterator* iterator) {
    iterator->index -= 1;
}

internal bool as_hasNext(struct as_iterator* iterator) {
//    printf("Check has next\n");
    int size = iterator->set->size;
//    printf("SZ: %i\n", size);
    if (size == 0) return false;
//    printf("Indx: %i\n", iterator->index);
    if (iterator->index >= size) return false;
    return true;
}

internal bool as_hasPrevious(struct as_iterator* iterator) {
    return iterator->index >= 0;
}

internal struct set_iterator* as_createIterator(struct array_set* set) {
    struct as_iterator* iterator = malloc(sizeof(struct as_iterator));

    iterator->current = (void* (*)(struct set_iterator*)) as_current;
    iterator->next = (void (*)(struct set_iterator*)) as_next;
    iterator->previous = (void (*)(struct set_iterator*)) as_previous;
    iterator->hasNext = (bool (*)(struct set_iterator*)) as_hasNext;
    iterator->hasPrevious = (bool (*)(struct set_iterator*)) as_hasPrevious;
    iterator->set = set;
    iterator->index = 0;

    return iterator;
}

internal struct set_iterator* as_createReverseIterator(struct array_set* set) {
    struct as_iterator* iterator = malloc(sizeof(struct as_iterator));

    iterator->current = (void* (*)(struct set_iterator*)) as_current;
    iterator->next = (void (*)(struct set_iterator*)) as_next;
    iterator->previous = (void (*)(struct set_iterator*)) as_previous;
    iterator->hasNext = (bool (*)(struct set_iterator*)) as_hasNext;
    iterator->hasPrevious = (bool (*)(struct set_iterator*)) as_hasPrevious;
    iterator->set = set;
    iterator->index = set->size - 1;

    return iterator;
}

static const struct set_ops as_ops = {
    .add_element = (bool (*)(struct iterable_set*, void*)) as_add_element,
    .remove_element = (bool (*)(struct iterable_set*, void*)) as_remove_element,
    .remove_element_fast = (bool (*)(struct iterable_set*, void*)) as_remove_element_fast,
    .compact = (void (*)(struct iterable_set*)) as_compact,
    .contains_element = (bool (*)(struct iterable_set*, void*)) as_contains_element,
    .clear = (void (*)(struct iterable_set*)) as_clear,
    .createIterator = (struct set_iterator* (*)(struct iterable_set*)) as_createIterator,
    .createReverseIterator = (struct set_iterator* (*)(struct iterable_set*)) as_createReverseIterator,
};

internal struct iterable_set* createArraySet(int capacity) {
    struct array_set* set = calloc(1, sizeof(struct array_set));
    set->capacity = capacity;
    set->ops = &as_ops;
    set->data = calloc(capacity, sizeof(void*));

    return set;
}

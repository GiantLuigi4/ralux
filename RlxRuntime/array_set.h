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

internal bool as_remove_element(struct array_set* set, void* element) {
    void** data = set->data;

    for (int i = 0; i < set->size; i++) {
        void* obj = data[i];

        if (obj == element) {
            data[i] = 0;
            set->size -= 1;
            return true; // already present
        }
    }

    return false;
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
    return iterator->set->data[iterator->index];
}

internal void as_next(struct as_iterator* iterator) {
    iterator->index += 1;
}

internal void as_prev(struct as_iterator* iterator) {
    iterator->index -= 1;
}

internal bool as_hasNext(struct as_iterator* iterator) {
    int size = iterator->set->size;
    if (size == 0) return false;
    if (iterator->index >= (size - 1)) return false;
    return true;
}

internal bool as_hasPrev(struct as_iterator* iterator) {
    return iterator->index > 0;
}

internal struct set_iterator* as_createIterator(struct array_set* set) {
    struct as_iterator* iterator = malloc(sizeof(struct as_iterator));

    iterator->current = (void* (*)(struct set_iterator*)) as_current;
    iterator->next = (void (*)(struct set_iterator*)) as_next;
    iterator->previous = (void (*)(struct set_iterator*)) as_prev;
    iterator->hasNext = (bool (*)(struct set_iterator*)) as_hasNext;
    iterator->hasPrevious = (bool (*)(struct set_iterator*)) as_hasPrev;
    iterator->set = set;
    iterator->index = 0;

    return iterator;
}

static const struct set_ops as_ops = {
    .add_element = (bool (*)(struct iterable_set*, void*)) as_add_element,
    .remove_element = (bool (*)(struct iterable_set*, void*)) as_remove_element,
    .contains_element = (bool (*)(struct iterable_set*, void*)) as_contains_element,
    .clear = (void (*)(struct iterable_set*)) as_clear,
    .createIterator = (struct set_iterator* (*)(struct iterable_set*)) as_createIterator,
};

internal struct iterable_set* createArraySet(int capacity) {
    struct array_set* set = calloc(1, sizeof(struct array_set));
    set->capacity = capacity;
    set->ops = &as_ops;
    set->data = calloc(sizeof(void*), capacity);

    return set;
}

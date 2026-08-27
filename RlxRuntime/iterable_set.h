#pragma once

#include "pch.h"

struct iterable_set;

struct set_iterator {
    void* (*current)(struct set_iterator*);
    void (*next)(struct set_iterator*);
    void (*previous)(struct set_iterator*);
    bool (*hasNext)(struct set_iterator*);
    bool (*hasPrevious)(struct set_iterator*);
};

struct set_ops {
    bool (*add_element)(struct iterable_set*, void*);
    bool (*remove_element)(struct iterable_set*, void*);
    bool (*contains_element)(struct iterable_set*, void*);
    void (*clear)(struct iterable_set*);
    struct set_iterator* (*createIterator)(struct iterable_set*);
};

struct iterable_set {
    const struct set_ops* ops;

    int capacity;
    int size;
};


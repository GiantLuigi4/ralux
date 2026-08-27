#pragma once
#include "iterable_set.h"
#include "array_set.h"

struct hash_set;

struct hs_iterator {
    void* (*current)(struct set_iterator*);
    void (*next)(struct set_iterator*);
    void (*previous)(struct set_iterator*);
    bool (*hasNext)(struct set_iterator*);
    bool (*hasPrevious)(struct set_iterator*);
    struct hash_set* set;
    struct set_iterator* currentIterator;
    int currentBin;
};

struct hash_set {
    const struct set_ops* ops;

    int capacity;
    int size;
    struct iterable_set** bins;
    int loadFactor;
};

internal bool hs_add_element(struct hash_set* set, void* element) {
    int binId = ((long long) element) / 47;
    struct iterable_set* bin = set->bins[binId];
    if (bin == 0) {
        bin = createArraySet(4);
        set->bins[binId] = bin;
    }

    return bin->ops->add_element(bin, element);
}

internal bool hs_remove_element(struct hash_set* set, void* element) {
    int binId = ((long long) element) / 47;
    struct iterable_set* bin = set->bins[binId];
    if (bin == 0) {
        return false;
    }

    return bin->ops->remove_element(bin, element);
}

internal bool hs_contains_element(struct hash_set* set, void* element) {
    int binId = ((long long) element) / 47;
    struct iterable_set* bin = set->bins[binId];
    if (bin == 0) {
        return false;
    }

    return bin->ops->contains_element(bin, element);
}

internal void hs_clear(struct hash_set* set) {
    for (int i = 0; i < set->capacity; i++) {
        struct iterable_set* bin = set->bins[i];
        if (bin != 0) {
            bin->ops->clear(bin);
        }
    }
    set->size = 0;
}

static const struct set_ops hs_ops = {
    .add_element = (bool (*)(struct iterable_set*, void*)) hs_add_element,
    .remove_element = (bool (*)(struct iterable_set*, void*)) hs_remove_element,
    .contains_element = (bool (*)(struct iterable_set*, void*)) hs_contains_element,
    .clear = (void (*)(struct iterable_set*)) hs_clear,
};

internal struct iterable_set* createHashSet(int capacity, int loadFactor) {
    struct hash_set* set = calloc(sizeof(struct hash_set), 1);
    set->capacity = capacity;
    set->loadFactor = loadFactor;
    set->ops = &hs_ops;
    set->bins = calloc(sizeof(struct iterable_set*), capacity);

    return set;
}
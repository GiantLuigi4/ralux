#pragma once
#include "set.h"
#include "pch.h"
#include "RlxRt.h"

int hash(void* ptr) {
    return (int) ptr;
}

int comparison(void* left, void* right) {
    return (int) (((long long) left) - ((long long) right));
    // if (left < right) return -1;
    // if (left == right) return 0;
    // return 1;
}

internal SetT createSet() {
    SetT set = setCreate();
    set->compare = comparison;
    set->hash = hash;
    return set;
}

internal bool contains(SetT set, void* key) {
    return setContains(set, key);
}

internal void add(SetT set, void* key) {
    setAdd(set, key);
}

internal void erase(SetT set, void* key) {
    setRemove(set, key);
}

internal void clear(SetT set) {
    setClear(set);
}

internal void freeSet(SetT set) {
    setFree(set);
}

internal int setSize(SetT set) {
    return set->size;
}

internal void* setGet(SetT set, int index) {
    return set->data[index];
}

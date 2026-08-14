#pragma once
#include "set.h"
#include "pch.h"
#include "RlxRt.h"

internal SetT createSet() {
    SetT set = setCreate();
    return set;
}

internal bool contains(SetT set, void* key) {
    return setContains(set, key);
}

internal bool add(SetT set, void* key) {
    return setAdd(set, key);
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

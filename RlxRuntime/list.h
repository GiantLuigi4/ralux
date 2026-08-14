#pragma once

#include "pch.h"

#define ArrayList struct simpleList*
struct simpleList {
    int size;
    int capacity;
    void** data;
};


internal ArrayList listCreate() {
    ArrayList ptr = malloc(sizeof(struct simpleList));
    ptr->capacity = 1;
    ptr->size = 0;
    ptr->data = malloc(sizeof(void*));
    return ptr;
}

internal void list_ensureCapacity(ArrayList set, int size) {
    int capacity = set->capacity;
    if (size + 1 >= capacity) {
        int grow = capacity;
        void** old = set->data;
        int cap = capacity + grow;
        set->data = __builtin_realloc(set->data, cap * sz);
        set->capacity = cap;
    }
}

internal void listAdd(ArrayList set, void* key) {
    int size = set->size;

    int index = size;
    list_ensureCapacity(set, size);

    void** data = set->data;
    data[index] = key;

    set->size++;
}

internal void* listPop(ArrayList set) {
    int size = set->size;

    void* d = set->data[size - 1];

    set->size--;

    return d;
}

internal void listClear(ArrayList set) {
    set->size = 0;
}

internal int listSize(ArrayList set) {
    return set->size;
}

internal void* listGet(ArrayList set, int index) {
    return set->data[index];
}

internal void listFree(ArrayList map) {
    free(map->data);
    map->capacity = 0;
    map->size = 0;
    map->data = 0;
    free(map);
}

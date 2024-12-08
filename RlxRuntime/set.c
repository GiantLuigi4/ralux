#include "set.h"
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

const int prealloc = 16;
const int sz = sizeof(void**);

SimpleSet* setCreate() {
    SimpleSet* ptr = malloc(sizeof(SimpleSet));
    ptr->capacity = prealloc;
    ptr->size = 0;
    ptr->data = malloc(prealloc * sz);
    return ptr;
}

internal int search(SimpleSet* set, void* element, char* exists) {
    void** dat = set->data;
    for (int i = 0; i < set->size; i++) {
        void* elem = dat[i];
        int rel = set->compare(elem, element);
        if (rel == 0) {
            exists[0] = 1;
            return i;
        }
        if (rel > 0) {
            exists[0] = 0;
            return i;
        }
    }
    exists[0] = 0;
    return set->size;
}

internal void ensureCapacity(SimpleSet* set) {
    int size = set->size;
    int capacity = set->capacity;
    if (size + 1 >= capacity) {
        int grow = capacity;
        void** old = set->data;
        int cap = capacity + grow;
        void** newData = malloc(cap * sz);
        set->data = newData;
        memcpy(newData, old, size * sz);
        free(old);
        set->capacity = cap;
    }
}

internal void memmov(void* src, void* dst, int count) {
    void** tmp = malloc(count * sz);
    // TODO: optimize
    for (int i = 0; i < count; i++) {
        tmp[i] = ((void**)src)[i];
    }
    for (int i = 0; i < count; i++) {
        ((void**)dst)[i] = tmp[i];
    }
    free(tmp);
}

internal void shift(struct simpleSet* set, int index, int offset) {
    if (index == 0 && offset < 0) return;
    if (index == set->size && offset > 0) return;
    int start = index;
    int dest = (index + offset);
    int len = set->size - index;
    int end = (index + len + offset);
    int delt = len;
    memmov(set->data + start, set->data + dest, delt);
    // memcpy(set->data + start, set->data + dest, delt);
}

void setAdd(SimpleSet* set, void* key) {
    char exists = 0;
    int index = search(set, key, &exists);
    if (!exists) {
        ensureCapacity(set);
        shift(set, index, 1);
        set->data[index] = key;
        set->size++;
    }
}

void setRemove(SimpleSet* set, void* key) {
    char exists = 0;
    int index = search(set, key, &exists);
    if (exists) {
        shift(set, index + 1, -1);
        set->size--;
    }
}

bool setContains(SimpleSet* map, void* element) {
    char exists = 0;
    search(map, element, &exists);
    return (bool)exists;
}

// int setSize(SimpleSet* set) {
//     return set->size;
// }
//
// void* setGet(SimpleSet* set, int index) {
//     return set->data[index];
// }

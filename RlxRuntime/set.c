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
    int size = set->size;
    if (size == 0) {
        exists[0] = 0;
        return 0;
    }
    size -= 1;
    
    void** data = set->data;

    int middle = size >> 1;
    int leftBound = 0;
    int rightBound = size;

    int (*compare)(void*, void*) = set->compare;
    
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

internal void ensureCapacity(SimpleSet* set, int size) {
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

internal void shift(struct simpleSet* set, int index, int offset, int size, void** data) {
    if (index == 0 && offset < 0) return;
    if (index == size && offset > 0) return;
    int start = index;
    int dest = index + offset;
    int len = size - index;
    int delt = len;
    memmov(data + start, data + dest, delt);
    // memcpy(set->data + start, set->data + dest, delt);
}

void setAdd(SimpleSet* set, void* key) {
    char exists = 0;
    int index = search(set, key, &exists);
    if (!exists) {
        int size = set->size;
        if (index < 0) index = 0;
        if (index > size) index = size;
        
        ensureCapacity(set, size);
        void** data = set->data;
        shift(set, index, 1, size, data);
        data[index] = key;
        set->size++;
    }
}

void setRemove(SimpleSet* set, void* key) {
    char exists = 0;
    int index = search(set, key, &exists);
    if (exists) {
        shift(set, index + 1, -1, set->size, set->data);
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

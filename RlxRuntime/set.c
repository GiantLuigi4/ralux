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

int search(SimpleSet* set, void* element, char* exists) {
    void** dat = set->data;
    for (int i = 0; i < set->size; i++) {
        void* elem = dat[i];
        int rel = set->compare(elem, element);
        if (rel == 0) {
            exists[0] = 1;
            return i;
        }
        // if (rel > 0) {
        //     puts("Not found");
        //     exists[0] = 0;
        //     return set->size;
        // }
    }
    exists[0] = 0;
    return set->size;
}

void ensureCapacity(SimpleSet* set) {
    int size = set->size;
    int capacity = set->capacity;
    if (size + 1 >= capacity) {
        int grow = capacity / 16;
        void** old = set->data;
        int cap = capacity + grow;
        void** newData = malloc(cap * sz);
        set->data = newData;
        memcpy(newData, old, size * sz);
        free(old);
        set->capacity = cap;
    }
}

void memmov(void* src, void* dst, int count) {
    void* tmp = malloc(count);
    memcpy(src, tmp, count);
    memcpy(tmp, dst, count);
    free(tmp);
}

void shift(struct simpleSet* set, int index, int offset) {
    if (index == 0 && offset < 0) return;
    if (index == set->size && offset > 0) return;
    int start = index * sz;
    int dest = (index + offset) * sz;
    int len = set->size - index;
    int end = (index + len + offset) * sz;
    int delt = end;
    // memmov(set->data + start, set->data + dest, delt);
    memcpy(set->data + start, set->data + dest, delt);
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
        // shift(set, index + 1, -1);
        // set->size--;
        set->data[index] = 0;
    }
}

bool setContains(SimpleSet* map, void* element) {
    char exists = 0;
    search(map, element, &exists);
    return (bool) exists;
}

void setFree(SimpleSet* map) {
    free(map);
}

int setSize(SimpleSet* set) {
    return set->size;
}

void* setGet(SimpleSet* set, int index) {
    return set->data[index];
}

//int compare(void* l, void* r) {
//    const char* left = (const char*) l;
//    const char* right = (const char*) r;
//    return strcmp(left, right);
//}
//
//int hash(void* v) {
//    const char* value = (const char*) v;
//    int hash = 0;
//    const int prime = 31;
//    for (int i = 0;; i++) {
//        hash = hash * prime + value[i];
//        if (value[i] == 0) break;
//    }
//    return hash;
//}
//
//int main() {
//    SimpleSet* ptr = setCreate();
//    ptr->compare = compare;
//    ptr->hash = hash;
//
//    setAdd(ptr, "te", "et");
//    setAdd(ptr, "et", "te");
//    setAdd(ptr, "test", "tset");
//    setAdd(ptr, "tes", "tse");
//    setAdd(ptr, "testing", "gnitset");
//    setAdd(ptr, "tests", "stset");
//    setAdd(ptr, "testi", "itset");
//    setAdd(ptr, "testss", "sstset");
//    setAdd(ptr, "testss", "this element was replaced");
//
//    printf("elem: %s\n", (const char*) setContains(ptr, "te"));
//    printf("elem: %s\n", (const char*) setContains(ptr, "et"));
//    printf("elem: %s\n", (const char*) setContains(ptr, "tes"));
//    printf("elem: %s\n", (const char*) setContains(ptr, "test"));
//    printf("elem: %s\n", (const char*) setContains(ptr, "tests"));
//    printf("elem: %s\n", (const char*) setContains(ptr, "testss"));
//    printf("elem: %s\n", (const char*) setContains(ptr, "testi"));
//    printf("elem: %s\n", (const char*) setContains(ptr, "testing"));
//}

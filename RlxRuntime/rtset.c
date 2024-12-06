#include "rtset.h"

int hash(void* ptr) {
    return (int) ptr;
}

int comparison(void* left, void* right) {
    return (int) (((long long) left) - ((long long) right));
    // if (left < right) return -1;
    // if (left == right) return 0;
    // return 1;
}

SetT createSet() {
    SetT set = setCreate();
    set->compare = comparison;
    set->hash = hash;
    return set;
}

bool contains(SetT set, void* key) {
    return setContains(set, key);
}

void add(SetT set, void* key) {
    setAdd(set, key);
}

void erase(SetT set, void* key) {
    setRemove(set, key);
}

void freeSet(SetT set) {
    setFree(set);
}

/*
int setSize(SetT set) {
    return set->size;
}

void* setGet(SetT set, int index) {
    return set->keys[index];
}
*/

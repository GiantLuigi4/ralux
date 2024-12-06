#pragma once
#include "pch.h"

#define SimpleSet struct simpleSet
struct simpleSet {
    int size;
    int capacity;
    void** data;
    
    int (*compare)(void*, void*);
    int (*hash)(void*);
};

SimpleSet* setCreate();
void setAdd(SimpleSet* map, void* key);
void setRemove(SimpleSet* map, void* key);
bool setContains(SimpleSet* map, void* element);
void setFree(SimpleSet* map);
int setSize(SimpleSet* set);
void* setGet(SimpleSet* set, int index);

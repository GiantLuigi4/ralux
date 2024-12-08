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
// not marked as internal since I want to deduplicate these
void setAdd(SimpleSet* map, void* key);
void setRemove(SimpleSet* map, void* key);
bool setContains(SimpleSet* map, void* element);
internal void setFree(SimpleSet* map) {
    free(map->data);
    map->capacity = 0;
    map->size = 0;
    map->data = 0;
    free(map);
}

// int setSize(SimpleSet* set);
// void* setGet(SimpleSet* set, int index);

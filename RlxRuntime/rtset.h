#pragma once
#include "set.h"
#include "pch.h"
#include "RlxRt.h"

int hash(void* ptr);
int comparison(void* left, void* right);
SetT createSet();
bool contains(SetT set, void* key);
void add(SetT set, void* key);
void erase(SetT set, void* key);
void freeSet(SetT set);
/*
int setSize(SetT set);
void* setGet(SetT set, int index);
*/

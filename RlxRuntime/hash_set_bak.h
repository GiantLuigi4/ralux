//#pragma once
//#include "iterable_set.h"
//#include "array_set.h"
//
//struct hash_set;
//
//struct hs_iterator {
//    void* (*current)(struct set_iterator*);
//    void (*next)(struct set_iterator*);
//    void (*previous)(struct set_iterator*);
//    bool (*hasNext)(struct set_iterator*);
//    bool (*hasPrevious)(struct set_iterator*);
//    struct hash_set* set;
//    struct set_iterator* currentIterator;
//    int currentBin;
//};
//
//struct hash_set {
//    const struct set_ops* ops;
//
//    int capacity;
//    int size;
//    struct iterable_set** bins;
//    int loadFactor;
//};
//
//internal bool hs_add_element(struct hash_set* set, void* element) {
//    int binId = (((uintptr_t) element) / 47) % set->capacity;
//    struct iterable_set* bin = set->bins[binId];
//    if (bin == 0) {
//        bin = createArraySet(4);
//        set->bins[binId] = bin;
//    }
//
////    puts("addElem");
////    printf("%i\n", binId);
////    printf("%llu\n", bin);
//
//    bool value = bin->ops->add_element(bin, element);
//    if (value) set->size++;
//    return value;
//}
//
//internal bool hs_remove_element(struct hash_set* set, void* element) {
//    int binId = (((uintptr_t) element) / 47) % set->capacity;
//    struct iterable_set* bin = set->bins[binId];
//    if (bin == 0) {
//        return false;
//    }
//
////    puts("removeElem");
////    printf("%i\n", binId);
////    printf("%llu\n", bin);
//
//    bool value = bin->ops->remove_element(bin, element);
//    if (value) set->size--;
////    puts("removedElem");
//    return value;
//}
//
//internal bool hs_remove_element_fast(struct hash_set* set, void* element) {
//    int binId = (((uintptr_t) element) / 47) % set->capacity;
//    struct iterable_set* bin = set->bins[binId];
//    if (bin == 0) {
//        return false;
//    }
//
////    puts("removeElem");
////    printf("%i\n", binId);
////    printf("%llu\n", bin);
//
//    bool value = bin->ops->remove_element_fast(bin, element);
//    if (value) set->size--;
////    puts("removedElem");
//    return value;
//}
//
//internal void hs_compact(struct hash_set* set) {
//    for (int i = 0; i < set->capacity; i++) {
//        struct iterable_set* bin = set->bins[i];
//        if (bin != 0) bin->ops->compact(bin);
//    }
//}
//
//internal bool hs_contains_element(struct hash_set* set, void* element) {
//    int binId = (((uintptr_t) element) / 47) % set->capacity;
//    struct iterable_set* bin = set->bins[binId];
//    if (bin == 0) {
//        return false;
//    }
//
////    puts("containsElem");
//
//    return bin->ops->contains_element(bin, element);
//}
//
//internal void hs_clear(struct hash_set* set) {
//    for (int i = 0; i < set->capacity; i++) {
//        struct iterable_set* bin = set->bins[i];
//        if (bin != 0) {
//            bin->ops->clear(bin);
//        }
//    }
//    set->size = 0;
//}
//
///* ITERATOR */
//internal void* hs_current(struct hs_iterator* iterator) {
//    struct set_iterator* curr = iterator->currentIterator;
//    return curr->current(curr);
//}
//
//internal void hs_next(struct hs_iterator* iterator) {
//    struct set_iterator* curr = iterator->currentIterator;
//    curr->next(curr);
//    if (curr->hasNext(curr)) return;
//    free(curr);
//
////    printf("HAS_NEXT: further check...\n");
//
//    int checkBin = iterator->currentBin + 1;
//    while (true) {
////        printf("Checking bin... %llu\n", checkBin);
//        if (checkBin >= iterator->set->capacity) {
//            iterator->currentIterator = 0;
//            iterator->currentBin = iterator->currentBin - 1;
//            return;
//        }
//
//        struct iterable_set* bin = iterator->set->bins[checkBin];
//        if (bin != 0 && bin->size != 0) {
//            iterator->currentIterator = bin->ops->createIterator(bin);
//            iterator->currentBin = checkBin;
//            return;
//        }
//
//        checkBin += 1;
//    }
//}
//
//internal void hs_prev(struct hs_iterator* iterator) {
//    struct set_iterator* curr = iterator->currentIterator;
//    curr->previous(curr);
//    if (curr->hasPrevious(curr)) return;
//    free(curr);
//
//    int checkBin = iterator->currentBin - 1;
//    while (true) {
//        if (checkBin < 0) {
//            iterator->currentIterator = 0;
//            iterator->currentBin = iterator->currentBin + 1;
//            return;
//        }
//
//        struct iterable_set* bin = iterator->set->bins[checkBin];
//        if (bin != 0 && bin->size != 0) {
//            iterator->currentIterator = bin->ops->createReverseIterator(bin);
//            iterator->currentBin = checkBin;
//            return;
//        }
//
//        checkBin -= 1;
//    }
//}
//
//internal bool hs_hasNext(struct hs_iterator* iterator) {
//    struct set_iterator* curr = iterator->currentIterator;
//    if (curr == 0) return false; // no iterator exists
//    if (curr->hasNext(curr)) return true;
////    printf("Must check further\n");
//
//    int checkBin = iterator->currentBin + 1;
//    while (true) {
//        if (checkBin >= iterator->set->capacity) {
//            return false;
//        }
//
//        struct iterable_set* bin = iterator->set->bins[checkBin];
//        if (bin != 0 && bin->size != 0) {
////            printf("Found bin: %llu with %i elements\n", bin, bin->size);
//            return true;
//        }
//
//        checkBin += 1;
//    }
//}
//
//internal bool hs_hasPrev(struct hs_iterator* iterator) {
//    struct set_iterator* curr = iterator->currentIterator;
//    if (curr == 0) return false; // no iterator exists
//    if (curr->hasPrevious(curr)) return true;
//
//    int checkBin = iterator->currentBin - 1;
//    while (true) {
//        if (checkBin < 0) return false;
//
//        struct iterable_set* bin = iterator->set->bins[checkBin];
//        if (bin != 0 && bin->size != 0) return true;
//
//        checkBin -= 1;
//    }
//}
//
//internal struct set_iterator* hs_createIterator(struct hash_set* set) {
//    struct hs_iterator* iterator = malloc(sizeof(struct hs_iterator));
//
//    iterator->current = (void* (*)(struct set_iterator*)) hs_current;
//    iterator->next = (void (*)(struct set_iterator*)) hs_next;
//    iterator->previous = (void (*)(struct set_iterator*)) hs_prev;
//    iterator->hasNext = (bool (*)(struct set_iterator*)) hs_hasNext;
//    iterator->hasPrevious = (bool (*)(struct set_iterator*)) hs_hasPrev;
//    iterator->set = set;
//    iterator->currentBin = 0;
//    if (set->capacity == 0 || set->size == 0) {
//        iterator->currentBin = 0;
//        iterator->currentIterator = 0;
//        return iterator;
//    }
//
//    int checkBin = 0;
//    while (true) {
//        if (checkBin >= set->capacity) {
//            iterator->currentIterator = 0;
//            return iterator;
//        }
//
//        struct iterable_set* bin = iterator->set->bins[checkBin];
//        if (bin != 0 && bin->size != 0) {
////            printf("Found bin: %llu\n", bin);
//            iterator->currentIterator = bin->ops->createIterator(bin);
//            iterator->currentBin = checkBin;
//            break;
//        }
//
//        checkBin += 1;
//    }
//
//    return iterator;
//}
//
//internal struct set_iterator* hs_createReverseIterator(struct hash_set* set) {
//    struct hs_iterator* iterator = malloc(sizeof(struct hs_iterator));
//
//    iterator->current = (void* (*)(struct set_iterator*)) hs_current;
//    iterator->next = (void (*)(struct set_iterator*)) hs_next;
//    iterator->previous = (void (*)(struct set_iterator*)) hs_prev;
//    iterator->hasNext = (bool (*)(struct set_iterator*)) hs_hasNext;
//    iterator->hasPrevious = (bool (*)(struct set_iterator*)) hs_hasPrev;
//    iterator->set = set;
//    if (set->capacity == 0 || set->size == 0) {
//        iterator->currentBin = 0;
//        iterator->currentIterator = 0;
//        return iterator;
//    }
//    iterator->currentBin = set->capacity - 1;
//
//    int checkBin = iterator->currentBin;
//    while (true) {
//        if (checkBin < 0) {
//            iterator->currentIterator = 0;
//            return iterator;
//        }
//
//        struct iterable_set* bin = iterator->set->bins[checkBin];
//        if (bin != 0 && bin->size != 0) {
//            iterator->currentIterator = bin->ops->createReverseIterator(bin);
//            iterator->currentBin = checkBin;
//            break;
//        }
//
//        checkBin -= 1;
//    }
//
//    return iterator;
//}
//
//static const struct set_ops hs_ops = {
//    .add_element = (bool (*)(struct iterable_set*, void*)) hs_add_element,
//    .remove_element = (bool (*)(struct iterable_set*, void*)) hs_remove_element,
//    .remove_element_fast = (bool (*)(struct iterable_set*, void*)) hs_remove_element_fast,
//    .compact = (void (*)(struct iterable_set*)) hs_compact,
//    .contains_element = (bool (*)(struct iterable_set*, void*)) hs_contains_element,
//    .clear = (void (*)(struct iterable_set*)) hs_clear,
//    .createIterator = (struct set_iterator* (*)(struct iterable_set*)) hs_createIterator,
//    .createReverseIterator = (struct set_iterator* (*)(struct iterable_set*)) hs_createReverseIterator,
//};
//
//internal struct iterable_set* createHashSet(int capacity, int loadFactor) {
//    struct hash_set* set = calloc(1, sizeof(struct hash_set));
//    set->capacity = capacity;
//    set->loadFactor = loadFactor;
//    set->ops = &hs_ops;
//    set->bins = calloc(capacity, sizeof(struct iterable_set*));
//
//    return set;
//}
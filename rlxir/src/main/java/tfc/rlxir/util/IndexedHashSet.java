package tfc.rlxir.util;

import java.util.*;

public class IndexedHashSet<E> implements Set<E> {
    private transient HashMap<E, Index> map;
    Index root;
    Index last;

    public IndexedHashSet() {
        map = new HashMap<>();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Index current = IndexedHashSet.this.root;

            @Override
            public boolean hasNext() {
                return current.next != null;
            }

            @Override
            public E next() {
                E elem = current.elem;
                current = current.next;
                return elem;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return map.keySet().toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return map.keySet().toArray(a);
    }

    @Override
    public boolean add(E e) {
        Index idx = map.get(e);
        if (idx == null) {
            map.put(e, idx = new Index(e));
            if (last != null) {
                last.next = idx;
                idx.index = last.index + 1;
            }
            idx.prev = last;
            last = idx;
            if (root == null) root = idx;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        Index idx = map.remove(o);
        if (idx != null) {
            if (idx == last) {
                last = idx.prev;
                if (last != null) last.next = null;
                else root = null;
            } else if (idx == root) {
                root = root.next;
                if (root != null) {
                    root.prev = null;
                    root.updateIndex();
                } else last = null;
            } else {
                Index next = idx.next;
                Index prev = idx.prev;
                if (prev != null) {
                    prev.next = next;
                }
                if (next != null) {
                    next.prev = prev;
                    next.updateIndex();
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return map.keySet().containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean changed = false;
        for (E e : c) {
            changed = add(e) | changed;
        }
        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new RuntimeException("NYI");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new RuntimeException("NYI");
    }

    @Override
    public void clear() {
        root = null;
        last = null;
        map.clear();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        IndexedHashSet<?> that = (IndexedHashSet<?>) object;
        return Objects.equals(map, that.map) && Objects.equals(root, that.root) && Objects.equals(last, that.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map, root, last);
    }

    public int indexOf(E o) {
        Index idx = map.get(o);
        return idx.index;
    }

    public E get(int index) {
        Index idx;
        if (index <= size() >> 2) {
            idx = root;
            for (int i = 0; i < index; i++) idx = idx.next;
        } else {
            idx = last;
            for (int i = 1; i < (size() - index); i++) idx = idx.prev;
        }
        return idx.elem;
    }

    public Index getRoot() {
        return root;
    }

    public final class Index {
        int index;
        Index next;
        Index prev;
        E elem;

        public Index(E elem) {
            this.elem = elem;
        }

        public void updateIndex() {
            Index curr = this;
            if (prev == null) {
                index = 0;
                curr = next;
                if (curr == null) return;
            }

            while (curr.index != curr.prev.index + 1) {
                curr.index = curr.prev.index + 1;
                if (curr.next == null)
                    break;
                curr = curr.next;
            }
        }

        public int getIndex() {
            return index;
        }

        public Index getNext() {
            return next;
        }

        public Index getPrev() {
            return prev;
        }

        public E getElem() {
            return elem;
        }
    }
}

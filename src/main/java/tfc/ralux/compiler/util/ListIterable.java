package tfc.ralux.compiler.util;

import java.util.ListIterator;

public interface ListIterable<T> extends Iterable<T> {
    ListIterator<T> listIterator();
}

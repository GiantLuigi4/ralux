package tfc.ralux.compiler.util;

public record Pair<T, V>(T getFirst, V getSecond) {
    public static <T, V> Pair<T, V> of(T t, V v) {
        return new Pair<>(t, v);
    }
}

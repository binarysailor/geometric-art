package binarysailor.graphics.sequences;

public interface Sequence<T> {
    boolean hasNext();
    T getNext();
}

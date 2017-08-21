package binarysailor.graphics;

import binarysailor.graphics.sequences.Sequence;

abstract class DrawableSequence implements Sequence<Drawable> {
    private int count;
    private int counter = 0;

    protected DrawableSequence(int count) {
        this.count = count;
    }

    @Override
    public final boolean hasNext() {
        return counter < count;
    }

    @Override
    public final Drawable getNext() {
        if (hasNext()) {
            return generateDrawable();
        } else {
            throw new IllegalStateException("All drawables have already been generated");
        }
    }

    abstract protected Drawable generateDrawable();
}

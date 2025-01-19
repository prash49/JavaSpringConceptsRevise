package Genirics;

public class GenericBox<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public GenericBox<T> setItem(T item) {
        this.item = item;
        return this;
    }
}

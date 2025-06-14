package LogicBuildingPrograms;

public class MyHashMap<K, V> {
    private static final int SIZE = 16;
    private Object[] table;

    public MyHashMap() {
        table = new Object[SIZE];
    }

    public void put(K key, V value) {
        int index = key.hashCode() & SIZE - 1;
        table[index] = value;
    }

    public V get(K key) {
        int index = key.hashCode() & SIZE - 1;
        return (V) table[index];
    }

    public void delete(K key) {
        int index = key.hashCode() & SIZE - 1;
        table[index] = null;
    }
}

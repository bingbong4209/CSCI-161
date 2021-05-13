package Interfaces;

/**
 *
 * @author Calvin Stepan
 */
public interface Entry<K,V> {
    K getKey();
    V getValue();
    void setKey(K key);
    void setValue(V value);
}

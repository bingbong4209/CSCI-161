package lab109.stepancj;

/**
 * The Entry class provides functionality to help with the makeshift hash table in the client class
 * @author Calvin Stepan
 * @version 4.7.2021
 */
public class Entry<K, V> {
    private K key;
    private V value;
    
    public Entry( K key, V value )
    {
        this.key = key;
        this.value = value;
    }
    
    public void setKey( K key ) { this.key = key; }
    public K getKey( ) { return key; }
    public void setValue( V value ) { this.value = value; }
    public V getValue( ) { return value; }
    
    public String toString( )
    {
        return "key = " + key.toString() + " : value = " + value.toString();
    }
    
    public boolean equals( Object o )
    {
        if ( !( o instanceof Entry ) )
            return false;
        
        Entry e = (Entry) o;
        
        return key.equals( e.getKey() ) && value.equals( e.getValue() );
    }

}

package lab109.stepancj;

/**
 *
 * @author Calvin Stepan
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

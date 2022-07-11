public class UnsortedPositionalTableMap<K,V> extends AbstractMap<K,V> {
    private LinkedPositionalList<MapEntry<K,V>> table = new LinkedPositionalList<>();

    UnsortedPositionalTableMap() {};

    public int findIndex(K key) {
        int n = table.size();  
        if(n == 0) return 0; // this indicares the value has not been found
        MapEntry<K,V> cur = table.first(); 
        int in = 0;
        while(cur.next != null) {
            if(cur.getKey() == key) {
                return in; 
            }else {
                cur = cur.next;
                in++;
            }
        }
        
    }


    public V get(K key) {
        
    }

    public V put(K key, V value) { 

    }

    public V remove(K key) {

    }



    private class EntryIterator implements Iterator<Entry<K,V>> {
        private int j = 0;
        public boolean hasNext( ) { return j < table.size( ); }
        public Entry<K,V> next( ) {
        if (j == table.size( )) throw new NoSuchElementException( );
        return table.get(j++);
        }
        public void remove( ) { throw new UnsupportedOperationException( ); }
        }
        private class EntryIterable implements Iterable<Entry<K,V>> {
        public Iterator<Entry<K,V>> iterator( ) { return new EntryIterator( ); }
        }
        //∗∗ Returns an iterable collection of all key-value entries of the map. ∗/
       public Iterable<Entry<K,V>> entrySet( ) { return new EntryIterable( ); }

}
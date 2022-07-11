import java.util.Random;

public abstract class AbstractHashMap<K,V> extends AbstractMap<K,V> {
 protected int n = 0; // number of entries in the dictionary
 protected int capacity; // length of the table
 private int prime; // prime factor
 private long scale, shift; // the shift and scaling factors
 private float loadfactor;
 
 public AbstractHashMap(int cap, int p, float lf) {
    prime = p;
    capacity = cap;
    Random rand = new Random( );
    scale = rand.nextInt(prime-1) + 1;
    shift = rand.nextInt(prime);
    loadfactor = lf;
    createTable( );
}

 //public AbstractHashMap(int cap, int p, float lf) {capacity = cap; prime = p; loadfactor = lf;} 
 public AbstractHashMap(int cap, int p) {capacity = cap; prime = p;} 
 public AbstractHashMap(int cap) { this(cap,109345121); } // default prime
 public AbstractHashMap( ) { this(17); } // default capacity
 // public methods
 public int size( ) { return n; }
 public V get(K key) { return bucketGet(hashValue(key), key); }
 public V remove(K key) { return bucketRemove(hashValue(key), key); }
 public V put(K key, V value) {
    V answer = bucketPut(hashValue(key), key, value);
        if (n > capacity / 2) // keep load factor <= 0.5
            resize(2 * capacity - 1); // (or find a nearby prime)
     return answer;
}
 // private utilities
 public int hashValue(K key) {
    return (int) ((Math.abs(key.hashCode( )*scale + shift) % prime) % capacity);
}
 private void resize(int newCap) {
    ArrayList<Entry<K,V>> buffer = new ArrayList<>(n);
        for (Entry<K,V> e : entrySet( ))
          buffer.add(e);
          capacity = newCap;
          createTable( ); // based on updated capacity
          n = 0; // will be recomputed while reinserting entries
            for (int i =0; i < buffer.size(); i++)
              put(buffer.get(i).getKey( ), buffer.get(i).getValue( ));
 }

 public int getKEY(K key) {
    if(this.isEmpty()) return null;
    return (findIndex(key));
 }

 protected int findIndex(K key) {
    int n = this.size( );
    for (int j=0; j < n; j++)
    if (this.get(j).getKey( ).equals(key))
    return j;
    return -1; // special value denotes that key was not found
    }

 public boolean containsKey(K key) {
    if(this.isEmpty()) {return null;}
    return (findIndex(key) != -1);
 }
 // protected abstract methods to be implemented by subclasses
 protected abstract void createTable( );
 protected abstract V bucketGet(int h, K k);
 protected abstract V bucketPut(int h, K k, V v);
 protected abstract V bucketRemove(int h, K k);
}
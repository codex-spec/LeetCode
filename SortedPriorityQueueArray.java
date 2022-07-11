import java.util.Comparator;

public class SortedPriorityQueueArray<K,V> extends AbstractPriorityQueue<K,V> {
    private final int MAX_SIZE = 15;
    private Entry<K,V>[] PriorityQueueArray;
    private int size = 0;

    SortedPriorityQueueArray() {super();}
    SortedPriorityQueueArray(Comparator<K> c) {super(c);}

    public boolean isEmpty() {return size == 0;}

    public int size() {
        return size;
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        if(this.size() == MAX_SIZE-1) {
            throw new IllegalArgumentException("The array is full");
        }else {
            PQEntry<K,V> e1 = new PQEntry<K,V>(key, value); 
            int i = size-1;
            while(i >= 0 && compare(e1, PriorityQueueArray[i]) < 0) {
                PriorityQueueArray[i+1] = PriorityQueueArray[i];
                i--;
            }
            PriorityQueueArray[i+1] = e1;
            size++;

        }
        return null;
    }

    @Override
    public Entry<K, V> min() {
        Entry<K, V> e1 = PriorityQueueArray[0];
        
        return e1;
    }

    @Override
    public Entry<K, V> removeMin() {
        if(size == 0) {
            return null;
        }
        Entry<K, V> e1 = PriorityQueueArray[0];
        int i = 0;
        while(i < size-1) {
            PriorityQueueArray[i] = PriorityQueueArray[i+1];
            i++;
        }
        PriorityQueueArray[i] = null;
        size--;
        return e1;
    }
    
}
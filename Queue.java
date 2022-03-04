
public interface Queue<E> {
    public int size();

    public boolean isEmpty();

    public E getFirst();

    public E getLast();

    public void addFirst(E e);

    public void addLast(E e);

     E removeFirst();

     E removeLast();
}
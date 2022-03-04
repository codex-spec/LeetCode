
public class DoublyLinkedDequeQueue<E> implements Queue<E> {
    DoublyLinkedList<E> dll2 = new DoublyLinkedList<>();

    DoublyLinkedDequeQueue() {}

    public E getFirst() {
        return dll2.getFirst();
    }

    public E getLast() {
        return dll2.getLast();
    }

    public int size() {
        return dll2.getSize();
    }

    public boolean isEmpty() {
        return dll2.getSize() == 0;
    }

    public void addFirst(E e) {
         dll2.addFirst(e);
    }

    public void addLast(E e) {
        dll2.addLast(e);
    }

    public E removeFirst() {
        return dll2.removeFirst();
    }

    public E removeLast() {
        return dll2.removeLast();
    }
}
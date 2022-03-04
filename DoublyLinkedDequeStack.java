
public class DoublyLinkedDequeStack<E> implements Stack<E> {  
    DoublyLinkedList<E> dll1 = new DoublyLinkedList<E>();
    
    DoublyLinkedDequeStack() {}

    public int size() {
        return dll1.getSize();
    }

    public E pop() {
        return dll1.removeFirst();
    }

    public E top() {
        return dll1.getFirst();
    }

    public void push(E ele) {
         dll1.addFirst(ele);
    }

    public boolean isEmpty() {
        return dll1.getSize() == 0;
    }

    public void transfer(Stack<E> s) {}

    
    public void transferOth(Stack<Integer> s, Stack<Integer> t) {}

    public void popEverything() {}
}
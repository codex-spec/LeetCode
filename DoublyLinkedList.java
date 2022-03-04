

public class DoublyLinkedList<E> {
    static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        Node (Node<E> p, E e, Node<E> n) {
            this.prev = p;
            this.element = e;
            this.next = n;
        }

        public E getElement() {return this.element;}
        public void setNext(Node<E> next) {this.next = next;}
        public void setPrev(Node<E> prev) {this.prev = prev;}
        public void changeElement(E someE) {this.element = someE;}
        public Node<E> getNext() {return this.next;}
        public Node<E> getPrev() {return this.prev;}
    }

    DoublyLinkedList() {
        header = new Node<>(null, null, trailer);
        trailer = new Node<>(header, null, null);
    }

    private Node<E> header = null;
    private Node<E> trailer = null;
    private int size = 0;

    public boolean isEmpty() { return size == 0;}

    public int getSize() {
        return this.size;
    }

    public E getFirst() {
        return header.getNext().getElement();
    }

    public E getLast() {
        return trailer.getPrev().getElement();
    }

    public void addFirst(E ele) {
        addBetween(ele, header, trailer);
    }

    public void addLast(E ele) {
        addBetween(ele, trailer.getPrev(), trailer);
    }

    public E  removeFirst() {
        if(isEmpty()) {return null;}
        return remove(header.getNext());
    }

    public E removeLast() {
        if(isEmpty()) {return null;}
        return remove(trailer.getPrev());
    }

    public void addBetween(E e, Node<E> prev, Node<E> next) {
        Node<E> newest = new Node<E>(prev, e, next);
        prev.setNext(newest);
        next.setPrev(newest);
        size++;
    }

    public E remove(Node<E> someN) {
        if(isEmpty()) return null;
        Node<E> previous = someN.getPrev();
        Node<E> nextIteration = someN.getNext();
        previous.setNext(nextIteration);
        nextIteration.setPrev(previous);
        size--;
        return someN.getElement();
    }

}
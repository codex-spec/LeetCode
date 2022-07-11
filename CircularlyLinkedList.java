public class CircularlyLinkedList<E> {
    public static class Node<E> {
    E element;
    Node<E> next;

    Node(E ele, Node<E> next) {
        this.element = ele;
        this.next = next;
    }

    public E getElement() {return this.element;}
    public Node<E> getNext() {return this.next;}
    public void setNext(Node<E> n) {
        this.next = n;
    }
   }

   private int size = 0;
   private Node<E> tail = null;
   //private int size() {return this.size;}
   public E getFirst() {if(isEmpty()){return null;} return tail.getNext().getElement();}
   public void setNext(Node<E> e) {
       this.tail.next = e;
   }

   public int getSize() {
       int c = 0;
       Node<E> head = tail.getNext();
       while(head.getNext() != tail.getNext()) {
           c++;
       }
       return c;
   }

   public boolean isEmpty() {return size == 0;}

   public E firstElement() {
       return tail.getNext().getElement();
   }

   public E getLast() {
       return tail.getElement();
   }

   public void rotate() {
    if(tail != null) 
    tail = tail.getNext();
   }

   public void addFirst(E e) {
    if(size == 0) {
        tail = new Node<E>(e, null);
        tail.setNext(tail);
    }else{
        Node<E> newest =  new Node<E>(e, tail.getNext());
        tail.setNext(newest);
    }
    size++;
   }

   public void addLast(E e) {
       addFirst(e);
       tail = tail.getNext();
   }

   public E removeFirst() {
    if(isEmpty())  return null;
        Node<E> head = tail.getNext();
        if(head == tail) 
        tail = null;
        else 
        tail.setNext(head.getNext());
        size--;
    return head.getElement();
   }

   public boolean equals(CircularlyLinkedList<E> c1) {

    if(this == c1) return true;
    if(this.getSize() != c1.getSize() ) return false;

        Node<E> curr = tail.getNext(); Node<E> ocur = c1.tail.getNext();;
        while(curr.getNext() != null && ocur.getNext() != null) {
            if(ocur.getElement() == curr.getElement()) {
                curr = curr.getNext(); ocur = ocur.getNext();
            }else { return false; }
        }
        return true;
   }

   public String printList() {
       String s ="{";

       Node<E> tmp = this.tail;
        if(isEmpty()) return s += "}";
        while(tmp.getNext() != tail) {
            s += tmp.getElement() + " ";
            tmp = tmp.getNext();
        }

        s += tmp.getElement();
        return s + "}"; 

   }

    public static void main(String[] args) {
       CircularlyLinkedList<Integer> c1 = new CircularlyLinkedList<Integer>();

        c1.addFirst(34);
        c1.addFirst(45);
        c1.addFirst(53);
        c1.addFirst(60);
        System.out.println(c1.printList());


   }

}
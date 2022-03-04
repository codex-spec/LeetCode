public class SinglyLinkedListM<E> {
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

    public Node<E> head = null;
    public Node<E> tail = null;
    int size = 0;
    public SinglyLinkedListM() {}

    public E getFirst() {if(isEmpty()) {return null;}else {return head.getElement();}}
    public E getLast() {if(isEmpty()) {return null;}else {return tail.getElement();}}

    public boolean isEmpty() {return size == 0;}

    

    public void addFirst(E e) {
        head = new Node<E>(e, head);
        if(size == 0) {
            tail = head;
        }
        size++;
    }
    //this is a method which is used to return the sizw of a singly linked list without the size instance variable
    public int Size() {
        int c = 1;
        if(isEmpty()) return 0;
        Node<E> cur = head;
        while(cur.getNext() != null) {
            cur = cur.getNext();
            c++;
        }
        return c;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<E>(e, null);
        if(isEmpty()) {
            head = newest;
        }else {
            tail.setNext(newest);
            tail = newest;
            size++;
        }
    }

    public E removeLast() {
        if(this.isEmpty()) return null;
            Node<E> curr = head;
            while(curr.getNext() != null) {
                curr = curr.getNext();
            }
            E lastEle = curr.getElement();
            size--;
            return lastEle;
    }

    public E removeFirst() {
        if(isEmpty()) return null;
        E ele = head.getElement();
        head = head.getNext();
        size--;
        if(size == 0) {
            tail = null;
        }
        return ele;
    }

    

    public String toString() {
        String S = "{";
        Node<E> curr = head;

        if(curr == null) return  S + "}";

        while(curr.getNext() != null) {
            S += curr.getElement() + " ";
            curr = curr.getNext();
        }

        S += curr.getElement();
        return S + "}";

    }

    public E getSecondToLastNode() {
        Node<E> curr = head;
        E ele;
        if(isEmpty()) return null;

        while(curr.getNext().getNext() != null) {
            //ele = curr.getElement();
            curr = curr.getNext();
        }
        ele = curr.getElement();

        return ele;
    }

    //this rotate method is responsible for invoking the logic of addLast(removeFirst()) procedure yet without creating a new node
    //this maneuver was done because it is a question in a data strctutre and algorithm book R-3.12
    //the logic is to roate the tail to point at the head where the tail becomes the head node and the head becomes the head.getNext() node
    //this shifts the tail and head node 1 unit clockwise.
    public void rotate() {
        if(isEmpty()) {tail = head = null; return;}
        tail.setNext(head);
        tail = tail.getNext();
        head = head.getNext();  
    }

    public void addLastNode(E e) {
        Node<E> cur = new Node<E>(e,null);
        if(head == null) {
            head = cur;
            tail = cur;
        }else {
            tail.next = cur;
            tail = cur;
        }


    }

    public SinglyLinkedListM<E> concatenate(SinglyLinkedListM<E> l, SinglyLinkedListM<E> m) {
        //int ts = l.size + m.size;
        //SinglyLinkedListM<E> sl = new SinglyLinkedListM<E>();
        if(l.isEmpty() || m.isEmpty()) {
            return this;
        }
        Node<E> tmp = l.head;
        Node<E> otmp = m.head;
        
        while(tmp.getNext() != l.tail.getNext()) {
            this.addLastNode(tmp.getElement());
            tmp = tmp.getNext();
        }
        this.addLastNode(tmp.getElement());

        while(otmp.getNext() != m.tail.getNext()) {
            this.addLastNode(otmp.getElement());
            otmp = otmp.getNext();
        }
        this.addLastNode(otmp.getElement());

        return this;
    }

    public static void main(String[] args) {
        SinglyLinkedListM<Integer> s1 = new SinglyLinkedListM<Integer>();
        SinglyLinkedListM<Integer> sc = s1;
        SinglyLinkedListM<Integer> sum = new SinglyLinkedListM<Integer>(); 
        s1.addFirst(2);
        s1.addFirst(3);
        s1.addFirst(4);
        s1.addFirst(5);
        s1.addFirst(7);
        

        System.out.println(s1.toString()); 
        System.out.println(s1.getSecondToLastNode());
        System.out.println(s1.getLast());
        System.out.println(s1.Size());
        //s1.rotate();
        System.out.println(s1.getLast());
        System.out.println(s1.getFirst());

        System.out.println(sum.concatenate(s1, sc).toString());
    }

}
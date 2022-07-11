public class LinkedList  {
    protected static int size = 0;
    private static Node head;
    
    protected static class Node {
        private int ele;
        private Node next;

        Node (int element, Node n) {
            this.ele = element;
            this.next = n;
        }

        public void set(int ele) {
            this.ele = ele;
        }

        public Node getNext() {
            return next;
        }

        public int getElement() {
            return ele;
        }

        public void setNext(Node s) {
            this.next = s;
        }
    }

    //public Node<E> head = null;
    //public Node<E> tail = null;

    public boolean isEmpty() {
        return size == 0;
    }

    public static LinkedList add(LinkedList l, int ele) {
        Node newest = new Node(ele, null);

        if(l.head == null) {
            head = newest;
            //head.next = head;
        }else {

            Node last = l.head;
            while(last.next != null) {
                last = last.next;
            }
            last.next = newest;
            //last = newest;


        }
        size++;
        return l;
    }

    public static void removeLast(LinkedList l) {
        Node hold = l.head;
        while(hold.getNext().getNext() != null) {
           hold = hold.getNext();
        }
        hold.setNext(null);
        size--;
    }

    public static String printList(LinkedList l1) {
        Node h = l1.head;
        StringBuilder s = new StringBuilder();
        s.append("{");
        while(h.getNext() != null) {
            s.append(h.getElement());
            s.append(" ");
            h = h.getNext();
        }
        s.append(h.getElement());
        s.append("}");
        return s.toString();
    }

    /*
    public static String recPrintList(LinkedList n, Node head) {
        StringBuilder r = new StringBuilder();
        r.append("{");
        //Node h = l.head;
        //int k = 0; 
        Node l = n.head;
        if(l.getNext() == null) {
            r.append("}");
        }else {
            r.append(l.getElement());
            l= l.getNext();
            recPrintList(n, l);
        }
        return r.toString();
    }   
    */

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        for(int i = 1; i <= 10; i++)
            add(l1, i);

        
        System.out.println(printList(l1));
        removeLast(l1);
        System.out.println(printList(l1));
        System.out.println("\n");
        //System.out.println(recPrintList(l1, l1.head));


    }
    

}
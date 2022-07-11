import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements PositionalList<E> {
 //---------------- nested Node class ----------------
 private static class Node<E> implements Position<E> {
 private E element; // reference to the element stored at this node
 private Node<E> prev; // reference to the previous node in the list
 private Node<E> next; // reference to the subsequent node in the list
 public Node(E e, Node<E> p, Node<E> n) {
 element = e;
 prev = p;
 next = n;
 }
 public E getElement( ) throws IllegalStateException {
 if (next == null) // convention for defunct node
 throw new IllegalStateException("Position no longer valid");
 return element;
 }
 public Node<E> getPrev( ) {
 return prev;
 }
 public Node<E> getNext( ) {
 return next;
 }
 public void setElement(E e) {
 element = e;
 }
 public void setPrev(Node<E> p) {
 prev = p;
 }
 public void setNext(Node<E> n) {
 next = n;
 }
 } //----------- end of nested Node class -----------

 // instance variables of the LinkedPositionalList
 private Node<E> header; // header sentinel
 private Node<E> trailer; // trailer sentinel
 private int size = 0; // number of elements in the list

// /∗∗ Constructs a new empty list. ∗/
 public LinkedPositionalList( ) {
 header = new Node<>(null, null, null); // create header
 trailer = new Node<>(null, header, null); // trailer is preceded by header
 header.setNext(trailer); // header is followed by trailer
 }
// Code Fragment 7.9: An implementation of the LinkedPositionalList class.
// (Continues in Code Fragments 7.10–7.12.)
// www.it-ebooks.info
// 278 Chapter 7. List and Iterator ADTs
 // private utilities
// /∗∗ Validates the position and returns it as a node. ∗/
 private Node<E> validate(Position<E> p) throws IllegalArgumentException {
 if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
 Node<E> node = (Node<E>) p; // safe cast
 if (node.getNext( ) == null) // convention for defunct node
 throw new IllegalArgumentException("p is no longer in the list");
 return node;
 }

// /∗∗ Returns the given node as a Position (or null, if it is a sentinel). ∗/
 private Position<E> position(Node<E> node) {
 if (node == header || node == trailer)
 return null; // do not expose user to the sentinels
 return node;
 }

 // public accessor methods
// /∗∗ Returns the number of elements in the linked list. ∗/
 public int size( ) { return size; }

//? /∗∗ Tests whether the linked list is empty. ∗/
 public boolean isEmpty( ) { return size == 0; }

// /∗∗ Returns the first Position in the linked list (or null, if empty). ∗/
 public Position<E> first( ) {
 return position(header.getNext( ));
 }

// /∗∗ Returns the last Position in the linked list (or null, if empty). ∗/
 public Position<E> last( ) {
 return position(trailer.getPrev( ));
 }

 //∗∗ Returns the Position immediately before Position p (or null, if p is first). ∗/
 public Position<E> before(Position<E> p) throws IllegalArgumentException {
 Node<E> node = validate(p);
 return position(node.getPrev( ));
 }

// /∗∗ Returns the Position immediately after Position p (or null, if p is last). ∗/
 public Position<E> after(Position<E> p) throws IllegalArgumentException {
 Node<E> node = validate(p);
 return position(node.getNext( ));
}
// Code Fragment 7.10: An implementation of the LinkedPositionalList class.
// (Continued from Code Fragment 7.9; continues in Code Fragments 7.11 and 7.12.)
// www.it-ebooks.info
// 7.3. Positional Lists 279
 // private utilities
//∗∗ Adds element e to the linked list between the given nodes. ∗/
 private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
 Node<E> newest = new Node<>(e, pred, succ); // create and link a new node
 pred.setNext(newest);
 succ.setPrev(newest);
 size++;
 return newest;
}

 // public update methods
// /∗∗ Inserts element e at the front of the linked list and returns its new Position. ∗/
 public Position<E> addFirst(E e) {
 return addBetween(e, header, header.getNext( )); // just after the header
 }

// /∗∗ Inserts element e at the back of the linked list and returns its new Position. ∗/
 public Position<E> addLast(E e) {
 return addBetween(e, trailer.getPrev( ), trailer); // just before the trailer
 }

// /∗∗ Inserts element e immediately before Position p, and returns its new Position.∗/
 public Position<E> addBefore(Position<E> p, E e)
 throws IllegalArgumentException {
 Node<E> node = validate(p);
 return addBetween(e, node.getPrev( ), node);
 }

// /∗∗ Inserts element e immediately after Position p, and returns its new Position. ∗/
 public Position<E> addAfter(Position<E> p, E e)
 throws IllegalArgumentException {
 Node<E> node = validate(p);
 return addBetween(e, node, node.getNext( ));
 }

// /∗∗ Replaces the element stored at Position p and returns the replaced element. ∗/
 public E set(Position<E> p, E e) throws IllegalArgumentException {
 Node<E> node = validate(p);
 E answer = node.getElement( );
 node.setElement(e);
return answer;
}

//@Override
public E remove(Position<E> p) throws IllegalArgumentException {
 Node<E> node = validate(p);
 Node<E> predecessor = node.getPrev( );
 Node<E> successor = node.getNext( );
 predecessor.setNext(successor);
 successor.setPrev(predecessor);
 size--;
 E answer = node.getElement( );
 node.setElement(null); // help with garbage collection
 node.setNext(null); // and convention for defunct node
 node.setPrev(null);
 return answer;
 }

public Position<E> addLastOther(E e) {
    //Node<E> newN = new Node<E>(e, trailer.getPrev(), trailer);
    return new Node<E>(e, trailer.getPrev(), trailer);
}

public Position<E> addBeforeOther(E e, Node<E> before) {
    //Node<E> bNode = new Node<E>(e, before.getPrev(), before);
    return new Node<E>(e, before.getPrev(), before);
}

public int indexOf(Position<E> p) {
    int ind = 0;
    if(header.getNext() == p) {
        return 1;
    }
    Node<E> current = header;
    while(current.getNext() != p) {
        ind++;
        current = current.getNext();
    }
    if(current == p) {return ind;}else if(current.getNext() == p) {return ++ind;}
    else if(trailer.getPrev() == p) {return ind;}
    return ind;
}

public Position<E> findPosition(E e) {
    Node<E> cur = header.getNext();
    if(first() == e) {
        return first();
    }else {
        while(cur.getNext().element != e) {
            cur = cur.getNext();
        }
        if(cur == e) {return cur;}else if(last() == e) {return last();}
    }
    return cur;
}

//this method is a helper method used to get the length of the positional List without the add of the size instance variable 
public int getLength() {
    Position<E> start = this.after(header);
    if(start == null) return 0;
    int c = 1;
    while(start != last()) {
        c++;
        start = this.after(start);
    }
    c++; //account for the last node not counted in the while loop
    return c;
}

public Position<E> positionAtIndex(int i) throws IndexOutOfBoundsException {
    if(i > this.getLength()) throw new IndexOutOfBoundsException("Invalid index");
    Position<E> curr = after(header);
    int k = 0;
    if( i == k) return this.first();
    while(curr != null) {
        ++k;
        if(k == i) {
            break;
        }
        curr = after(curr);
    }
    return curr;
}

public Position<E> positionAtIndexReverse(int i) throws IndexOutOfBoundsException {
    if(i > size()) {throw new IndexOutOfBoundsException("Invalid index");}
    int k = size();
    Position<E> cur = before(trailer);
    if(k == i) return before(trailer);
    else {
        while(cur != after(header)) {
            --k;
            if(k == i) break;
            cur = before(cur);
        }
    }
    return cur;
}

public void moveToFront(Position<E> p) {
    //Node<E> n = validate(p);
    Position<E> cur = first();
    while(cur != p || cur == null) {
        cur = after(cur);
    }
    //this line means the entire Positionallist has been iterated and the Position p has not been found in the list therefore the method will just return
    if(cur != p && after(cur) == null || cur == null) return;
    else if(cur == p) {
        //now we have to move the position to the front of the list
        E pElement = remove(cur);
        addFirst(pElement);
        return;
    }
} 

 public void moveToFrontOther(Position<E> p) {
    if(isEmpty()) return;
    else if(after(header) == p) return;
    Node<E> n = validate(p);

    if(n != header.getNext()) {
        n.getPrev().setNext(n.getNext());
        n.getNext().setPrev(n.getPrev());

        n.setNext(header.getNext());
        n.setPrev(header);
        header.getNext().setPrev(n);
        header.setNext(n);
    }
}

 public static LinkedPositionalList<Integer> cardShuffle(LinkedPositionalList<Integer> obj) throws IllegalArgumentException {
    if(obj.size % 2 != 0) throw new IllegalArgumentException("the size of the list needs to be an even number");

    LinkedPositionalList<Integer> l1 = new LinkedPositionalList<Integer>(), 
    l2 = new LinkedPositionalList<Integer>(), l3 = new LinkedPositionalList<Integer>();
    Node<Integer> cur = obj.header.getNext();
    //int half = obj.size/2;
    // for(int i = 0; i < half; i++) {
    //     l1.addBetween(cur.getElement(), cur.getPrev(), cur.getNext());
    //     cur = cur.getNext();
    // }
    
    for(int i = 0; i < obj.size; i++) {
        if(i < obj.size/2) {
            l1.addBetween(cur.getElement(), cur.getPrev(), cur.getNext());
            cur = cur.getNext();
        }else {
            l2.addBetween(cur.getElement(), cur.getPrev(), cur.getNext());
            cur = cur.getNext();
        }
    }
    //l1.traverse(0, half);
    //l2.traverse(half, size);

    // for(int j = half; j < obj.size; j++) {
    //     l2.addBetween(cur.getElement(), cur.getPrev(), cur.getNext());
    //     cur = cur.getNext();
    // }

    Node<Integer> hold = l1.header.getNext(), hold2 = l2.header.getNext();
    while(hold2.getNext() != null) {
        l3.addBetween(hold.getElement(), hold.getPrev(), hold.getNext());
        l3.addBetween(hold2.getElement(), hold2.getPrev(), hold2.getNext());
        hold = hold.getNext();
        hold = hold2.getNext();
    }
    return l3;
 }


 public void  traverse(int start, int end) {
    Node<E> cur = this.header.getNext();
    for(int j = start; j < end; j++) {
        this.addBetween(cur.getElement(), cur.getPrev(), cur.getNext());
        cur = cur.getNext();
    }
 }
    


 public static LinkedPositionalList<Object> reversalTheList(LinkedPositionalList<Object> list) {
    LinkedPositionalList<Object> revL = new LinkedPositionalList<Object>();
    //int k = 0; 
    Node<Object> cur = list.trailer.getPrev();
    while(cur.getPrev() != list.header) {
        revL.addBetween(cur.getElement(), cur.getNext(), cur.getPrev());
        cur = cur.getPrev();
        //k++;
    }

    return revL;
    
 }

 private class PositionIterator implements Iterator<Position<E>>, java.util.Iterator<Position<E>> {
        private Position<E> cursor = first( ); // position of the next element to report
        private Position<E> recent = null; // position of last reported element
    //∗∗ Tests whether the iterator has a next object. ∗/
        public boolean hasNext( ) { return (cursor != null); }
    //∗∗ Returns the next position in the iterator. ∗/
        public Position<E> next( ) throws NoSuchElementException {
            if (cursor == null) throw new NoSuchElementException("nothing left");
            recent = cursor; // element at this position might later be removed
            cursor = after(cursor);
            return recent;
            }
    //∗∗ Removes the element returned by most recent call to next. ∗/
        public void remove( ) throws IllegalStateException {
            if (recent == null) throw new IllegalStateException("nothing to remove");
            LinkedPositionalList.this.remove(recent); // remove from outer list
            recent = null; // do not allow remove again until next is called
            }
    } //------------ end of nested PositionIterator class ------------
   
    //---------------- nested PositionIterable class ----------------
 private class PositionIterable implements Iterable<Position<E>> {
        public java.util.Iterator<Position<E>> iterator( ) { 
            return new PositionIterator(); 
            }
        } //------------ end of nested PositionIterable class ------------
   
    //** Returns an iterable representation of the list's positions. *∗/
        public Iterable<Position<E>> positions( ) {
            return new PositionIterable( ); // create a new instance of the inner class
            }
   
    //---------------- nested ElementIterator class ----------------
    //∗ This class adapts the iteration produced by positions() to return elements. ∗/
 private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = new PositionIterator( );
        public boolean hasNext( ) { return posIterator.hasNext( ); }
        public E next( ) { return posIterator.next( ).getElement( ); } // return element!
        public void remove( ) { ((LinkedPositionalList.PositionIterator) posIterator).remove( ); }
    }
   
    //∗∗ Returns an iterator of the elements stored in the list. ∗/
        public Iterator<E> iterator( ) { return new ElementIterator( ); }
 



public static void main(String[] args) {
    // LinkedPositionalList<Integer> lpl = new LinkedPositionalList<Integer>();
    // Node<Integer> n1 = new Node<Integer>(2, null, null);
    // Node<Integer> n2 = new Node<Integer>(4, null, null);
    // Node<Integer> n3 = new Node<Integer>(6, null, null);
    // Node<Integer> n4 = new Node<Integer>(10, null, null);
    // lpl.addFirst(n1.element);
    // lpl.addLast(n4.element);
    // lpl.addBetween(n2.element, n1, n4);
   
    // lpl.addBetween(n3.element, n2, n4);

    // System.out.println(lpl.indexOf(n4));
    LinkedPositionalList<Integer> l1 = new LinkedPositionalList<Integer>(), l2 = new LinkedPositionalList<Integer>();
    l1.addFirst(10);
    l1.addFirst(8);
    l1.addFirst(6);
    l1.addFirst(4);
    l1.addFirst(2);
    l1.addFirst(0);
    //Node<Integer> curr = l1.header.getNext();
    // for(int i =0; i < l1.size(); i++) {
    //     System.out.print(curr.getElement() + " ");
    //     curr = curr.getNext();
    // }
    System.out.println();
    l2 = cardShuffle(l1);
    Node<Integer> cur = l2.header.getNext();
    while(cur.getNext() != null) {
        System.out.println(cur.getElement());
        cur = cur.getNext();
    }


    //System.out.println("hello");
  }

}

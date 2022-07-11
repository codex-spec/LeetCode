import java.security.InvalidParameterException;
import java.util.Iterator;

import javax.management.modelmbean.InvalidTargetObjectTypeException;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

 //---------------- nested Node class ----------------
 protected static class Node<E> implements Position<E> {
 private E element; // an element stored at this node
 private Node<E> parent; // a reference to the parent node (if any)
 private Node<E> left; // a reference to the left child (if any)
 private Node<E> right; // a reference to the right child (if any)

 /** Constructs a node with the given element and neighbors.**/

 public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
 element = e;
 parent = above;
 left = leftChild;
 right = rightChild;
 }
 // accessor methods
 public E getElement( ) { return element; }
 public Node<E> getParent( ) { return parent; }
 public Node<E> getLeft( ) { return left; }
 public Node<E> getRight( ) { return right; }
 // update methods
 public void setElement(E e) { element = e; }
 public void setParent(Node<E> parentNode) { parent = parentNode; }
 public void setLeft(Node<E> leftChild) { left = leftChild; }
 public void setRight(Node<E> rightChild) { right = rightChild; }
 } 
 //----------- end of nested Node class -----------

 /**  Factory function to create a new node storing element e.**/
 protected Node<E> createNode(E e, Node<E> parent,
    Node<E> left, Node<E> right) {
    return new Node<E>(e, parent, left, right);
 }

 // LinkedBinaryTree instance variables
 protected Node<E> root = null; // root of the tree
 private int size = 0; // number of nodes in the tree

 // constructor
 public LinkedBinaryTree( ) { } // constructs an empty binary tree

 // nonpublic utility
 /** Validates the position and returns it as a node. **/
 protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
    if (!(p instanceof Node))
    throw new IllegalArgumentException("Not valid position type");
    Node<E> node = (Node<E>) p; // safe cast
    if (node.getParent( ) == node) // our convention for defunct node
    throw new IllegalArgumentException("p is no longer in the tree");
    return node;
 }

 // accessor methods (not already implemented in AbstractBinaryTree)
 //∗∗ Returns the number of nodes in the tree. ∗/
 public int size( ) {
    return size;
 }

 //∗∗ Returns the root Position of the tree (or null if tree is empty). ∗/
 public Position<E> root( ) {
    return root;
 }

 //∗∗ Returns the Position of p's parent (or null if p is root). ∗/
 public Position<E> parent(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p);
    return node.getParent( );
 }

 //∗∗ Returns the Position of p's left child (or null if no child exists). ∗/
 public Position<E> left(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p);
    return node.getLeft( );
 }

 //∗∗ Returns the Position of p's right child (or null if no child exists). ∗/
 public Position<E> right(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p);
    return node.getRight( );
 }

 // update methods supported by this class
 //∗∗ Places element e at the root of an empty tree and returns its new Position. ∗/
 public Position<E> addRoot(E e) throws IllegalStateException {
    if (!isEmpty( )) throw new IllegalStateException("Tree is not empty");
    root = createNode(e, null, null, null);
    size = 1;
    return root;
 }

 //∗∗ Creates a new left child of Position p storing element e; returns its Position. ∗/
 public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
    Node<E> parent = validate(p);
    if (parent.getLeft( ) != null)
    throw new IllegalArgumentException("p already has a left child");
    Node<E> child = createNode(e, parent, null, null);
    parent.setLeft(child);
    size++;
    return child;
 }

 //∗∗ Creates a new right child of Position p storing element e; returns its Position. ∗/
 public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
    Node<E> parent = validate(p);
    if (parent.getRight( ) != null)
    throw new IllegalArgumentException("p already has a right child");
    Node<E> child = createNode(e, parent, null, null);
    parent.setRight(child);
    size++;
    return child;
 }

 //∗∗ Replaces the element at Position p with e and returns the replaced element. ∗/
 public E set(Position<E> p, E e) throws IllegalArgumentException {
    Node<E> node = validate(p);
    E temp = node.getElement( );
    node.setElement(e);
    return temp;
 }

 //∗∗ Attaches trees t1 and t2 as left and right subtrees of external p. ∗/
 public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
    Node<E> node = validate(p);
    if (isInternal(p)) throw new IllegalArgumentException("p must be a leaf");
        size += t1.size( ) + t2.size( );
    if (!t1.isEmpty( )) { // attach t1 as left subtree of node
        t1.root.setParent(node);
        node.setLeft(t1.root);
        t1.root = null;
        t1.size = 0;
    }
    
    if (!t2.isEmpty( )) { // attach t2 as right subtree of node
        t2.root.setParent(node);
        node.setRight(t2.root);
        t2.root = null;
        t2.size = 0;
    }
 }

 //∗∗ Removes the node at Position p and replaces it with its child, if any. ∗/
 public E remove(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p);
        if (numChildren(p) == 2) throw new IllegalArgumentException("p has two children");
    Node<E> child = (node.getLeft( ) != null ? node.getLeft( ) : node.getRight( ) );
        if (child != null)
            child.setParent(node.getParent( )); // child’s grandparent becomes its parent
                if (node == root)
                    root = child; // child becomes root
                else {
                    Node<E> parent = node.getParent( );
                    if (node == parent.getLeft( ))
                        parent.setLeft(child);
                     else
                        parent.setRight(child);
                    }
        size--;
        E temp = node.getElement( );
        node.setElement(null); // help garbage collection
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node); // our convention for defunct node
    return temp;
    }

@Override
 public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    return null;
 }

@Override
 public Iterable<Position<E>> positions() {
    // TODO Auto-generated method stub
    return null;
 }

@Override
 public boolean hasNext() {
    // TODO Auto-generated method stub
    return false;
 }

@Override
 public E next() {
    // TODO Auto-generated method stub
    return null;
 }

 public int getDepth(Position<E> p) {
     if(isRoot(p)) return 0;
     else return 1 + getDepth(parent(p));
 }

 public int getPathLength(LinkedBinaryTree<E> T) {
    // int h = height(T.root());
    // int level = h+1;
    int  pathV = 0;
    for(Position<E> c : children(T.root())) {
        pathV = getDepth(c);
    }
    return pathV;
}

private void preOrderSubtree(Position<E> p, List<Position<E>> snapshot) {
    snapshot.add(p);
    for(Position<E> c : children(p)) {
        preOrderSubtree(c, snapshot);
    }
}

private class ElementIterator implements Iterator<E> {
     Iterator<Position<E>> posIterator = positions( ).iterator( );
     public boolean hasNext( ) { return posIterator.hasNext( ); }
     public E next( ) { return posIterator.next( ).getElement( ); } // return element!
     public void remove( ) { posIterator.remove( ); }
}

 public boolean testIfIsomorphic(Position<E> p, Position<E> o) {
    // int t1sv = 0, t2sv = 0;
    // if(t1.size == 0 && t2.size == 0) { //both trees are empty theirfore they must be null
    //     return true; 
    // }
    // if(t1.size == 1 && t2.size == 1) {
    //     return true;
    
    // }else {
    //     // if() {
    //         snapshot.add(p);
    //         for(Position<E> c : children(p)) {
    //             t1sv++;
    //             testIfIsomorphic(c, o, t1, t2, snapshot, othsnapshot);
    //         }

    //         othsnapshot.add(o);
    //         for(Position<E> j : children(o)) {
    //             t2sv++;
    //             testIfIsomorphic(j, o, t1, t2, snapshot, othsnapshot);
    //         }
            
    //     // }
    // }
    // return (t1sv == t2sv) ? true : false;
    if(p == null && o == null) {return true;}
    if(p == null || o == null) return false;
    if(p.getElement() != o.getElement()) return false;
    return (testIfIsomorphic(left(p), left(o)) && testIfIsomorphic(right(p), right(o))) || (testIfIsomorphic(left(p), right(o)) && testIfIsomorphic(right(p), left(o))); 

 }

 public int countNodesInSubtree(Position<E> p) {
    Node<E> v = validate(p);
    Node<E> o = validate(p);
    int c = 0;
    
    while(v != null) {
        c++;
        v = (Node<E>) left(v);
    }

    while(o != null) {
        c++;
        o = (Node<E>) right(o);
    }

    return c;
 }

 public void preOrderTraverse(Node<E> n) {
     if(n == null) return;
     preOrderTraverse(n.left);
     preOrderTraverse(n.right);
 }

 public Position<E> preOrderRecurseTarget(Position<E> p, Position<E> target) {
    Position<E> hit = null, left = null, right = null; 
     if(p == target) {hit = p;}
     else {
          left  = preOrderRecurseTarget(left(p), target);
          right = preOrderRecurseTarget(right(p), target);
     }

    return hit;
 }

 public boolean checkIfCon(Position<E> p, Position<E> trans) {
     boolean res = false;
     if(trans == p) return res = true;
     else if(trans == null) return res = false;
     else {
        checkIfCon(p, left(trans));
        checkIfCon(p, right(trans));
     }
     return res;
 }

//  public int checkIfTreeContainsPosition(Position<E> p) {
//      int ind = 1, sig = 0;
//      Node<E> val = validate(p);
//      if(this.root.getElement() == val.getElement() && sig == 0) return ind = 0;
//      if(sig == 0) {
//      for(Position<E> j : children(this.root())) {
//         if(j.getElement() == val.getElement()) {
//             ind = 0;
//             break;
//         }
//      }
//     }else {
//         sig = 1;
//         for(Position<E> k : children())
//     }
//      return ind;
//  }

 public  LinkedBinaryTree <E> pruneSubtree(Position<E> p) throws InvalidParameterException {
    LinkedBinaryTree<E> nBT = new LinkedBinaryTree<>();
    if(this.checkIfCon(p, this.root()) == false) throw new InvalidParameterException("this Positon is not within the tree of this object");
    else {
        if(p == null) return null; 
        if(p == this.root()) return this;
        Position<E> cur = preOrderRecurseTarget(this.root, p);
        nBT.addRoot(cur.getElement());
        Position<E> cleft = cur, cright = cur;
        //nBT.addLeft(cleft, cleft.getElement()); nBT.addRight(cright, cright.getElement());
            while(cleft != null) {
            cleft = left(cleft);
            nBT.addLeft(cleft, cleft.getElement());
            }
            while(cright != null) {
            cright = right(cright);
            nBT.addRight(cright, cright.getElement());
            }
        }
        return nBT;
    }

 //}

 public void swap(Node<E> p, Node<E> q) {
    E tmp1 = p.getElement(), tmp2 = q.getElement();
    boolean checkP = checkIfCon(p, this.root()), checkQ = checkIfCon(q, this.root());
    if(checkP == false || checkQ == false) return;
    else {
        this.set(p, tmp2);
        this.set(q, tmp1);
    }
    
    // if(q.parent == p) {
    //     //parent(p).rightChild
    //     if(p.parent.getRight() == p) {
    //         if(p.getRight() == q) {
    //         Node<E> qr = q.getRight(), ql = q.getLeft();
    //         q.setRight(p);
    //         p.parent.setRight(q);
    //         p.left.setParent(q);
    //         p.setParent(q);
    //         p.setRight(qr);
    //         p.setLeft(ql);
    //         }else if(p.getLeft() == q) {
    //         Node<E> qr = q.getRight(), ql = q.getLeft();
    //         q.setLeft(p);
    //         p.parent.setLeft(q);
    //         p.right.setParent(q);
    //         p.setParent(q);
    //         p.setRight(qr);
    //         p.setLeft(ql);
    //         } 
    //     }else if(p.parent.getLeft() == p) {
    //         if(p.getRight() == q) {
    //         Node<E> qr = q.getRight(), ql = q.getLeft();
    //         q.setRight(p);
    //         p.parent.setLeft(q);
    //         p.left.setParent(q);
    //         p.setParent(q);
    //         p.setRight(qr);
    //         p.setLeft(ql);
    //         }else if(p.getLeft() == q) {
            
    //         }
    //     }
    // }else if(p.parent == q) {
    //     if(q.parent.getRight() == q) {
    //         if(q.getRight() == p) {

    //         }else if(q.getLeft() == p) {

    //         }
    //     }else if(q.parent.getLeft() == q) {
    //         if(q.getRight() == p) {

    //         }else if(q.getLeft() == p) {

    //         }
    //     }
    // }else { //the two nodes p and q are siblings and swapping them means more steps than the above case

    // }

 }
 
//  public Position<E> findLastPositionReference() {
//     Position<E> h;
//     if(isEmpty()) {
//        h = root();
//     }else {
//         h = last; // assumed reference to current last position
//         while (!isRoot(h) && h == right(parent(z)))
//             h = parent(h); // walk upward
//             if (!isRoot(h))
//             h = right(parent(h)); // then go to right sibling
//             while (!isExternal(h)) // and finally
//             h = left(h); 
//     }   
    
//     return h;
// }
 

 public static void main(String[] args) {
    //  LinkedBinaryTree<Integer> t1 = new LinkedBinaryTree<>();
    //  List<Position<Integer>> list1 = new ArrayList<>();
    //  LinkedBinaryTree<Integer> t2 = new LinkedBinaryTree<>();
    //  List<Position<Integer>> list2 = new ArrayList<>();
    //  t1.addRoot(0);
    //  t2.addRoot(0);
    //  int k = 1, j = 2;
    //  for(int i = 0; i < 6; i++) {
    //     t1.addLeft(t1.root(), i);
    //     t1.addRight(t1.root(), k);
    //     k++;
    //  }

    //  for(int p = 0; p < 6; p++) {
    //     t2.addLeft(t2.root(), p);
    //     t2.addRight(t2.root(), j);
    //     j++;
    //  }

    //  System.out.println(t1.testIfIsomorphic(t1.left(t1.root()), t2.left(t2.root()) t1, t2, list1, list2));
    Node<Integer> ro = new Node<Integer>(0, null, null, null);
    Node<Integer> rl = new Node<Integer>(2, ro, null, null);
    Node<Integer> rr = new Node<Integer>(4, ro, null, null);
    Node<Integer> rll = new Node<Integer>(6, rl, null, null);
    Node<Integer> rrr = new Node<Integer>(8, rr, null, null);
   
    //Node<Integer> recieved = pruneSubtree(ro);

     }


 }
 
 //----------- end of LinkedBinaryTree class ----------
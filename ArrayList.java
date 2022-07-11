import java.util.NoSuchElementException;
import java.util.Random;

public class ArrayList<E> implements List<E> {
     // instance variables
public static final int CAPACITY = 16; // default array capacity
private E[ ] data; // generic array used for storage
private int size = 0; // current number of elements
     // constructors
 public ArrayList( ) { this(CAPACITY); } // constructs list with default capacity
// constructs list with given capacity
 public ArrayList(int capacity) { 
   data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
}

 public int size( ) { return size; }
 
 public boolean isEmpty( ) { return size == 0; }
 //∗∗ Returns (but does not remove) the element at index i. ∗/
 public E get(int i) throws IndexOutOfBoundsException {
 checkIndex(i, size);
 return data[i];
 }
 //∗∗ Replaces the element at index i with e, and returns the replaced element. ∗/
 public E set(int i, E e) throws IndexOutOfBoundsException {
    checkIndex(i, size);
    E temp = data[i];
    data[i] = e;
    return temp;
 }

 //∗∗ Inserts element e to be at index i, shifting all subsequent elements later. ∗/
public void add(int i, E e) throws IndexOutOfBoundsException { //IllegalStateException 
   //checkIndex(i, size + 1);
   if(size == data.length) {
       resize(2 * data.length);
   }
//    if (size == data.length) // not enough capacity
//    throw new IllegalStateException("Array is full");
   for (int k = size-1; k >= i; k--) // start by shifting rightmost
    data[k+1] = data[k];
    data[i] = e; // ready to place the new element
    size++;
 }

 public void add(E e) throws IndexOutOfBoundsException { //IllegalStateException 
   //checkIndex(i, size + 1);
   int i = 0;
   if(size == data.length) {
       resize(2 * data.length);
   }
//    if (size == data.length) // not enough capacity
//    throw new IllegalStateException("Array is full");
   for (int k = size-1; k >= i; k--) // start by shifting rightmost
    data[k+1] = data[k];
    data[i] = e; // ready to place the new element
    size++;
 }

 public void addWithNoShifting(int i, E e) {
   E hold = data[i]; 
   data[i] = e;
   if(size == data.length) {
       resize(data.length+1);
    }
    //E hold = data[i];
   //  data[i] = e;
    data[data.length] = hold;

 }

 protected void resize(int capacity) {
    E[] temp = (E[]) new Object[capacity];
    for(int i = 0; i < data.length; i++) {
        temp[i] = data[i];
    }
    //temp[temp.length] = null;
    data = temp;
 }

 protected void trimToSize() {
    if(size != data.length) {
       resize(size);
    }
 }
 
 //∗∗ Removes/returns the element at index i, shifting subsequent elements earlier. ∗/
 public E remove(int i, String string) throws IndexOutOfBoundsException {
   checkIndex(i, data.length);
   E temp = data[i];
    for (int k=i; k < size-1; k++) // shift elements to fill hole
     data[k] = data[k+1];
     data[size-1] = null; // help garbage collection
     size--;
    return temp;
 }

//  public void removeResize(int k) throws IndexOutOfBoundsException {
//    checkIndex(k, data.length);
//    int N = data.length;
//    for(int j = k; j < size-1; j++) {
//       data[j] = data[j+1];
//    }
//    data[size-1] = null;
//    size--;
//    if(size < N/4) {
//       N = N/2;
//       E[] newData = (E[] ) new Object[N]; 
//       for(int p = 0; p < size; p++) {
//          newData[p] = data[p];
//       }
//       data = newData;
//    }
//  }




 public boolean contains(E e) {
    boolean res = false;
    for(int i = 0; i < size; i++) {
      if(data[i] == e) {
      res = true;
      break;
      }
    }
    return res;
 }

 
 public void shuffle() {
   if(isEmpty()) return;
   Random newR = new Random();

   for(int i = 0; i < size(); i++) {
      int ranIndToS = newR.nextInt(size());
      E tmp =  data[ranIndToS];
      data[ranIndToS] = data[i];
      data[i] = tmp;
   }

 }

 // utility method
 /** Checks whether the given index is in the range [0, n−1]. **/
 protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
    if (i < 0 || i >= n)
    throw new IndexOutOfBoundsException("Illegal index: " + i);
    }

 private class ArrayIterator implements Iterator<E> {
   private int j = 0; // index of the next element to report
   private boolean removable = false; // can remove be called at this time?
      
   //  /∗∗
   //  ∗ Tests whether the iterator has a next object.
   //  ∗ @return true if there are further objects, false otherwise
   //  ∗/
   public boolean hasNext( ) { return j < size; } // size is field of outer instance
      
   //  /∗∗
   //  ∗ Returns the next object in the iterator.
   //  ∗
   //  ∗ @return next object
   //  ∗ @throws NoSuchElementException if there are no further elements
   //  ∗/
   public E next( ) throws NoSuchElementException {
      if (j == size) throw new NoSuchElementException("No next element");
      removable = true; // this element can subsequently be removed
      return data[j++]; // post-increment j, so it is ready for future call to next
      }
      
      //  /∗∗
      //  ∗ Removes the element returned by most recent call to next.
      //  ∗ @throws IllegalStateException if next has not yet been called
      //  ∗ @throws IllegalStateException if remove was already called since recent next
      //  ∗/
   public void remove( ) throws IllegalStateException {
      if (!removable) throw new IllegalStateException("nothing to remove");
      ArrayList.this.remove(j-1, "cannot remove anything from an empty array", "cannot remove anything from an empty array"); // that was the last one returned
      j--; // next element has shifted one cell to the left
      removable = false; // do not allow remove again until next is called
      }
   } //------------ end of nested ArrayIterator class ------------
      
       //∗∗ Returns an iterator of the elements stored in the list. ∗/
   public Iterator<E> iterator( ) {
      return new ArrayIterator( ); // create a new instance of the inner class
   }

    public static void main(String[] args) {
       int cap = 20;
       ArrayList<Integer> newAL = new ArrayList<Integer>(cap); 
       int i = 1;
       for(int j = 0; j < 6; j++) 
         newAL.add(j, i+=2);
       //System.out.println(newAL.size());
       //newAL.trimToSize();
      //  int k = 3;
      //  for(int i = 0; i < ; i++) { 
      //  newAL.add(i, k);
      //  k += 3;
      //  }
      //  for(int j = 0; j < newAL.size(); j++) {
      //     System.out.println(newAL.get(j));
      //  }
      //  newAL.addWithNoShifting(2, 100);
      //  for(int p = 0; p < newAL.size(); p++) 
      //    System.out.println(newAL.get(p));

      //    System.out.println(newAL.size());

      // for(int k = 0; k < newAL.size(); k++) {
      //    System.out.print(newAL.get(k) + " ");
      // }
      // System.out.println();
      // System.out.println(newAL.contains(3));
      // System.out.println();
      // newAL.shuffle();
      




    }
   

 }
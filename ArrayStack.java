public class ArrayStack<E> implements Stack<E> {
 public static final int CAPACITY=1000; // default array capacity
 private E[ ] data; // generic array used for storage
 private int t = -1; // index of the top element in stack
 public ArrayStack( ) { this(CAPACITY); } // constructs stack with default capacity

 public ArrayStack(int capacity) { // constructs stack with given capacity
 data = (E[ ]) new Object[capacity]; // safe cast; compiler may give warning
 }
 public int size( ) { return (t + 1); }
 public boolean isEmpty( ) { return (t == -1); }

 public void push(E e) {
 if (size( ) == data.length) 
 data[++t] = e; // increment t before storing new item
 }

 public void resize(int capacity) {
     E[] newData = (E[]) new Object[capacity];
     for(int j = 0; j < size(); j++) {
        newData[j] = data[j];
     }
     data = newData;
 }

 public E top( ) {
 if (isEmpty( )) return null;
 return data[t];
 }

 public E pop( ) {
 if (isEmpty( )) return null;
 E answer = data[t];
 data[t] = null; // dereference to help garbage collection
 t--;
 return answer;
 }

 public void popEverything() {}

 // public void popEverythingRec(int s);

  public void transfer(Stack<E> s) {}

  public void transferOth(Stack<Integer> s, Stack<Integer> t) {}

}
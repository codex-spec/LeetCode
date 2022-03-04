public interface Stack<E> {
    public int size(); 
    
    public void push(E e);
    
    public E pop();

    public E top();

    boolean isEmpty();

     public void popEverything();

    // public void popEverythingRec(int s);

     public void transfer(Stack<E> s);

     public void transferOth(Stack<Integer> s, Stack<Integer> t);
}
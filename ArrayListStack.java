public class ArrayListStack<E> implements Stack<E> {
    private ArrayList<E> al = new ArrayList<E>();

    public ArrayListStack() {}

    public int size() {return al.size();}
    
    public void push(E e) {
        E ele = e;
        al.add(al.size(), ele);
    }
    
    public E pop() {
        E ele = null;
        if(al.isEmpty()) {
            System.out.println("noting to pop since stack is empty");
        }else {
            ele = al.remove(al.size()-1);
        }
        return ele;
    }

    public E top() {
        return al.get(al.size()-1);
        //return topValue;
    }

    public boolean isEmpty() {return al.size() == 0;}

    public void popEverything() {
        if(al.size() != 0) {
            for(int i = al.size()-1; i >= 0; i--) {
                this.pop();
            }
        }else {System.out.println("could not pop elements in the stack since the stack is empty");}

    }

    //  public void popEverythingRec(int cv, ArrayList<E> someArrL) {
    //     if(cv == 0 || someArrL.size() == 0) {
    //         ;
    //     }else {
    //         someArrL.pop(cv);
    //         popEverythingRec(cv-1, someArrL);
    //     }
    //  }

    public void transfer(Stack<E> s) {}

    public void transferOth(Stack<Integer> s, Stack<Integer> t) {}

     public static void main(String[] args) {
         ArrayListStack<Integer> als = new ArrayListStack<Integer>();
         als.push(2);
         als.push(4);
         als.push(6);
         als.push(8);
         als.push(10);

         System.out.println(als.pop());
         System.out.println(als.top());
         System.out.println(als.size());
         System.out.println(als.isEmpty());
         als.popEverything();
         System.out.println(als.isEmpty());


     }

}
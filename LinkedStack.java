
public class LinkedStack<E> implements Stack<E> {
    SinglyLinkedListM<E> listOne = new SinglyLinkedListM<E>();

    public LinkedStack() {}

    public int size() {
        return listOne.Size();
    }

    public void push(E ele) {
        listOne.addFirst(ele);
    }

    public E pop() {
        return listOne.removeFirst();
    }

    public boolean isEmpty() {
        return listOne.isEmpty();
    }

    public E top() {
        return listOne.getFirst();
    }

    public void popEverything() {
        if(this.isEmpty()) {;}
        else {
        for(int i = 0; i < this.size(); i++) {
            this.pop();
        }
       }
    }
    
    public void popEverythingRec(int s) {
        s = this.size();
        if(this.isEmpty()) return;
        else {
            this.pop();
            popEverythingRec(s-1);
        }
    }

    public void transfer(Stack<E> s) {
        if(s.isEmpty()) {
            return;
        }
        this.popEverything();
        for(int i = 0; i < s.size(); i++) {
            E ele = s.pop();
            this.push(ele);
        }
        
    }
    //Due to the compiler not allowing to create a generic array we will set the stack values be the Integer Wrapper class
    public void transferOth(Stack<Integer> s, Stack<Integer> t) {
        if(s.isEmpty()) return;
        int[] aE = new int[s.size()];
        t.popEverything();
        for(int i = 0; i < s.size(); i++) {
            aE[i] = s.pop();
        }

        for(int j = aE.length-1; j > 0; j--) {
            t.push(aE[j]);
        }
    }

    

}
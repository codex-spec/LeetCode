public class ProgressionIterator<E> implements Iterator<E> {

    protected E current;
    
    public ProgressionIterator() {this(0);}

    public ProgressionIterator(E start) {current = start;}

    public boolean hasNext() {
        if((int) nextValue() != 0) {
            return true;
        }
        return false;
    }

    
    public E next() {
        advance();
        E ele =  current;
        return ele;
    }

    public E nextValue() {
        E answer = current;
        advance();
        return answer;
    }

    protected void advance() {
       (int) current++;
    }

    public void printProgression(int n) {
        System.out.print(nextValue());
        for(int j = 1; j < n; j++) {
            System.out.print(" " + nextValue());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ProgressionIterator<Integer> p1 = new ProgressionIterator<Integer>(1);
        System.out.println(p1.hasNext());
        System.out.println(p1.next());
        p1.printProgression(20);

    }

}
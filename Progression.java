public class Progression {
    protected long current;
    public Progression( ) { this(0); }
   
    public Progression(long start) { current = start; }
   
    public long nextValue( ) {
       long answer = current;
        advance( ); 
       return answer;
    }
   
    protected void advance( ) {
       current++;
    }
   
    public void printProgression(int n) {
       System.out.print(nextValue( )); 
       for (int j=1; j < n; j++)
       System.out.print(" " + nextValue( )); 
       System.out.println( ); 
    }
   }
   
   class FibonacciProgression extends Progression {
    protected long prev;
    public FibonacciProgression( ) { this(0, 1); }
   
    public FibonacciProgression(long first, long second) {
       super(first);
       prev = second - first; 
    }
   
    protected void advance( ) {
       long temp = prev;
       prev = current;
       current += temp;
    }
   }
   
   class TestFibProgression {
       public static void main(String[] args) {
        Progression p = new FibonacciProgression(2, 2);
           System.out.println("the fibonacci sequence which starts at 2 and 2 for first and second value,  will continue till the 8th value");
           p.printProgression(8);
           System.out.println("\n");
       }
   }
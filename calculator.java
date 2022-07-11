import java.util.Random;
import java.util.Scanner;

/*
*this will be a class in generics to calculate a variety of input in a multi-used calculator
*/
//import java.util.random.*;


public class calculator {
    private int var1;
    private String var2; 
    static Scanner sc = new Scanner(System.in);
    private static Random r = new Random();


    calculator(int id) {

        this.var1 = id;
    }

    calculator(int id, String val2) {
        var1 = id;
        var2 = val2;
    }

    public int getOnlyInput() {return var1;}
    public String getNameInput() {return var2;}

    

    /*
    public static int getTypeOfConversion() {
        //String[] types = {"number", "decimal", "binary", "hexadecimal", "octal", "fraction", "improper fraction"};
        System.out.println("please type in which type of input you want to calculate");
        System.out.println("input 1 for number or decimal\n input 2 for binary\n input 3 for hexadecimal\n input 4 for octal\n input 5 for fraction\n input 6 for improper fraction");
        
        sc.nextLine();
        return (sc.equals("1")) ? 1 : (sc.equals("2")) ? 2 : (sc.equals("3")) ?
        3 : (sc.equals("4")) ? 4 : (sc.equals("5")) ? 5 : (sc.equals("6")) ? 6 : 0;
    }
    */
    public static int getTypeOfOperationForDecOrNum() {
        System.out.println("which one do you want to do? 1 for multiply, 2 for subtract, 3 for divide, 4 for add, 0 for neither");
        int l  = sc.nextInt();
        
        return l;
    }

    //number, decimal, binary, hexadecimal, octal, fraction, improper fraction
    public int doCalc() {
        int o = getTypeOfOperationForDecOrNum();
        //System.out.println("\n");
        System.out.println("please enter the first input");
        int input = sc.nextInt();
        
        System.out.println("please enter the second input");
        int secIn = sc.nextInt();
        if(o == 1) return (input * secIn);
        else if(o == 2) return input - secIn;
        else if(o == 3) return input / secIn;
        else if(o == 4) return input + secIn;
        else return 0;
        //return ((o == 1) ? (input * secIn) : (o == 2) ? input - secIn : (o == 3) ? input / secIn : (o == 4) ? input + secIn : 0);
    }

    public int getCalcVal() {
        return doCalc();
    }

    public String toString() {
        // System.out.println("Please type in your name");
        // String n = sc.nextLine();
        // System.out.println("please enter the input ");
        String s = "the result of " + getNameInput() + " calculation is " + getCalcVal();
        return s;
    }

    /*
    public static boolean isEmpty(int[] arr) {
        int k = 0, j = 0;
        while(arr[k] < arr.length) {
            if(arr[j] == 0) {
                j++;
            }
            k++;
        }
        return (j != arr.length) ? false : true;
    }

    public static boolean checkArrayEmpty(int[] arr) {
        int rnum = r.nextInt(arr.length);
        while(isEmpty(arr) == false) {
            arr[rnum] = 0;
            rnum = r.nextInt(arr.length);
        }

        return (isEmpty(arr)) ? true : false;
    }
    */
    public static void main(String[] args) {
        calculator c1 = new calculator(2, "abu");
        System.out.println(c1.toString()); 

        // int[] someA = {2, 4, 6, 12, 46};
        // System.out.println(checkArrayEmpty(someA));

    }


}

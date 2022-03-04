

public class practiceDataStructNAlgoChFiveSol {
    static int maxV(int[] ar, int s) {
        if(s == ar.length-1) {
            return Math.max(ar[s-1], ar[s]);
        }
         return Math.max(ar[s], maxV(ar, s+1));   
    }
    
    static int convertStringToInt(String s, int in) {
        String ns = "";
        if(in == s.length()) {
            return Integer.parseInt(ns);
        }
        if(in % 4 == 3 ) {
            ns += ",";
        }else {
            ns += s.charAt(in);
        }
        return convertStringToInt(s, in+1);
    }
    
    int countPrime(int[] ray, int i) {
        int c = 0;
        if(ray[i] % 2 == 0 && ray[i] % 3 == 0 && ray[i] % 4 == 0 && ray[i] % 5 == 0)
        c++;
        if(i == ray.length)
        return c;
        else
        return countPrime(ray, i+1);
    }
    //QR-5.9 
     static double power(double x, int n) { 
        double val = 1; 
        if(n == 0 || x == 1) return 1.0;
        else if(n == 1) return x;
        else if(x == 0) return 0;
        else if(n < 0) Math.abs(n);
        for(int i = 0; i < n; i++) { 
        val *= x; 
         } 

        if(x < 0 && n % 2 == 1) val *= -1;
        val = (n < 0) ? 1/val : val;
        return val; 
        }  
        //QR-5.10
    static int sum2DArr(int[][] arr, int r, int c) {
            if(r == 0 && c == 0) {
                return arr[0][0];
            }else if(c == 0 && r != 0) {
               // s += arr[r][c];
                return sum2DArr(arr, r-1, arr.length-1)+arr[r][c];
            }else {
                return sum2DArr(arr, r, c-1)+arr[r][c];
            }
            // s = sum2DArr(arr[r][c-1]);
        }
        //c-5.11
    static int logInteger(int logValue) {
        if(logValue <= 1) {
            return 0;
        }else {
            return 1 + logInteger(logValue/2);
        }
    }
    //c-5.12
    static boolean eleUni(int[] sa, int i, int k) {
        if(sa.length <= 1) return true;
        
        if(sa[i] == sa[k] && i != k) {
            return false;
        }else if(i == sa.length-1 && k == sa.length-2 && sa[i] != sa[k]) {
            return true;
        }else if(k == sa.length-1) {
            return eleUni(sa, i+1, 0);
        }else {
            return eleUni(sa, i, k+1);
        }
    }
    //c-5.13
    static int productOfTwoPositiveInt(int m, int n, int c) {
        if(m < 0 && n < 0) {m = Math.abs(m); n = Math.abs(n);}
        else if(m == 0 || n == 0) {return 0;}
        int b = Math.max(m, n), l = Math.min(m, n);;
        if(c == l) {
            return 0;
        }else {
            b = b + productOfTwoPositiveInt(b, l, c+1);
        }
        return b;
    }
    
    //c-5.15
    static void subsetOfEle(String s, int i, String out) {
        //double co = Math.pow(2, i);
        int n = s.length()-1; String res = "";
        if(i == n) {
            System.out.println(res);
            return;
        }else {   

       subsetOfEle(s, i+1, res += s.charAt(i));
       subsetOfEle(s, i+1, res);
        }
    }

    static int factorial(int n) {
        if(n == 0) {
            return 1;
        }
        return n * factorial(n-1);
    }
    
    static int fibonacci(int n) {
        if(n <= 1) {
            return 0;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    static String reverseString(String s, int b, int e) {
        if(b > e) {
            return s;
        }else {
            char tmp = s.charAt(b);
            s.replace(s.charAt(b), s.charAt(e));
            s.replace(s.charAt(e), tmp);
        }
        return reverseString(s, b+1, e-1);
    }

    static boolean isPalindrome(String some, int i, int e) {
        if(i == e || some.isEmpty()) return true;
        return (some.charAt(i) == some.charAt(e) && isPalindrome(some, i+1, e-1));
    }

    static boolean checkMoreVowelsThanConsonants(String w, int i) {
        int cv = 0, cc = 0;
        if(i == w.length()-1) {
            return (cv > cc) ? true : false;
        }else if(w.substring(i, i+1).equalsIgnoreCase("A") || w.substring(i, i+1).equalsIgnoreCase("E") || w.substring(i, i+1).equalsIgnoreCase("I") || w.substring(i, i+1).equalsIgnoreCase("O") || w.substring(i, i+1).equalsIgnoreCase("U") || w.substring(i, i+1).equalsIgnoreCase("Y")) {
            ++cv;
        }else {
            ++cc;
        }
        return checkMoreVowelsThanConsonants(w, i+1);
    }
    public static void main(String[] args) {
       
        //StringBuilder a = putStringIntoSB(some, 0);
        //System.out.println(convertStringToInt(some, 0));
        String str = "Equation";
        System.out.println(isPalindrome(str, 0, str.length()-1));
        System.out.println(checkMoreVowelsThanConsonants(str, 0));

        int[][] ar =  {
            {2, 4, 6},
            {8, 9, 9}
        };
       
        int f = 4;
        System.out.println(factorial(f));

        int m = 8, n = 7;
        String ss = "abc";
        subsetOfEle(ss, 0, "");

        System.out.println(productOfTwoPositiveInt(m, n, 0));

        
        int[] otha = {1,1,34,12,74};
        System.out.println(eleUni(otha, 0, 1));

        System.out.println("\n");
        int val = 56;
        System.out.println(logInteger(val));

        //System.out.println(sum2DArr(ar, 1, ar[1].length));
        System.out.println(power(2, 1));
        int[] t = {2, 4, 1, 0, 36, 8, -3, -2, 1, 2, 5, 3};
        System.out.println("\n");
        System.out.println(maxV(t, 0));


        String other = "cars";
        System.out.println(reverseString(other, 0, other.length()-1));


    }
}
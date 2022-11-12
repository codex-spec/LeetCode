// Pow(x, n)

// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).



class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        if(x == 1 || n == 0 || (x == -1 && (n % 2) == 0)) return 1;
        if(x == 0 || (n > 2147483647 || n < -2147483647)) return 0;
        
        else if(x == -1) return -1;
        if(n >= 1) {
            int i = 0;
            while( i < n) {
                res *= x;
                i++;
            }
        }else if(n < 0) {
            //res = 1/x;
            int j = 0;
            while(j != n) {
                res *= 1/x;
                j--;
            }
        }
        
        return res;
    }
}
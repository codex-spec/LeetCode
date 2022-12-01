//Reverse Integer 


//Given a signed 32-bit integer x, return x with its digits reversed. 
//If reversing x causes the value to go outside the signed 32-bit 
//integer range [-231, 231 - 1], then return 0.

class Solution {
    public int reverse(int x) {
       int res = 0, sum = x;
     
        boolean isNegative = sum<0;
        if(isNegative){
            sum=sum*-1;
        }
        
        long nN = 0;
        
        while(sum>0){
            int lastD = sum%10;
            nN = (nN*10) + lastD;
            sum = sum/10;
        }
        
        if(nN > Integer.MAX_VALUE){
            return 0;
        }
        
        if(isNegative){
            nN = nN*-1;
        }
        
        return (int)nN;
  }
}    

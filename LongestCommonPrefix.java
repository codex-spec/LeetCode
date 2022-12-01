//LongestCommonPrefix
//write a function to find the longest common prefix string amongst an array of strings
//If there is no common prefix, return an empty string ""

class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String r = "";
        int size = strs.length;
        Arrays.sort(strs);
        
        if(size == 0) return ""; 
        else if(size == 1) return strs[0];
        
        int l = strs[0].length();
        
            for(int i = 0; i < l; i++){
             if(strs[0].charAt(i) == strs[size - 1].charAt(i)){
               r += (strs[0].charAt(i));
             }
             else{
               break;
             }
           }
        return (String) r;
        
        }
        
    }

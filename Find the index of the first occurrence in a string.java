// Find the Index of the First Occurrence in a String

// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.



class Solution {
    public int strStr(String haystack, String needle) {
        int nLen = needle.length(), hsLen = haystack.length();
        int inRes = -1; //index of the result of the where the needle is identified
        if(nLen == hsLen) {
            if(haystack.equals(needle)) return 0;
            else return -1;
        }
        
        
        if(nLen > hsLen) return -1;
        else {
            
            for(int i = 0; i <= hsLen-nLen; i++) {
                if(haystack.substring(i, i+nLen).equals(needle) ) {
                    inRes = i;
                    break;
                }
            }
            
        }
        return inRes;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;
        else if(s.length() == 1) return 1;
        
        
        int c = 0;
        String lV = "";
        for(int i = 0; i < s.length(); i++) {
            String cur = s.substring(i, i+1);

            for(int j = i+1; j < s.length(); j++) {
                if(cur.contains(s.substring(j, j+1) ) ) {
                    break;
                }else {
                    cur += s.substring(j,j+1);
                }
                
            }
                        if(cur.length() > lV.length()) lV = cur;
            c = lV.length();
        }
        
        return c;
    }
}
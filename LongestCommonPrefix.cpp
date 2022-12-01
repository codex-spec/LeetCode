string longestCommonPrefix(vector<string>& strs) 
    {
        string pre = "";
        
        if(strs.size() == 0 || strs[0].length() == 0 )
            return "";
        
        int cI = 0;
        char currSC = strs[0][cI];
        char currC;
        
        while(currSC != '\0')
        {
            bool isCD = false;
            for(int i = 0; i < strs.size() ; i++)
            {
                currC = strs[i][cI];
                
                if(currC != currSC || currC == '\0')
                {
                    isCD = true;
                    break;
                }
            }
            
            if(isCD)
                break;
            
            pre.push_back(currSC);
            currSC = strs[0][++cI];
        }
        
        return pre;
    }
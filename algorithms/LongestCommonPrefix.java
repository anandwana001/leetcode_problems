//https://leetcode.com/problems/longest-common-prefix/description/

//Problem



//Write a function to find the longest common prefix string amongst an array of strings.
//
//If there is no common prefix, return an empty string "".
//
//Example 1:
//
//Input: ["flower","flow","flight"]
//Output: "fl"
//Example 2:
//
//Input: ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
//Note:
//
//All given inputs are in lowercase letters a-z.



//Solution



class Solution {
    public String longestCommonPrefix(String[] strs) {
        
         if(strs.length==0) return "";
        
        int min = strs[0].length();  
       
        String prefix = ""; 
        
        for(int i=0; i < min ;i++){    
        
            for(int j =  1 ; j<strs.length; j++){
          
                if(strs[j].length()==0)
                    return "";
                
                if(strs[0].charAt(i) != strs[j].charAt(i))
                return prefix; 
          
                
                 if (min > strs[j].length())
                 min = strs[j].length();     
        }
            
        prefix += strs[0].charAt(i); 
 
        }
      
        return prefix; 
        
    }
}
//https://leetcode.com/problems/length-of-last-word/description/

//Problem

//Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

//If the last word does not exist, return 0.

//Note: A word is defined as a character sequence consists of non-space characters only.

//Example:

//Input: "Hello World"
//Output: 5


class Solution {
    public int lengthOfLastWord(String s) {
        boolean char_flag = false; 
        int lenght = 0; 
        for (int i=a.length()-1; i>=0; i--) 
        { 
            if (Character.isLetter(a.charAt(i))) 
            { 
                // Once the first chracter from last 
                // is encountered, set char_flag to true. 
                char_flag = true; 
                lenght++; 
            } 
            else
            { 
                // When the first space after the characters 
                // (from the last) is encountered, return the 
                // length of the last word 
                if (char_flag == true) 
                    return lenght; 
            } 
        } 
        return lenght; 
    }
}

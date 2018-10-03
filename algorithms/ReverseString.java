//https://leetcode.com/problems/reverse-string/

//Problem

//Write a function that takes a string as input and returns the string reversed.

//Example 1:

//Input: "hello"
//Output: "olleh"

//Example 2:

//Input: "A man, a plan, a canal: Panama"
//Output: "amanaP :lanac a ,nalp a ,nam A"


//Solution



class Solution {
    public String reverseString(String s) {
        StringBuilder reversedString = new StringBuilder(s);
		return reversedString.reverse();        
    }
}
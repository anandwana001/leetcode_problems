//https://leetcode.com/problems/reverse-vowels-of-a-string/description/

//Problem

//Write a function that takes a string as input and reverse only the vowels of a string.

//Example 1:

//Input: "hello"
//Output: "holle"

//Example 2:

//Input: "leetcode"
//Output: "leotcede"


//Solution



class Solution {
    public String reverseString(String s) {
        char[] str = s.toCharArray();
        Set<String> vowels = new HashSet<>(Arrays.asList("a", "e", "i", "o", "u"));
        int startIndex = 0;
        int endIndex=s.length()-1;
        char[] str = s.toCharArray();
		char temp;

        while (startIndex < s.length() && endIndex > 0) {
			if (vowels.contains(String.valueOf(str[startIndex]))) {
				if (vowels.contains(String.valueOf(str[endIndex]))) {
					temp = str[endIndex];
					str[endIndex] = str[startIndex];
					str[startIndex] = temp;
					startIndex++;
					endIndex--;
				} else {
					endIndex--;
				}
			} else {
				startIndex++;
			}
			if(startIndex==endIndex) {
				break;
			}
		}        
		return String.valueOf(str);        
    }
}
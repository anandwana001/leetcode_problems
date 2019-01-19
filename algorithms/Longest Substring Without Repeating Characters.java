//https://leetcode.com/problems/longest-substring-without-repeating-characters/

//Problem

/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

//Solution

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int ans = 0, i =0, k =0;
        while(k<s.length() && i<s.length()){
            if(!set.contains(s.charAt(k))){
                set.add(s.charAt(k++));
                ans = Math.max(ans, k-i);
            }
            else {
                set.remove(s.charAt(i++));
            }
            
        }
        return ans;
    }
}
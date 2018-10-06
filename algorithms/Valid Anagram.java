//https://leetcode.com/problems/valid-anagram

//Given two strings s and t , write a function to determine if t is an anagram of s.

//Example 1:

//Input: s = "anagram", t = "nagaram"
//Output: true

//Example 2:

//Input: s = "rat", t = "car"
//Output: false

//Note:
//You may assume the string contains only lowercase alphabets.

//Follow up:
//What if the inputs contain unicode characters? How would you adapt your solution to such case?


//Solution

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }
            else {
                int val = map.get(s.charAt(i));
                map.remove(s.charAt(i));
                map.put(s.charAt(i), val+1);
            }
        }
        for(int i=0; i<t.length(); i++){
            if(map.containsKey(t.charAt(i))){
                int val = map.get(t.charAt(i));
                if(val == 1)
                    map.remove(t.charAt(i));
                else {
                    map.remove(t.charAt(i));
                    map.put(t.charAt(i), val-1);
                } 
            }
            else 
                return false;
        }
        return true;
    }
}

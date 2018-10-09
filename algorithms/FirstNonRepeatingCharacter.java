// https://leetcode.com/problems/first-unique-character-in-a-string/description/


// Problem:
// Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.


// Examples:

// Example 1
// Input: "leetcode"
// Output: 0

// Example 2
// Input: "loveleetcode"
// Output: 2

// Note: You may assume the string contain only lowercase letters. 


// Solution
class FirstNonRepeatingCharacter {
	public int firstUniqChar(String s) {
		if (s == null || s.isEmpty())
			return -1;

		for (char c : s.trim().toCharArray()) {
			if (s.indexOf(c) == s.lastIndexOf(c))
				return s.indexOf(c);
		}
		return -1;
	}
}

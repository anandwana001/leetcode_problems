# https://leetcode.com/problems/palindrome-number/

# Problem



# Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.


# Example:
#
# Example 1:
#
# Input: 121
# Output: true
# Example 2:
#
# Input: -121
# Output: false
# Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
# Example 3:
#
# Input: 10
# Output: false
# Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


# Solution



class Solution:
    def isPalindrome(self, x: int) -> bool:
        str_x = str(x)
        return str_x == str_x[::-1]

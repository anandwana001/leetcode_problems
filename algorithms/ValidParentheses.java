//https://leetcode.com/problems/valid-parentheses/description/

//Problem

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

//An input string is valid if:

//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Note that an empty string is also considered valid.

//Example 1:

//Input: "()"
//Output: true
//Example 2:

//Input: "()[]{}"
//Output: true
//Example 3:

//Input: "(]"
//Output: false
//Example 4:

//Input: "([)]"
//Output: false
//Example 5:

//Input: "{[]}"
//Output: true




//Solution



class Solution {
    public boolean isValid(String str) {
        
         if(str.isEmpty())
            return true;
        
        if (str.charAt(0) == '}')
            return false;
        else if (str.charAt(0) == ')')
            return false;
        else if (str.charAt(0) == ']')
            return false;
        
        Stack<Character> stack = new Stack<Character>();
        
        char c;
    for(int i=0; i < str.length(); i++) {
        
        c = str.charAt(i);

        if(c == '(')
            stack.push(c);
        
        else if(c == '{')
            stack.push(c);
        
        else if(c == '[')
            stack.push(c);
        
        else if(c == ')')
            if(stack.empty())
                return false;
            else if(stack.peek() == '(')
                stack.pop();
            else
                return false;
        
        else if(c == '}')
            if(stack.empty())
                return false;
            else if(stack.peek() == '{')
                stack.pop();
            else
                return false;
        
        else if(c == ']')
            if(stack.empty())
                return false;
            else if(stack.peek() == '[')
                stack.pop();
            else
                return false;
        
        
    }
    return stack.empty();
    }
}
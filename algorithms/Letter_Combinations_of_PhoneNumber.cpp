#Letter Combinations of A PhoneNumber
//Problem_Link : https://leetcode.com/problems/letter-combinations-of-a-phone-number/

//Problem Statement: Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
//A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

//Example:
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//Note:
//Although the above answer is in lexicographical order, your answer could be in any order you want.

//Solution:

// Time Complexity: O(3^n)
// Space Complexity: O(n)

class Solution {
    public:
        const vector<string> keyboard { " ", "", "abc", "def", // '0','1','2',...
            "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        vector<string> letterCombinations(string digits) {
            vector<string> ans;
            string path;
            dfs(digits, 0, path, ans);
            return ans;
        }

    private:
        void dfs(const string &digits, size_t cur, string &path, vector<string> &ans) {
            if(cur == digits.size()) {
                ans.push_back(path);
                return;
            }

            for(auto c: keyboard[digits[cur] - '0']) {
                path.push_back(c);
                dfs(digits, cur + 1, path, ans);
                path.pop_back();
            }
        }
};

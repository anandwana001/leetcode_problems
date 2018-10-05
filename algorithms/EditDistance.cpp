// Problem Link: https://leetcode.com/problems/edit-distance/

// Problem: Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

// 	You have the following 3 operations permitted on a word:

// 		1. Insert a character
// 		2. Delete a character
// 		3. Replace a character

// Example:

// 	Input: word1 = "horse", word2 = "ros"
// 	Output: 3
// 	Explanation: 
// 		horse -> rorse (replace 'h' with 'r')
// 		rorse -> rose (remove 'r')
// 		rose -> ros (remove 'e')

class Solution {
	
public:
    
    int min(int a, int b, int c) {
        if(a < b) {
            if(a < c)
                return a;
            else
                return c;
        }
        if(b < c)
            return b;
	    return c;
    }
    
    int minDistance(string s1, string s2) {
        vector< vector<int> > m(s1.size()+1, vector<int>(s2.size()+1));
        m[0][0] = 0;
		int delta;
		for(int i = 1; i < s1.size()+1; i++)
			m[i][0] = i;
		for(int j = 1; j < s2.size()+1; j++)
			m[0][j] = j;
		for(int i = 1; i < s1.size()+1; i++) {
			for(int j = 1; j < s2.size()+1; j++) {
				if(s1[i-1] == s2[j-1])
					delta = 0;
				else
					delta = 1;
				m[i][j] = min(m[i-1][j]+1, m[i][j-1]+1, m[i-1][j-1]+delta);
			}
		}
		return m[s1.size()][s2.size()];
        
    }
};
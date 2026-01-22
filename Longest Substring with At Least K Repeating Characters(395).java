import java.util.HashMap;
import java.util.Map;
class Solution {
    public int longestSubstring(String s, int k) {
        //n holds the length of input strings 
        int n =s.length();

        //counts is a hashmap that keeps track of how many times each letter appear
        Map<Character,Integer> counts=new HashMap<>();

        //Lets count how many times each letter showsn up
        for(char c:s.toCharArray()){
            counts.put(c,counts.getOrDefault(c,0)+1);
        }

        //Let's check each letter count in counts 
        for(char c:counts.keySet()){
             // Oops! This letter doesn't meet our 'at least k times' rule
            if(counts.get(c)<k){
                int maxLen=0;
                
                 // Time to split the string by the problem letter and see if parts of it work
                 for(String sub:s.split(String.valueOf(c))){
                    //Recursivly, let's check the smaller pieces
                    maxLen=Math.max(maxLen,longestSubstring(sub,k));

                 }
                   // Okay, what was the longest valid piece after splitting?
                 return maxLen;

            }
        }
        // Hooray! All letters show up at least k times, so the whole string is valid
        return n;

    }
}

/**

class Solution {
    public int longestSubstring(String st, int k) {
        int ans = 0;
        
        char[] s = st.toCharArray();
        
        int[] freq = new int[26];
        for (int i = 0; i < s.length; i++) {
            freq[s[i] - 'a']++;
        }
        
        int uniChars = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                uniChars++;
            }
        }
        
        for (int curr = 1; curr <= uniChars; curr++) {
            Arrays.fill(freq, 0);
            int start = 0, end = 0;
            int count = 0, count_k = 0;
            
            while (end < s.length) {
                if (count <= curr) {
                    int ind = s[end] - 'a';
                    if (freq[ind] == 0) {
                        count++;
                    }
                    freq[ind]++;
                    if (freq[ind] == k) {
                        count_k++;
                    }
                    end++;
                } else {
                    int ind = s[start] - 'a';
                    if (freq[ind] == k) {
                        count_k--;
                    }
                    freq[ind]--;
                    if (freq[ind] == 0) {
                        count--;
                    }
                    start++;
                }
                if (count == curr && count_k == curr) {
                    ans = Math.max(ans, end - start);
                }
            }
        }
        return ans;
    }
}
 */
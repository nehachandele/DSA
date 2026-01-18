import java.util.Arrays;
public class Valid_Anagram(242) {
   
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] str1=s.toCharArray();
        char[] str2=t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);

        return Arrays.equals(str1,str2);
    }

}
/**
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        
        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        
        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) - 1);
        }
        
        // Check if any character has non-zero frequency
        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }
        
        return true;
    }
}

 */



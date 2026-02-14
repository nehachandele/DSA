import java.util.*;

public class FrequencySortBNY {

    // ------------------------- Integer Array Version -------------------------
    public static int[] frequencySort(int[] arr) {
        // Step 1: Count frequency using HashMap
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert to Integer[] for custom sorting
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // Step 3: Sort by frequency descending, tie-breaker → ascending value
        Arrays.sort(temp, (a, b) -> {
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);
            if (freqA != freqB) return freqB - freqA; // high freq first
            return a - b; // low value first
        });

        // Step 4: Convert back to int[]
        return Arrays.stream(temp).mapToInt(Integer::intValue).toArray();
    }

    // ------------------------- String Version -------------------------
    public static String frequencySort(String s) {
        // Step 1: Count frequency of each character
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Convert string to Character[] for sorting
        Character[] chars = s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

        // Step 3: Sort by frequency descending, tie-breaker → lex order
        Arrays.sort(chars, (a, b) -> {
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);
            if (freqA != freqB) return freqB - freqA; // high freq first
            return a - b; // alphabetical order for tie
        });

        // Step 4: Build final string
        StringBuilder sb = new StringBuilder();
        for (char c : chars) sb.append(c);
        return sb.toString();
    }

    // ------------------------- Main for Quick Testing -------------------------
    public static void main(String[] args) {
        // Integer test
        int[] arr = {4, 5, 6, 5, 4, 3};
        System.out.println(Arrays.toString(frequencySort(arr))); // [4, 4, 5, 5, 3, 6]

        // String test
        String s = "tree";
        System.out.println(frequencySort(s)); // "eert"
    }
}

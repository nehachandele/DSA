import java.util.*;

class Solution {
    public static void sortBySetBitCount(int[] arr) {
        // Convert to Integer[] for custom comparator
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(temp, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);

            // Sort by set bits descending
            int cmp = Integer.compare(countB, countA);
            if (cmp != 0) return cmp;

            // If set bits equal → sort by value ascending
            return Integer.compare(a, b);
        });

        // Copy back to original array
        for (int i = 0; i < arr.length; i++) arr[i] = temp[i];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        sortBySetBitCount(arr);
        System.out.println(Arrays.toString(arr)); // [3, 1, 2, 4]
    }
}


import java.util.*;

class Solution {
    public static void sortBySetBits(int[] arr) {
        Arrays.sort(arr, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            if (countA != countB) return countB - countA;
            return a - b;
        });
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        // Use wrapper Integer[] to sort in-place with comparator
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, (a, b) -> {
            int c1 = Integer.bitCount(a);
            int c2 = Integer.bitCount(b);
            if (c1 != c2) return c2 - c1;
            return a - b;
        });
        // Copy back to original array
        for (int i = 0; i < arr.length; i++) arr[i] = boxed[i];
        System.out.println(Arrays.toString(arr));
    }
}

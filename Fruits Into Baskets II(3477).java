import java.util.Arrays;
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {

        // n = total number of fruits (same as baskets)
        // unplaced = count of fruits that cannot be placed in any basket
        int n = fruits.length, unplaced = 0;

        // used[j] tells whether basket j is already used or not
        boolean[] used = new boolean[n];

        // Loop through each fruit
        for (int i = 0; i < n; i++) {

            // placed flag checks whether current fruit is placed or not
            boolean placed = false;

            // Try to place fruit[i] into any available basket
            for (int j = 0; j < n; j++) {

                // Condition:
                // 1. basket j is not used
                // 2. basket capacity >= fruit size
                if (!used[j] && baskets[j] >= fruits[i]) {

                    // Mark basket as used
                    used[j] = true;

                    // Mark fruit as placed
                    placed = true;

                    // Stop searching baskets for this fruit
                    break;
                }
            }

            // If fruit could not be placed in any basket
            if (!placed) {
                unplaced++;
            }
        }

        // Return total number of unplaced fruits
        return unplaced;
    }
}

/** 
 * 
 * 
 * import java.util.*;

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {

        // Sort both arrays
        Arrays.sort(fruits);
        Arrays.sort(baskets);

        int i = 0; // pointer for fruits
        int j = 0; // pointer for baskets
        int unplaced = 0;

        // Traverse fruits
        while (i < fruits.length && j < baskets.length) {

            // If basket can hold the fruit
            if (baskets[j] >= fruits[i]) {
                // Place fruit in this basket
                i++;
                j++;
            } else {
                // Basket too small, try next basket
                j++;
            }
        }

        // Remaining fruits could not be placed
        unplaced = fruits.length - i;

        return unplaced;
    }
}

*/

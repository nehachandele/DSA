public class Solution {
    public int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // avoids overflow

            if (arr[mid] == target) {
                return mid; // element found
            } 
            else if (arr[mid] < target) {
                low = mid + 1; // search right half
            } 
            else {
                high = mid - 1; // search left half
            }
        }
        return -1; // element not found
    }
}

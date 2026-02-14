import java.util.*;

class Solution {
    public static int maxDigitSum(String[] arr) {
        int totalSum = 0;
        int length = arr[0].length();

        for (int i = 0; i < length; i++) {
            int maxDigit = 0;
            for (String s : arr) {
                maxDigit = Math.max(maxDigit, s.charAt(i) - '0');
            }
            totalSum += maxDigit;
        }

        return totalSum;
    }

    public static void main(String[] args) {
        String[] arr = {"757", "145", "986"};
        System.out.println(maxDigitSum(arr));  // 24
    }
}

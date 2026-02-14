public static long maxSubarraySumDivisibleByK(int[] arr, int k) {

    long prefixSum = 0;
    long maxSum = Long.MIN_VALUE;

    HashMap<Long, Long> map = new HashMap<>();
    map.put(0L, 0L);  // remainder 0 at prefix 0

    for (int i = 0; i < arr.length; i++) {

        prefixSum += arr[i];
        long remainder = ((prefixSum % k) + k) % k;

        if (map.containsKey(remainder)) {
            long prevPrefix = map.get(remainder);
            maxSum = Math.max(maxSum, prefixSum - prevPrefix);
        } else {
            map.put(remainder, prefixSum);
        }
    }

    return maxSum == Long.MIN_VALUE ? 0 : maxSum;
}

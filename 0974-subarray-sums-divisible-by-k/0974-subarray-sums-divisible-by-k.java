class Solution {

    public int subarraysDivByK(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {

            prefixSum += num;

            // Normalize remainder
            //int remainder = ((prefixSum % k) + k) % k;

            // Check if same remainder appeared before
            if (map.containsKey(((prefixSum % k) + k) % k)) {
                count += map.get(((prefixSum % k) + k) % k);
            }

            // Store frequency
            map.put(((prefixSum % k) + k) % k,
                    map.getOrDefault(((prefixSum % k) + k) % k, 0) + 1);
        }

        return count;
    }
}
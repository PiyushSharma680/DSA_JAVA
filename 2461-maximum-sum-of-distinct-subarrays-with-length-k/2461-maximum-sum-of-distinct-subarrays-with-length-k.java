class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int left = 0, right = 0;
        long sum = 0, maxSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (right < nums.length) {
            sum += nums[right];
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            int windowSize = right - left + 1;

            if (windowSize < k) {
                right++;
            } else if (windowSize == k) {
                if (map.size() == k) {
                    maxSum = Math.max(maxSum, sum);
                }

                // shrink window
                sum -= nums[left];
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
                right++;
            }
        }
        return maxSum;
    }
}

class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        for (int i = nums.length - 1; i > 0; i--) {
                int sub = nums[i] - nums[i - 1];
                max = Math.max(max, sub);
        }
        return max;

    }
}
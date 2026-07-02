class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int left =0;
        int right = 0;
        int mindifference  = Integer.MAX_VALUE;
        while(right<nums.length){
            int windowsize = right - left +1;
            if(windowsize<k){
                right++;
            } else if(windowsize == k){
                int difference = nums[right] - nums[left];
                mindifference= Math.min(mindifference,difference);
                left++;
                right++;
            }
        }
        return mindifference;
    }
}
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int sum =0;
        int maxsum =Integer.MIN_VALUE;
        while(right<nums.length){
            sum += nums[right];
            int windowsize = right-left+1;
            if(windowsize<k){
                right++;
            } else if (windowsize == k){
                maxsum = Math.max(maxsum,sum);
                sum -= nums[left];
                left++;
                right++;
            }
        }
        return (double)maxsum/k;
    }
}
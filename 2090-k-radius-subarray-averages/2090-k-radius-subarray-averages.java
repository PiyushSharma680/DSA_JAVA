class Solution {
    public int[] getAverages(int[] nums, int k) {
        int left = 0;
        int right = 0;
        long sum = 0;   
        int requiredwindowSize = 2 * k + 1;
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        while(right<nums.length){
            sum += nums[right];
            int currentwindow = right - left +1;
            if(currentwindow<requiredwindowSize){
                right++;
            } else if(currentwindow==requiredwindowSize){
                    ans[left + k] = (int)(sum /requiredwindowSize);
                    sum -= nums[left];
                    left++;
                    right++;
            }
        }
        return ans;
    }
}
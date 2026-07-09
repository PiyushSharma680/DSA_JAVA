class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {

        int left = 0;
        int right = 0;

        int[] freq = new int[50];
        int[] ans = new int[nums.length - k + 1];

        while (right < nums.length) {

            // Entering Element
            int num = nums[right];
            if (num < 0) {
                freq[num + 50]++;
            }

            int currentWindow = right - left + 1;

            if (currentWindow < k) {
                right++;
            } else if (currentWindow == k) {

                // Find x-th smallest negative number
                int count = 0;

                for (int i = 0; i < 50; i++) {

                    if (freq[i] > 0) {

                        count += freq[i];

                        if (count >= x) {
                            ans[left] = i - 50;
                            break;
                        }
                    }
                }

                // Leaving Element
                int leaving = nums[left];
                if (leaving < 0) {
                    freq[leaving + 50]--;
                }

                left++;
                right++;
            }
        }

        return ans;
    }
}
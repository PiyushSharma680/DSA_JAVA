class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left =0;
        int right = 0;
        int sum =0;
        int count = 0;
        while(right<arr.length){
            sum += arr[right];
            int windowsize = right - left + 1;
            if(windowsize < k){
                right++;
            } else if(windowsize ==k){
                if(sum>=threshold*k){
                    count++;
                }
                sum -= arr[left];
                left++;
                right++;
            }
        }
        return count;
    }
}
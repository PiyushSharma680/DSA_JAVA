class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int totalSum = 0;
        int n = cardPoints.length;
        int minSum = Integer.MAX_VALUE;
        for(int num:cardPoints){
            totalSum += num;
        }
        if(k == n){
            return totalSum;
            }
        while(right<n){
            sum += cardPoints[right];
            int windowsize = right-left+1;
            if(windowsize<n-k){
                right++;
            } else if(windowsize== n-k){
                    minSum = Math.min(minSum,sum);
                    sum -= cardPoints[left];
                    left++;
                    right++;
            }
        }
        return totalSum-minSum;
    }
}

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int alreadySatisfied = 0;
        for(int i=0; i<customers.length; i++){
            if(grumpy[i] == 0){
                alreadySatisfied += customers[i];
            }
        }
        int left = 0;
        int right = 0;
        int extraSatisfied = 0;
        int maxExtraSatisfied = 0;
        int k = minutes;
        while(right< customers.length){
            if(grumpy[right] == 1){
                extraSatisfied += customers[right];
            }
            int windowsize = right - left +1;
            if(windowsize<k){
                right++;
            } else if(windowsize==k){
                maxExtraSatisfied= Math.max(maxExtraSatisfied,extraSatisfied);
                if(grumpy[left] == 1){
                    extraSatisfied -= customers[left];
                }
                left++;
                right++;
            }
        }
        return (maxExtraSatisfied+alreadySatisfied);
    }
}
class Solution {
    public int minimumRecolors(String s, int k) {
        int left =0;
        int right =0;
        int wcount =0;
        int mincount = Integer.MAX_VALUE;
        while(right< s.length()){
            char ch = s.charAt(right);
            if(ch == 'W'){
                wcount++;
            }
            int windowsize = right-left+1;
            if(windowsize<k){
                right++;
            }
            else if(windowsize==k){
                mincount = Math.min(mincount,wcount);
                char sh = s.charAt(left);
                if(sh == 'W'){
                    wcount--;
                    left++;
                    right++;
                } else {
                    left++;
                    right++;
                }
            }
        }
        return mincount;
    }
}
class Solution {
    public int maxVowels(String s, int k) {
        int left = 0;
        int right =0;
        int maxcount =0;
        int vowelcount=0;
        while(right<s.length()){
            char ch = s.charAt(right);
            if(ch == 'a' || ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u'){
                vowelcount++;
            }
            int windowsize = right - left +1;
            if(windowsize<k){
                right++;
            } else if(windowsize == k){
                maxcount = Math.max(maxcount,vowelcount);
                char sh = s.charAt(left);
                if(sh == 'a' || sh == 'e' ||sh == 'i' ||sh == 'o' ||sh == 'u'){
                    vowelcount--;
                    left++;
                    right++;
                } else {
                    left++;
                    right++;
                }
            }
        }
        return maxcount;
    }
}
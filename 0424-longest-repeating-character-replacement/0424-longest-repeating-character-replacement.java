class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer>map = new HashMap<>();
        int left = 0, right = 0, maxCount = 0, result = 0;
/* entering charater*/
/* what are we maintaing inside the window -- " frequency of the character , if the currentwindow size is greater than the 'k' times then the window shrinks"*/
        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxCount = Math.max(maxCount, map.get(c));
/*shrink*/
            while ((right - left + 1) - maxCount > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            /*result*/
            result = Math.max(result,right-left+1);
            right++;
        }
        return result;
    }
}
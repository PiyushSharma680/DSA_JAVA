class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left =0;
        int right =0;
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (char ah : s1.toCharArray()) {
            map1.put(ah, map1.getOrDefault(ah, 0) + 1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        int requiredwindow = s1.length();
        while(right<s2.length()){
           char bh = s2.charAt(right);
            map2.put(bh, map2.getOrDefault(bh, 0) + 1);
            int currentwindow = right - left+1;
            if(currentwindow<requiredwindow){
                right++;
            } else if(currentwindow==requiredwindow){
                if(map1.equals(map2)){
                    return true;
                }
                char leftChar = s2.charAt(left);
                map2.put(leftChar, map2.get(leftChar) - 1);
                if (map2.get(leftChar) == 0) {
                    map2.remove(leftChar);
                    }
                left++;
                right++;
            }
        }
        return false;
    }
}
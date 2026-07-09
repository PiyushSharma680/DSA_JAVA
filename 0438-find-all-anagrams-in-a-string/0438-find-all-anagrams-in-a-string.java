class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int left =0;
        int right =0;
        int requiredwindow = p.length();
        List<Integer> answer = new ArrayList<>();
        HashMap<Character,Integer>map1= new HashMap<>();
        for(char ah:p.toCharArray()){
            map1.put(ah,map1.getOrDefault(ah,0)+1);
        }
        HashMap<Character,Integer>map2= new HashMap<>();
        while(right<s.length()){
            char ch = s.charAt(right);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
            int currentwindow = right - left +1;
            if(currentwindow < requiredwindow){
                right++;
            } else if(currentwindow == requiredwindow){
                if(map1.equals(map2)){
                    answer.add(left);
                }
                char ch2 = s.charAt(left);
                map2.put(ch2,map2.get(ch2)-1);
                if(map2.get(ch2)==0){
                    map2.remove(ch2);
                }
            left++;
            right++;
            }
        }
        return answer;
    }
}
class Solution {

    public String minWindow(String s, String t) {

        HashMap<Character, Integer> needMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            needMap.put(ch, needMap.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int formed = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

            if (needMap.containsKey(ch) &&
                windowMap.get(ch).equals(needMap.get(ch))) {
                formed++;
            }

            while (formed == needMap.size()) {

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                if (needMap.containsKey(leftChar) &&
                    windowMap.get(leftChar).equals(needMap.get(leftChar))) {
                    formed--;
                }

                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE)
            return "";

        return s.substring(start, start + minLength);
    }
}
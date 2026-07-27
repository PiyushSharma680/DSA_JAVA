import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;

        // Step 1: Build needMap
        Map<String, Integer> needMap = new HashMap<>();
        for (String word : words) {
            needMap.put(word, needMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Try each offset
        for (int offset = 0; offset < wordLength; offset++) {
            Map<String, Integer> windowMap = new HashMap<>();
            int left = offset, right = offset;
            int matched = 0;

            // Step 3: Expand window
            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                if (!needMap.containsKey(word)) {
                    // Reset window
                    windowMap.clear();
                    matched = 0;
                    left = right;
                } else {
                    // Add word to window
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);

                    if (windowMap.get(word).equals(needMap.get(word))) {
                        matched++;
                    }

                    // Shrink if frequency exceeds
                    while (windowMap.get(word) > needMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        if (windowMap.get(leftWord).equals(needMap.get(leftWord))) {
                            matched--;
                        }
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        left += wordLength;
                    }

                    // Step 4: Check valid window
                    if (matched == needMap.size() && (right - left) == totalLength) {
                        result.add(left);
                    }
                }
            }
        }

        return result;
    }
}

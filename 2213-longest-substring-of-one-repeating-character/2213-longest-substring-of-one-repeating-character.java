class Solution {

    public int[] longestRepeating(
        String s,
        String queryCharacters,
        int[] queryIndices
    ) {
        int n = s.length();

        // Convert String to char array because we need to modify characters.
        char[] arr = s.toCharArray();

        // Stores: start index -> end index of each repeating segment.
        TreeMap<Integer, Integer> segs = new TreeMap<>();

        // Stores: segment length -> number of segments having that length.
        TreeMap<Integer, Integer> lens = new TreeMap<>();

        // Build the initial repeating segments.
        for (int i = 0; i < n; ) {
            int j = i;

            while (j < n && arr[j] == arr[i]) {
                j++;
            }

            // Segment is [i, j - 1]
            segs.put(i, j - 1);

            // Store its length.
            int len = j - i;
            lens.put(len, lens.getOrDefault(len, 0) + 1);

            i = j;
        }

        int k = queryIndices.length;
        int[] ans = new int[k];

        // Process every query.
        for (int q = 0; q < k; q++) {

            int pos = queryIndices[q];
            char ch = queryCharacters.charAt(q);

            // If the character is already the same,
            // nothing changes.
            if (arr[pos] != ch) {

                // Find the segment containing pos.
                int L = segs.floorKey(pos);
                int R = segs.get(L);

                // Remove the old segment.
                segs.remove(L);

                int oldLen = R - L + 1;

                lens.put(oldLen, lens.get(oldLen) - 1);

                if (lens.get(oldLen) == 0) {
                    lens.remove(oldLen);
                }

                // Create the left remaining segment, if any.
                if (L <= pos - 1) {

                    segs.put(L, pos - 1);

                    int leftLen = pos - L;

                    lens.put(
                        leftLen,
                        lens.getOrDefault(leftLen, 0) + 1
                    );
                }

                // Create the right remaining segment, if any.
                if (pos + 1 <= R) {

                    segs.put(pos + 1, R);

                    int rightLen = R - pos;

                    lens.put(
                        rightLen,
                        lens.getOrDefault(rightLen, 0) + 1
                    );
                }

                // Initially, the new character forms [pos, pos].
                int newL = pos;
                int newR = pos;

                // --------------------------------
                // Try to merge with the RIGHT side
                // --------------------------------

                Integer rightKey = segs.ceilingKey(pos + 1);

                if (
                    rightKey != null &&
                    rightKey == pos + 1 &&
                    arr[pos + 1] == ch
                ) {

                    int rightR = segs.get(rightKey);

                    int rightLen = rightR - rightKey + 1;

                    // Remove old right segment length.
                    lens.put(
                        rightLen,
                        lens.get(rightLen) - 1
                    );

                    if (lens.get(rightLen) == 0) {
                        lens.remove(rightLen);
                    }

                    // Merge with right segment.
                    newR = rightR;

                    segs.remove(rightKey);
                }

                // --------------------------------
                // Try to merge with the LEFT side
                // --------------------------------

                Integer leftKey = segs.floorKey(pos - 1);

                if (leftKey != null) {

                    int leftR = segs.get(leftKey);

                    if (
                        leftR == pos - 1 &&
                        arr[pos - 1] == ch
                    ) {

                        int leftLen = leftR - leftKey + 1;

                        // Remove old left segment length.
                        lens.put(
                            leftLen,
                            lens.get(leftLen) - 1
                        );

                        if (lens.get(leftLen) == 0) {
                            lens.remove(leftLen);
                        }

                        // Merge with left segment.
                        newL = leftKey;

                        segs.remove(leftKey);
                    }
                }

                // Add the final merged segment.
                segs.put(newL, newR);

                int newLen = newR - newL + 1;

                lens.put(
                    newLen,
                    lens.getOrDefault(newLen, 0) + 1
                );

                // Finally update the actual character.
                arr[pos] = ch;
            }

            // Largest key = longest repeating segment.
            ans[q] = lens.lastKey();
        }

        return ans;
    }
}
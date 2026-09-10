import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {

                if (start == i - 1) {
                    ans.add(String.valueOf(nums[start]));
                } else {
                    ans.add(nums[start] + "->" + nums[i - 1]);
                }

                start = i;
            }
        }
        if (start == nums.length - 1) {
            ans.add(String.valueOf(nums[start]));
        } else {
            ans.add(nums[start] + "->" + nums[nums.length - 1]);
        }

        return ans;
    }
}
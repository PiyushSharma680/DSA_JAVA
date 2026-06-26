class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        long ans = 0;
        long bulbsOn = (brightness + 2) / 3;
        int curr = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (curr >= intervals[i][1])
                continue;
            if (curr >= intervals[i][0])
                intervals[i][0] = curr + 1;
            curr = intervals[i][1];
            long time = intervals[i][1] - intervals[i][0] + 1;
            ans += time * bulbsOn;
        }
        return ans;
    }
}
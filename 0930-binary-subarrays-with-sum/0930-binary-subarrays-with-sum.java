class Solution{
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,1);
        int prefixsum = 0;
        int count = 0;
        for(int num:nums){
            prefixsum += num;
            int previousPrefix = prefixsum - goal;
            if(map.containsKey(previousPrefix)){
                count += map.get(previousPrefix);
            }
            map.put(prefixsum,map.getOrDefault(prefixsum,0)+1);
        }
        return count;
    }
}
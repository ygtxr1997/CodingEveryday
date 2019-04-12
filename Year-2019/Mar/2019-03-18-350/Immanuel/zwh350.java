class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for(int tmp: nums1){
            map1.put(tmp, map1.getOrDefault(tmp, 0) + 1);
        }
        
        List<Integer> outPut = new ArrayList<>();
        for(int tmp: nums2){
            if(map1.getOrDefault(tmp, 0) > 0){
                outPut.add(tmp);
                map1.put(tmp, map1.get(tmp) - 1);
            }
        }

        int[] outPutInt = new int[outPut.size()];
        for (int i = 0; i < outPut.size(); i++){
            outPutInt[i] = outPut.get(i);
        }

        return outPutInt;
    }
}
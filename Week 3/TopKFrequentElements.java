class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res=new int[k];
        if(nums.length==0 || k==0)
            return res;
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();                                          
        for(int i:nums)
            map.put(i, map.getOrDefault(i,0) + 1); //frequency of the elements(keys) are stored as values.
        
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet()); //conerting map entries into a list to sort them.
        
        //sorting the entry sets based on values in descending order
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int i=0;
        //adding elements into the result array
        for(Map.Entry<Integer, Integer> entry:entryList){
            if(k==0)    break;
            res[i++]=(int)(entry.getKey());
            --k;
        }
        return res;
    }
}

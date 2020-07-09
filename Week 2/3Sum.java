class Solution {
    //METHOD 1: TLE
    
    /*
    public List<List<Integer>> threeSum(int[] a) {
        Set<List<Integer>> list=new TreeSet<>();
        Arrays.sort(a);
        TreeSet<String> set=new TreeSet<>();
        int val;
        for(int i=0 ; i<a.length-2 ; ++i){
            val=0-a[i];
            for(int j=i+1 ; j<a.length-1 ; ++j){
                val=val-a[j];
                if(map.containsKey(val) && map.get(val)!=0){
                    List<Integer> triplet=new ArrayList<>(); 
                    triplet.add(a[i]);
                    triplet.add(a[j]);
                    triplet.add(val);
                    Collections.sort(triplet);
                    list.add(triplet);
                    map.replace(val, map.get(val), map.get(val)-1);
                }
            }
        }
        return list.stream().collect(Collectors.toList());
    }
    */
    
    //METHOD 2: Using Two pointers
    
    public List<List<Integer>> threeSum(int[] a) {
        Arrays.sort(a);
        
        List<List<Integer>> res=new ArrayList<>();
        TreeSet<String> set=new TreeSet<>();
        
        for(int i=0 ; i<a.length-2 ; ++i){
            int j=i+1;
            int k=a.length-1;
            while(j < k){
                if(a[i]+a[j]+a[k]==0){
                    String s=a[i] + "," + a[j] + "," + a[k];
                    if(!set.contains(s)){
                        List<Integer> triplet=new ArrayList<>();
                        triplet.add(a[i]);
                        triplet.add(a[j]);
                        triplet.add(a[k]);
                        res.add(triplet);
                        set.add(s);
                    }
                    ++j;
                    --k;
                }
                else if(a[i]+a[j]+a[k] < 0)
                    ++j;
                else
                    --k;
            }
        }
        return res;
    }
}

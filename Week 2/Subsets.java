class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0 ; i < (1<<n) ; ++i){      //iterating through the power set(comprsising of all subsets) = 2^n elements = (1<<n)
            List<Integer> subset=new ArrayList<>();   //subset digits stored in here
            for(int j=0 ; j<n ; ++j){        //printing the currrent subset; is of n digits
                if((i & (1<<j)) > 0)         //finding which bits in i are 1 by ANDing 1 in every jth position
                    subset.add(nums[j]);
            }
            res.add(subset);
        }
        return res;
    }
}

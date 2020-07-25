class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res=new int[2];
        if(nums.length==0)
            return res;
        int xor=0;
        for(int i:nums)
            xor ^= i;
        //getting the rightmost set bit
        int rightmostSetBit = xor & (-xor);  
        
        //(-xor) is two's complement. can also write as ~(xor-1)
        
        //dividing into two sets basedon rightmostbit: one - same bit set 
        //two - same bit not set
        
        for(int i:nums){
            if((i & rightmostSetBit) == rightmostSetBit)
                res[0] ^= i;
            else
                res[1] ^= i;
        }
        return res;
    }
}

class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        
        for (int i = digits.length-1; i>= 0; i--) {     //starting from one's place
            digits[i] += carry;
            if (digits[i] <= 9)     // early return; all other digits are same
                return digits;
            //else it means that the ith is now 0 and 1 is carried to (i-1)th digit in the next iterarion
            digits[i] = 0;      
        }
        
        //if the compiler reaches here it means that all the digits are now 0 and 1 needs to be added at its MSB.
        //hence array length increases by 1.
        
        int[] res = new int[digits.length+1];
        res[0] = 1;     //1 added at the MSB.
        return res;     //all other elements are 0.
    }
}

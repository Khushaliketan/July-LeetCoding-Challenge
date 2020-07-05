class HammingDistance {
    
    public int hammingDistance(int x, int y) {
        int xor=x^y;    //sets the different bits to 1;
        //calculating the set bits in the xor
        int count=0;
        while(xor>0){
            count += xor & 1;   //gives result 1 only when the bit is 1(set)
            xor>>=1;    //right shift by 1
        }
        return count;
    }
}

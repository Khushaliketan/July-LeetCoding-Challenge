class ArrangingCoins {
    public int arrangeCoins(int n) {
        //METHOD 1: Iterative
        /*
        int k=0;
        while(n>0){
            ++k;
            n-=k;
        }
        return n==0 ? k : k-1;
        */
        
        //[0,1,3,6,10,15,21,28,...]: series of the last elements in the coins placed (cumulative sum)   
        
        //METHOD 2: Math
        //1,2,3,4,.....k terms, sum is = k(k-1)/2 <=n. so finding k from this equation
       
        return (int)(Math.sqrt((8L * n + 1)) - 1)/2;    //8*n might have int overflow hence the conversion.
    }
}

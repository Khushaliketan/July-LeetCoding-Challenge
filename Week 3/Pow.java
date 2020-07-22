class Solution {
    public double myPow(double x, int n) {
        if(n==0)
            return (double) 1;
        if(x==0)
            return (double) 0;
        double half=myPow(x, n/2);
        if(n%2==0)      //even power
            return half*half;
        else{
            if(n>0)   //odd positive power
                return x*half*half;
            else
                return (half*half)/x;
        }
    }
}

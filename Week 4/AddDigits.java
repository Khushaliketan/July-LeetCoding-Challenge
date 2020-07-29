class Solution {
    public int findSum(int n){
        int s=0;
        while(n>0){
            s += (n%10);
            n/=10;
        }
        return s;
    }
    public int addDigits(int num) {
        if(num<9)
            return num;
        while(num>9){
            num = findSum(num);
        }
        return num;
    }
}

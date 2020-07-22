class Solution {
    /* METHOD 1:
    
    public String addBinary(String a, String b) {
        int aLen=a.length();
        int bLen=b.length();
        if(aLen==0 && bLen==0)
            return "";
        if(aLen==0 && bLen!=0)
            return b;
        if(aLen==0 && bLen==0)
            return a;
        int carry=0, i=0, j=0;
        StringBuilder sb=new StringBuilder();
        for(i=aLen-1, j=bLen-1; i>=0 && j>=0 ;--i, --j){
            int sum=carry + Integer.parseInt(a.substring(i, i+1)) + Integer.parseInt(b.substring(j, j+1));
            if(sum==0 || sum==1)
                carry=0;
            else if(sum==2){
                carry=1;
                sum=0;
            }
            else if(sum==3){
                carry=1;
                sum=1;
            }
            sb.append(sum);
        }
    
        //remaining elements
        while(i>=0){
            int sum=carry+Integer.parseInt(a.substring(i, i+1));
            if(sum==0 || sum==1)
                carry=0;
            if(sum==2){
                carry=1;
                sum=0;
            }
            sb.append(sum);
            --i;
        }
        while(j>=0){
            int sum=carry+Integer.parseInt(b.substring(j, j+1));
            if(sum==0 || sum==1)
                carry=0;
            if(sum==2){
                carry=1;
                sum=0;
            }
            sb.append(sum);
            --j;
        }
        if(carry==1) 
            sb.append(carry);
        return sb.reverse().toString();
    } */
    
    
    //METHOD 2:
    //To improve Space Complexity : Optimised method
    
    public String addBinary(String a, String b) {
        int aLen=a.length();
        int bLen=b.length();
        if(aLen==0 && bLen==0)
            return "";
        if(aLen==0 && bLen!=0)
            return b;
        if(aLen==0 && bLen==0)
            return a;
        int carry=0, i=aLen-1, j=bLen-1;
        StringBuilder sb=new StringBuilder();
        while(i>=0 || j>=0){
            int ai = i>=0 ? a.charAt(i) - '0' : 0;
            int bi = j>=0 ? b.charAt(j) - '0' : 0;
            int sum=carry + ai + bi;
            sb.append(sum % 2); //does the job if sum is odd: 1 and even: 0
            carry = sum/2; //carry computation
            --i;
            --j;
        }
        if(carry==1) 
            sb.append(carry);
        return sb.reverse().toString();
    }
    
    
}

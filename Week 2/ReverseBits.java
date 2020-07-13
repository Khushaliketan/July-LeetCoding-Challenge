public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        //METHOD 1: Bit Manipulation - ACCEPTED
        
        int rev=0;
        for(int i=0; i<32 ; ++i){
            rev += n & 1; //getting the last bit; AND with 1 gives 1 if bit is 1 else 0;
            n>>>=1;       //logical right shift: treat as unsigned int and add 0 in vacant bits
            if(i<31)
                rev <<= 1;      //reverse by doing arithmetic left shift
        }
        return rev;
        
        //METHOD 2: Conerting to binary string: Fails to consider unsigned int
        /*
        Queue<Integer> binary=new LinkedList<Integer>();
        while(n>=1){
            binary.add(n%2);
            n=n/2;
        }
        while(binary.size()!=32)
            binary.add(0);
        String s=new String();
        while(!binary.isEmpty())
            s+=Integer.toString(binary.poll());
        System.out.println(s);
        int rev=(int) Integer.valueOf(s, 2); //binary
        return (rev);
        */
    }
}

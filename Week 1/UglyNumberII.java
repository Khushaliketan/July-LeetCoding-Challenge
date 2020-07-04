class UglyNumberII {
    public int nthUglyNumber(int n) {
        ArrayList<Integer> list=new ArrayList<>();  //creating a list of ugly numbers

        list.add(1);    //typical ugly number
        
        int i1=0, i2=0, i3=0;       //indexes for producing minimum next multiple starting with 0th index
        
        //generating more ugly numbers by multiplying with 2, 3 and 5
        
        while(list.size()!=n){      //run until the nth Ugly number is obtained
            int next_2=list.get(i1)*2;
            int next_3=list.get(i2)*3;
            int next_5=list.get(i3)*5;
            
            //minimum of all three multiples
            int nextUgly=Math.min(next_2, Math.min(next_3, next_5));
            
            //checking if the multiple already exists
            if(!list.contains(nextUgly)){
                list.add(nextUgly);
            }
            
            //following conditions increment the index of whichever multiple was min.
            if(nextUgly==next_2){
                ++i1;
            }
            else if(nextUgly==next_3){
                ++i2;
            }
            else
                ++i3;
            //System.out.println(list.toString());
        }
        return list.get(n-1);   //last element will be the nth ugly number
    }
}

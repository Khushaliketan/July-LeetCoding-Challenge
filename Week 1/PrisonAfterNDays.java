class Solution {
    
    //METHOD 1: BRUTE FORCE (RECURSION) - TLE
    /*
    public int[] prisonAfterNDays(int[] cells, int N) {
        for(int i=0 ; i<N ; ++i){
            cells=nextDay(cells);
        }
        return cells;
    }
    public int[] nextDay(int[] cells){   //i=0 and i=7 are always 0 after Day0
        int[] next=new int[cells.length];
        for(int i=1 ; i<7 ; ++i){
            next[i]=(cells[i-1]==cells[i+1] ? 1 : 0);
        }
        return next;
    }
    */
    
    //METHOD 2: FINDING REPETITIVE PATTERNS
    //First and last elements are 0 always. Remaining 6 places with either 0 or 1;
    //so total number of combinations is 2^6=64 out of which some will repeat. Check this using boolean varaible repeat
    
    public int[] prisonAfterNDays(int[] cells, int N) {
        HashSet<String> set=new HashSet<>();    //store the unique combinations here
        int len=0;    //to keep track of len of set
        
        boolean repeat=false;  //checks when cycle exists
        
        for(int i=0 ; i<N ; ++i){
            int[] next=nextDay(cells);
            String state=Arrays.toString(next);
            if(set.contains(state)){
                repeat=true;
                break;
            }
            set.add(state);
            ++len;
            cells=next;
        }
        if(repeat==true){
            return prisonAfterNDays(cells, N%len);  //returning N%len day state
        }
        return cells;
    }
    public int[] nextDay(int[] cells){   //i=0 and i=7 are always 0 after Day0
        int[] next=new int[cells.length];
        for(int i=1 ; i<7 ; ++i){
            next[i]=(cells[i-1]==cells[i+1] ? 1 : 0);
        }
        return next;
    }
}

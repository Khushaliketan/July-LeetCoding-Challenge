class Solution {
    public boolean existWord(char[][] board, String word, int i, int j, int index){
        //base cases
        if(index==word.length())
            return true;
        if(i<0 || j<0 || i>=board.length || j>=board[i].length || word.charAt(index)!=board[i][j])
           return false;
        char temp=board[i][j];
        board[i][j]=' ';
        boolean res = existWord(board, word, i+1, j, index+1) ||
                      existWord(board, word, i-1, j, index+1) ||
                      existWord(board, word, i, j+1, index+1) ||
                      existWord(board, word, i, j-1, index+1);
        board[i][j]=temp;
        return res;
    }
    public boolean exist(char[][] board, String word) {
        if(board.length==0)
            return false;
        if(word.length()==0)
            return true;
        for(int i=0 ; i<board.length ; ++i){
            for(int j=0; j<board[i].length ; ++j){
                if(board[i][j]==word.charAt(0) && existWord(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
}

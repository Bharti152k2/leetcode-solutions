class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board);
    }
    public boolean isValid(char[][] board,int num,int row,int col){
        for(int i=0;i<board.length;i++){
            if(board[i][col]==num){
                return false;
            }
            if(board[row][i]==num){
                return false;
            }
        }
        // for(int i=0;i<board.length;i++){

        // }
        int x=(row/3)*3;
        int y=(col/3)*3;
        // int x=row;
        // int y=col;
        for(int i=x;i<x+3;i++){
            for(int j=y;j<y+3;j++){
                if(board[i][j]==num){
                    return false;
                }
            }
        }
        return true;

    }
    public boolean dfs(char[][] board){
        boolean foundEmpty = false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='.'){
                    foundEmpty = true;
                    for(char num = '1'; num <= '9'; num++){
                        if(isValid(board,num,i,j)){
                            board[i][j]=num;
                            if (dfs(board)) {
                                return true;
                            }
                        }
                        board[i][j]='.';
                        
                    }
                    return false;
                }
                
            }
        }
        return true;
    }
}
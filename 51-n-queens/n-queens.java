class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        dfs(board,0,res);
        return res;
    }
    public boolean isvalidPosition(char[][] board, int x, int y) {
        int size=board.length;
        for(int i=0; i<size;i++){
            if(board[x][i]=='Q'){
                return false;
            }
        }
        for(int i=0; i<size;i++){
            if(board[i][y]=='Q'){
                return false;
            }
        }
        int a=x;
        int b=y;
        while(a-1>=0 && b-1>=0){
            a--;
            b--;
            if(board[a][b]=='Q'){
                return false;
            }
        }
        a=x;
        b=y;
        while(a+1<size && b-1>=0){
            a++;
            b--;
            if(board[a][b]=='Q'){
                return false;
            }
        }
        // a=x;
        // b=y;
        // while(a-1>=0 && b-1<size){
        //     a--;
        //     b--;
        //     if(board[a][b]=='Q'){
        //         return false;
        //     }
        // }
        // a=x;
        // b=y;
        // while(a+1<size && b+1<size){
        //     a++;
        //     b++;
        //     if(board[a][b]=='Q'){
        //         return false;
        //     }
        // }
        return true;
    }

    public boolean dfs(char[][] board, int col,List<List<String>> res) {
        if(col==board.length){
            List<String> current = new ArrayList<>();

            for (int i = 0; i < board.length; i++) {
                current.add(new String(board[i]));
            }

            res.add(current);
            return true;
        }
        for(int i=0; i<board.length; i++){
            if(isvalidPosition(board,i,col)){
                board[i][col]='Q';
                // boolean cur=
                dfs(board,col+1,res);
                // if(cur){
                //     return true;
                // }
                board[i][col]='.';

            }
        }
        return false;
    }
}
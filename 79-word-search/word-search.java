class Solution {
    public boolean exist(char[][] board, String word) {
        for(int r=0 ; r<board.length;r++){
            for(int c=0 ; c<board[0].length;c++){
                if(dfs(board,word,r,c,0)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int r,int c, int idx){
        
        if(idx==word.length()){
            return true;
        }
        if(r<0 || c<0 || r>=board.length || c>=board[0].length ||  board[r][c]!=word.charAt(idx)){
            return false;
        }
        char temp=board[r][c];
        board[r][c]='#';
        boolean found =dfs(board,word,r+1,c,idx+1) || dfs(board,word,r,c+1,idx+1) || dfs(board,word,r-1,c,idx+1) || dfs(board,word,r,c-1,idx+1);
        board[r][c]=temp;
        return found;
    }
}
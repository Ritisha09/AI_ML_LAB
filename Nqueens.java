import java.util.*;
public class Nqueens{
    
    
    public static boolean helper(char[][] board, int row){
        if(row == board.length){
            for(int k = 0; k<board.length; k++){
                for(int m = 0; m<board.length; m++){
                    if(board[k][m] == 'Q'){
                        System.out.print(board[k][m] + " ");
                    }else{
                        System.out.print(". ");
                    }
                }
                System.out.println();
            }

            System.out.println("FFFF");
            return true;
        }
                             
        for(int i = 0; i< board.length; i++){
            if(isSafe(row, i, board)){
                System.out.println(0);
                board[row][i] = 'Q';  
                helper(board, row+1); 
                System.out.println(2);
                board[row][i] = '.';  
            }else{
                System.out.println(1);
            }
        }
        return false;
    }

    public static  boolean isSafe(int row, int col, char[][] board){
        // for horizontal
        for(int i = 0; i<board.length; i++){
            if(board[row][i] == 'Q'){
                return false;
            }
        }

        // for vertical
        for (int i = 0; i<board.length;i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // for upper left
        int r = row;
        int c = col;

        while(r >=0 && c >= 0){
            if(board[r][c] == 'Q'){
                return false;
            }
            r--;
            c--;
        }

        // for upper right
        r =row;
        c= col;
        while(r>=0 && c< board.length){
            if(board[r][c] == 'Q'){
                return false;
            }
            r--;
            c++;
        }

        // for lower left
        r = row;
        c = col;
        while(r < board.length && c>=0){
            if(board[r][c] == 'Q'){
                return false;
            }
            r++;
            c--;
        }

        // for lower right
        r = row;
        c = col;
        while(r < board.length && c< board.length){
            if(board[r][c] == 'Q'){
                return false;
            }
            r++;
            c++;
        }
        return true;

    }
    
    public static void main(String[] args){
        char[][] board = new char[4][4];
        helper(board, 0);

    }
}
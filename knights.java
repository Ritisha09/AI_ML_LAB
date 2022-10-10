import java.util.*;
public class knights {

    public static void tour(int[][] chess, int row, int col, int move ){
        if(row<0 || col<0 || row >= chess.length || col >= chess.length ||chess[row][col] >0){
            return;
        }else if(move == chess.length * chess.length){
            chess[row][col] = move;
            for(int i=0; i<chess.length; i++){
                for(int j =0; j<chess.length; j++){
                    System.out.print(chess[i][j] +" ");
                }
                System.out.println();
            }
            System.out.println("ffff");
            chess[row][col] =0;
            return;
        }
        
        chess[row][col] = move;
        tour(chess,row-2,col+1, move+1);
        // chess[row][col] = 0;
        tour(chess,row-1,col+2, move+1);
        // chess[row][col] = 0;
        tour(chess,row+1,col+2, move+1);
        // chess[row][col] = 0;
        tour(chess,row+2,col+1, move+1);
        // chess[row][col] = 0;
        tour(chess,row+2,col-1, move+1);
        // chess[row][col] = 0;
        tour(chess,row+1,col-2, move+1);
        // chess[row][col] = 0;
        tour(chess,row-1,col-2, move+1);
        // chess[row][col] = 0;
        tour(chess,row-2,col-1, move+1);
        chess[row][col] = 0;

               
    }
    public static void main(String[] args){
        int[][] chess = new int[5][5];
        tour(chess, 0,0,1);


    }
    
}

import java.util.*;
public class Ttt {
    public static void printBoard(char[][] board){
        for(char[] row: board){
            for(char c: row){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] board, int pos, String user){
        char symbol = ' ';

        if(user.equals("me")){
            symbol = 'X';
        }else if(user.equals("cpu")){
            symbol = '0';
        }

        switch(pos){
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][1] = symbol;
                break;
            case 3:
                board[0][2] = symbol;
                break;
            case 4:
                board[1][0] = symbol;
                break;
            case 5:
                board[1][1] = symbol;
                break;
            case 6:
                board[1][2] = symbol;
                break;
            case 7:
                board[2][0] = symbol;
                break;
            case 8:
                board[2][1] = symbol;
                break;
            case 9:
                board[2][2] = symbol;
                break;
                
        }
    }

    public static String checkWinner(char[][] board){
        String winner = "null";
        for (int row = 0; row < 3; row++)
        {
            if (board[row][0] == board[row][1] &&
                board[row][1] == board[row][2] && board[row][0] != '.')
            {
                if (board[row][0] == 'X')
                    winner =  "me";
                else if (board[row][0] == '0')
                    winner = "cpu";
            }
        }
        
        // Checking for Columns 
        for (int col = 0; col < 3; col++)
        {
            if (board[0][col] == board[1][col] &&
                board[1][col] == board[2][col] && board[0][col] != '.')
            {
                if (board[0][col] == 'X')
                    winner = "me";
    
                else if (board[0][col] == '0')
                    winner = "cpu";
            }
        }
        // Checking for Diagonals 
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '.')
        {
            if (board[0][0] == 'X')
                winner = "me";
            else if (board[0][0] == '0')
                winner = "cpu";
        }
    
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '.')
        {
            if (board[0][2] == 'X')
                winner = "me";
            else if (board[0][2] == '0')
                winner = "cpu";
        }

        int emptySpace =0;
        for(int i =0; i<3; i++){
            for(int j=0; j<3;j++){
                if(board[i][j] == '.'){
                    emptySpace++;
                }
            }
        }
        
        if(winner == "null" && emptySpace == 0){
            winner =  "tie";
        }

        return winner;
    }

    public static char bestMove(char[][] board){
        int bestScore = Integer.MIN_VALUE;
        for(int i=0; i<3; i++){
            for(int j =0; j<3; j++){
                if(board[i][j] == '.'){
                    board[i][j] = '0';
                    int move = minimax(board,0,false);
                    board[i][j] = '.';
                    if(move>bestScore){
                        bestScore = move;
                        return board[i][j] = '0'; 
                    }
                }
            }
        }
        return board[i][j];
    }

    public static int minimax(char[][] board, int depth, boolean isMax){
        
        String result = checkWinner(board);
        int score = 0;  

        // if terminal state
        if(result != "null"){
            if(result == "me"){
                score = 1;
            }else if(result == "cpu"){
                score = -1;
            }
            return score;
        }

        if(isMax){
            int bestScore = Integer.MIN_VALUE;
            for(int i=0; i<3; i++){
                for(int j =0; j<3; j++){
                    if(board[i][j] == '.'){
                        board[i][j] = '0';
                        bestScore = Math.min(bestScore, minimax(board,depth+1,false));
                        board[i][j] = '.';
                    }
                }
            }
            return bestScore;
        }else{
            int bestScore = Integer.MAX_VALUE;
            for(int i=0; i<3; i++){
                for(int j =0; j<3; j++){
                    if(board[i][j] == '.'){
                        board[i][j] = 'X';
                        bestScore = Math.max(bestScore, minimax(board,depth+1,true));
                        board[i][j] = '.';
                    }
                }
            }
            return bestScore;
        }
    }

    public static void main(String[] args){
        char[][] board = {{'.','.','.'},
                          {'.','.','.'},
                          {'.','.','.'}};
        
        try (Scanner sc = new Scanner(System.in)) {
            while(true){
                System.out.println("Enter postions(1-9): ");
                int mePos = sc.nextInt();
                placePiece(board,mePos,"me");

                //Random rand = new Random();
                //int cpuPos = rand.nextInt(9)+1;
                //placePiece(board,cpuPos, "cpu");
                printBoard(board);
                bestMove(board);
                printBoard(board);
                System.out.println(checkWinner(board));
            }
            

        }

        
    }

}

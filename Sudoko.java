public class Sudoko{
    
    public static boolean helper(char[][]matrix, int row, int col){
        //row
        if(row == matrix.length){
            return true;
        }

        int nrow =0;
        int ncol =0;

        if(col != 8){
            nrow =row;
            ncol = col+1;
        }else{
            nrow = row +1;
            ncol = 0;
        }

        if(matrix[row][col] != '.'){
            if(helper(matrix,nrow, ncol)){
                return true;
            }
        }else{
                for(int i =1; i<=9; i++){
                    if(isValid(matrix, row, col, i)){
                        matrix[row][col] = (char)(i+'0');
                        if(helper(matrix,nrow,ncol)){
                            return true;
                        }else{
                            matrix[row][col] = '.';
                        }
                    }
                }
        }
        

        return false;
        
    }

    public static boolean isValid(char[][] matrix, int row, int col, int val){
        //row & col
        for(int i=0; i<9; i++){
            if(matrix[i][col] ==(char)(val + '0')){
                return false;
            }

            if(matrix[row][i] == (char)(val +'0')){
                return false;
            }
        }

        //grid
        int start_row = row/3 *3;
        int start_col = col/3 *3;

        for(int i = start_row; i<start_row + 3; i++ ){
            for(int j = start_col; j<start_col +3; j++){
                if(matrix[i][j] == (char)(val+ '0')){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args){
        //Scanner sc = new Scanner(System.in);
        char matrix[][] = {{'5','3','.','.','7','.','.','.','.'},
                           {'6','.','.','1','9','5','.','.','.'},
                           {'.','9','8','.','.','.','.','6','.'},
                           {'8','.','.','.','6','.','.','.','3'},
                           {'4','.','.','8','.','3','.','.','1'},
                           {'7','.','.','.','2','.','.','.','6'},
                           {'.','6','.','.','.','.','2','8','.'},
                           {'.','.','.','4','1','9','.','.','5'},
                           {'.','.','.','.','8','.','.','7','9'}};

        if(helper(matrix,0,0)){
            for(int i =0; i<matrix.length; i++){
                for (int j=0; j<matrix.length; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }else{
            System.out.println("Invalid Sudoko");
        }
    }
}
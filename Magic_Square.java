public class Magic_Square {
    
    public static void magicSquare(int n){
        int[][] magic = new int[n][n];

        int i = n / 2;
        int j = n - 1;
 
        // One by one put all values in magic square
        for (int num = 1; num <= n * n;) {
            if (i == -1 && j == n) // 1st con
            {
                j = n - 2;
                i = 0;
            }
            else {
             
                if (j == n)
                    j = 0;
                if (i < 0)
                    i = n - 1;
            }
            // 2nd con
            if (magic[i][j] != 0) {
                j -= 2;
                i++;
                continue;
            }
            else
                magic[i][j] = num++;
            j++;
            i--;
        }

        for (int k= 0; k< n; k++){
            for(int l=0; l<n;l++){
                System.out.print(magic[k][l]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int n =3;
        magicSquare(n);
        
    }

}

package RecursionAndBacktrackingL2;

public class NqueensCombinations2dAs1dQueenChooses {
    public static boolean IsQueenSafe(boolean[][] chess, int row, int col) {
        // write your code here
        for(int i=row,j=col;i>=0;i--){
            if(chess[i][j]==true){
                return false;
            }
        }

        for(int i=row,j=col;j>=0;j--){
            if(chess[i][j]==true){
                return false;
            }
        }

        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(chess[i][j]==true){
                return false;
            }
        }

        for(int i=row,j=col;i>=0 && j<chess.length;i--,j++){
            if(chess[i][j]==true){
                return false;
            }
        }

        return true;
    }

    public static void nqueens(int qpsf, int tq, boolean[][] chess, int lcno) {
        if (qpsf == tq) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] ? "q\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == false && IsQueenSafe(chess, row, col)) {
                chess[row][col] = true;
                nqueens(qpsf + 1, tq, chess, row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int n = 4;
        boolean[][] chess = new boolean[n][n];

        nqueens(0, n, chess, -1);
    }
}

/*
4
 */

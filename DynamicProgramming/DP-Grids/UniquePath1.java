public class UniqueGridPath1{

    public int recPath(int row, int col){
        if (row == 0 && col == 0) {
            return 1;
        }
        if (row <0 || col <0) {
            return 0;
        }
        int up = recPath(row-1, col);
        int left = recPath(row, col-1);
        return up+left;
    }

    public int memoPath(int row, int col, int dp[][]){
        if (row == 0 && col == 0) {
            return 1;
        }
        if (row <0 || col <0) {
            return 0;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int up = recPath(row-1, col);
        int left = recPath(row, col-1);
        return dp[row][col] = up+left;
    }

    public int tabuPath(int m , int n){
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }
                else{
                    int up =0;
                    int left = 0;
                    if(i>0) up = dp[i-1][j];
                    if(j>0) left= dp[i][j-1];
                    dp[i][j] = up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }
    

    public int uniquePaths(int m, int n) {
        return recPath(m-1, n-1);
    }

    public static void main(String[] args) {
        
    }
}

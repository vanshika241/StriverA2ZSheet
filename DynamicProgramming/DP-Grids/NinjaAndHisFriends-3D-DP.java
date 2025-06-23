public class CherryPickup {
    public int memoSum(int i, int j1, int j2,int dp[][][],int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        if (j1<0 || j1>=n || j2<0 || j2>=n) {
            return Integer.MIN_VALUE;
        }
        if (i == m-1) {
            if (j1 == j2) {
                return grid[i][j1];
            }
            else{
                return grid[i][j1] + grid[i][j2];
            }
        }

        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }
        int maxi = Integer.MIN_VALUE;
        for(int dj1 =-1;dj1<=1;dj1++ ){
            for(int dj2 =-1;dj2<=1;dj2++){
                int value = 0;
               if (j1 == j2) {
                 value += grid[i][j1];
               }
               else{
                value += grid[i][j1] + grid[i][j2];
                
               }
               value +=  memoSum(i+1, j1+dj1, j2+dj2, dp, grid);
               maxi = Math.max(maxi, value);
            }
        }
        return dp[i][j1][j2] = maxi;
    }
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][][] = new int[m][n][n];
        for(int i=0;i<m;i++){
            for(int j1=0;j1<n;j1++){
                for(int j2 = 0;j2<n;j2++){
                    dp[i][j1][j2] = -1;
                }
            }
        }

        return memoSum(0, 0, n-1, dp, grid);
    }
    public static void main(String[] args) {
        
    }
}

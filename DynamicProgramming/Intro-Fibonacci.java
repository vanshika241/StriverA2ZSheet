
public class Fibonacci{
    //Recursion
    public static int fibRec(int idx){
        if(idx == 0)return 0;
        if(idx == 1)return 1;
        return fibRec(idx-1)+fibRec(idx-2);
    }

    //Memoization
    public static int fibMemo(int idx, int dp[]){
        if (idx <=1) {
            return idx;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        return dp[idx] = fibMemo(idx-1, dp)+fibMemo(idx-2, dp);
    }

    //Tabulation
    public static int fiboTabu(int n){
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static int fiboSpace(int n){
        int sprev = 0;
        int prev = 1;
        for(int i=2;i<=n;i++){
            int curri = prev+sprev;
            sprev = prev;
            prev = curri;
        }
        return prev;
    }
    public static void main(String[] args) {
        System.out.println("Recursion "+fibRec(5));
        int n = 5;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println("Memoization "+fibMemo(5,dp));
        System.out.println("Tabulation "+fiboTabu(n));
        System.out.println("Space Optimization "+fiboSpace(n));
    }
}

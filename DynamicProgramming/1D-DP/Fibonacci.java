public class Fibonacci{

    public int fiboRecursive(int n){
        if (n<=1) {
            return n;
        }
        return fiboRecursive(n-1)+fiboRecursive(n-2);
    }

    public int fiboMemo(int n , int dp[]){
        if (n<=1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n]; // constant call
        }
        return  dp[n] = fiboMemo(n-1,dp)+fiboMemo(n-2,dp);
    }

    public int fiboTabulation(int n){
        if (n<=1) {
            return n;
        }
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public int nthFibonacci(int n) {
       return fiboTabulation(n);
    }

    public static void main(String[] args) {
        
    }
 }

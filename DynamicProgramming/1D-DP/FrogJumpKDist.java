public class FrogJumpKDist {

    public static int recK(int height[], int idx, int k){
        if (idx == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int j=1;j<=k;j++){
          int steps = Integer.MIN_VALUE;
          if (idx-j>=0) {
           steps = recK(height, idx-j, k) + Math.abs(height[idx]-height[idx-j]);
           min = Math.min(min, steps);
          }
        }
        return min;
    }
    public static void main(String[] args) {
        
    }
}

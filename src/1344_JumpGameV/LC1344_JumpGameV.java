public class LC1344_JumpGameV {
    public int maxJump(int[]arr, int d) {
        int[] dp = new int[arr.length];
        int ans = 1;
        for(int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, DFS(arr, d, i, dp));
        }
        return ans;
    }
    public int DFS(int[]arr, int d, int i, int[]dp) {
        if(dp[i] != 0) {
            return dp[i];
        }
        int res = 1;
        for(int j = i + 1; j <= Math.min(arr.length - 1, i + d) && arr[j] < arr[i]; j++) {
            res = Math.max(res, 1 + DFS(arr, d, j, dp));
        }
        for(int j = i - 1; j >= Math.max(0, i - d) && arr[j] < arr[i]; j--) {
            res = Math.max(res, 1 + DFS(arr, d, j, dp));
        }
        return dp[i] = res;
    }

    public static void main(String[] args) {
        LC1344_JumpGameV test = new LC1344_JumpGameV();
        //testcase 1
        int[] test1 = new int[]{6,4,14,6,8,13,9,7,10,6,12};
        int test1_d = 2;
        if(test.maxJump(test1, test1_d) == 4){ //res = 4;
            System.out.println("Correct!");
        }else{
            System.out.println("Wrong!");
        }

        //testcase 2
        int[] test2 = new int[]{3,3,3,3,3};
        int test2_d = 3;
        if(test.maxJump(test2, test2_d) == 1){ //res = 1;
            System.out.println("Correct!");
        }else{
            System.out.println("Wrong!");
        }
    }
}

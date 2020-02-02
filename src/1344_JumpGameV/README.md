# Leetcode 1344 Jump Game V

Use DFS + dp.
  - Constraints:
  
    Can only jump from index i to index:
    - i + x where: `i + x < arr`.length and `0 < x <= d`.
    - i - x where: `i - x >= 0` and `0 < x <= d`.
    - index j where `arr[j] < arr[i]` and all the indices `k` between `i` and `j` must follow `arr[k] < arr[i]`.
---

**Use DFS:**
  ```java
    public int DFS(int[]arr, int d, int i, int[]dp) {
        if(dp[i] != 0) {
            return dp[i];
        }
        int res = 1;
        //jump to the right side of i.
        for(int j = i + 1; j <= Math.min(arr.length - 1, i + d) && arr[j] < arr[i]; j++) {
            res = Math.max(res, 1 + DFS(arr, d, j, dp));
        }
        //jump to the left side of i.
        for(int j = i - 1; j >= Math.max(0, i - d) && arr[j] < arr[i]; j--) {
            res = Math.max(res, 1 + DFS(arr, d, j, dp));
        }
        return dp[i] = res;
        // keep recording elements in dp[] can save time when we visit the same element again.
    }
  ```

**Return the maximum value**
  

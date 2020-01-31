import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LC239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || k == 0) {
            return new int[0];
        }
        int[] ans = new int[n - k + 1];
        int ansi = 0;
        Deque<Integer> dq = new LinkedList<>();//Use Deque to record the index
        for(int i = 0 ; i < n ; i++) {
            while(!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.offer(i);
            if( i >= k - 1) {
                ans[ansi++] = nums[dq.peek()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LC239_SlidingWindowMaximum test = new LC239_SlidingWindowMaximum();
        int[] test1 = new int[]{1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(test.maxSlidingWindow(test1, 3)));
        /*
        [1,3,-1,-3,5,3,6,7]             Max
        -------------------
        [ 1, 3, -1],-3, 5, 3, 6, 7       3
          1,[3, -1, -3],5, 3, 6, 7       3
          1, 3,[-1, -3, 5],3, 6, 7       5
          1, 3, -1,[-3, 5, 3],6, 7       5
          1, 3, -1, -3,[5, 3, 6],7       6
          1, 3, -1, -3, 5,[3, 6, 7]      7

          Answer is [3, 3, 5, 5, 6, 7]
         */
    }
}

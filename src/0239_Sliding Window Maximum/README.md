# Leetcode 239 Sliding Window Maximum


Find the maximum in each sliding window:

For example:

        [1,3,-1,-3,5,3,6,7]             Max
        -------------------
        [ 1, 3, -1],-3, 5, 3, 6, 7       3
          1,[3, -1, -3],5, 3, 6, 7       3
          1, 3,[-1, -3, 5],3, 6, 7       5
          1, 3, -1,[-3, 5, 3],6, 7       5
          1, 3, -1, -3,[5, 3, 6],7       6
          1, 3, -1, -3, 5,[3, 6, 7]      7

          Answer is [3, 3, 5, 5, 6, 7]
 ---------------
 **Solution:** 
  - Use Deque to record the index in the array
    - If it is out of the sliding window, remove it from deque:
      ```java
      while(!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
      }
      ```
    - If the new number is greater than the last element in deque, remove the last element in deque:
      ```java
      while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
      }
      ```
      

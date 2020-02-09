# Leetcode 1343 Mean of Sub-arrays

1. Maintain the window of size k:
   ```java
   if (i - k >= 0) {
      sum -= arr[i - k];
   }
   ```
   
2. Check the mean of the sub-arrays:
   ```java
   if (sum / k >= threshold) {
      res++;
   }
   ```
   
Finished!

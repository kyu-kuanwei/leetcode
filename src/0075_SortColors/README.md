Two-Pass:
  - ```java
     public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int i = 0 ; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for(int i = 0 ; i < nums.length; i++){
            if(i < count[0]){
                nums[i] = 0;
            } else if (i < count[0] + count[1]){
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
      }
    ```

One-Pass:
  - ```java
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        for(int i = 0 ; i <= high ; i ++) {
            if(nums[i] == 0) {
                nums[i] = nums[low];
                nums[low++] = 0;
            } else if(nums[i] == 2){
                nums[i--] = nums[high];
                nums[high--] = 2;
            }
        }
    }
    ```
  - Use low and high two pointers to swap the element with "0" or "2".

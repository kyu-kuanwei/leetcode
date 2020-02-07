class LC75_SortColors {
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
}

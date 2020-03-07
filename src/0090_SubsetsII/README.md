Similar to [Subsets](https://github.com/kwy518/leetcode/new/master/src/0078_Subsets).

```java
public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }
    
public void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] nums, int start) {
    ans.add(new ArrayList<>(temp));
    for (int i = start; i < nums.length; i++) {
        if (i > start && nums[i] == nums[i-1]) {
            continue;
        }
        temp.add(nums[i]);
        backtrack(ans, temp, nums, i + 1);
        temp.remove(temp.size() - 1);
    }
}
```

__Modification:__

Cope with the duplication.

  - Sort the `nums` first and
  - Check if the current number is same as the last number or not. If it is same, do nothing, continue the for loop.

```java
if (i > start && nums[i] == nums[i-1]) {
    continue;
}
```

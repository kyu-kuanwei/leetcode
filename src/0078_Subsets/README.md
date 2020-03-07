Seires of Backtrack problems:
  - [Subsets](https://github.com/kwy518/leetcode/edit/master/src/0078_Subsets/)
  - [SubsetsII](https://github.com/kwy518/leetcode/edit/master/src/0090_SubsetsII/)

Standard Backtrack problem:
  ```java
  public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }
    public void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] nums, int start) {
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(ans, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
  }
  ```
  The basic structure of backtrack, which can extend to other problems.
  
  If the given nums looks like: `[1,2,3]` 
  
  The result in this structure will return the list as 
  `[[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]`

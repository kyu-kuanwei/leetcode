**BFS is a best solution here.**
  1. Construct the basic BFS structure.
     - Use `Queue<int[]>` to insert all the positions of rotten oranges to the queue by traversing the whole grid.
     - Count the fresh oranges. 
        ```java
        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0 ; j< grid[0].length ; j++) {
                if(grid[i][j] == 2) 
                    q.offer(new int[]{i, j});
                else if(grid[i][j] == 1)
                    freshCount++;
            }
        }
        ```
 2. BFS:
    - The rotting direction is only on x and y axis, therefore, we can create a direction array as 
      ```java
         int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
      ```
    - Check all directions.
      ```java
      for(int[] dir : dirs) {
        int x = pos[0] + dir[0];
        int y = pos[1] + dir[1];
      }
      ```
    - Convert the fresh orange to rotten one, and don't froget to decrease `freshCount`.
    
      ```java
      if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1){
        grid[x][y] = 2;
        q.offer(new int[]{x, y});
        freshCount --;
      }
      ```
 3. Note that, if freshCount can not decrease to __Zero__, the answer will be **-1**. 
    It's because not all the fresh oranges could be rotten. Thus, the answer will be`return freshCount == 0 ? ans - 1 : -1;`

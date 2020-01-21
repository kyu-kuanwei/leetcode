import java.util.LinkedList;
import java.util.Queue;

public class LC994_RottingOranges {
    public int orangesRotting(int[][] grid) {
        int freshCount = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0 ; j< grid[0].length ; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }
        if(freshCount == 0) return 0;
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int ans = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size ; i++) {
                int[] pos = q.poll();
                for(int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1){
                        grid[x][y] = 2;
                        q.offer(new int[]{x, y});
                        freshCount --;
                    }
                }
            }
            ans++;
        }
        return freshCount == 0 ? ans - 1 : -1;
    }

    public static void main(String[] args) {
        LC994_RottingOranges test = new LC994_RottingOranges();
        int[][] test1 = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(test.orangesRotting(test1));

        int[][] test2 = {{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(test.orangesRotting(test2));

        int[][] test3 = {{0,2}};
        System.out.println(test.orangesRotting(test3));
    }

}

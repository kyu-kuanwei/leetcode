import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LC1333_FilterRestaurants {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] == a[1] ? b[0] - a[0]: b[1]- a[1]);
        // In Priority queue's array: [ids, rating]
        // so if they have same rating, compare to their ids, or just compare their ratings.

        for(int[] r : restaurants) {
            if( r[2] >= veganFriendly && r[3] <= maxPrice && r[4] <= maxDistance) {
                pq.offer(r);
            }
        }

        while(!pq.isEmpty()) {
            ans.add(pq.poll()[0]);
        }
        return ans;
    }

    public static void main(String[] args) {
        LC1333_FilterRestaurants test = new LC1333_FilterRestaurants();
        int[][] test1 = {
                {77484,13400,1,4010,2926},
                {3336,85138,0,49966,89979},
                {28391,55328,0,69158,29058},
                {57395,64988,0,45312,30261}
        };
        System.out.println(test.filterRestaurants(test1, 0,99739, 60242));
    }
}

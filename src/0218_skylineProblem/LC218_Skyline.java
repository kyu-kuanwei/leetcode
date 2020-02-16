class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        if(buildings.length == 0) {
            return res;
        }
        List<int[]> heights = new ArrayList<>();
        for(int[] b : buildings){
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        Collections.sort(heights, (a,b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
            });
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(0);
        int prevHeight = 0;
        for(int[] h : heights){
            if(h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int curHeight = pq.peek();
            if(curHeight != prevHeight) {
                List<Integer> l = new ArrayList<>();
                l.add(h[0]);
                l.add(curHeight);
                res.add(l);
                prevHeight = curHeight;
            }
        }
        return res;
    }

}

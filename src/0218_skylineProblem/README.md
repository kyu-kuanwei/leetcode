# Leetcode 218 Skyline Problem

1. Store the buildings with custom order in list:
   - If their position is different, sort them with position. (small first)
   - If their position is same, sort them with height. (small first)
   
   **Note:**
   
   To distinguish the start point and the end point of the building, use 
   **"negative"** height to store the start point, and **"positive"** height with ending point.
   ```java
    List<int[]> heights = new ArrayList<>();
    for(int[] b : buildings){
        heights.add(new int[]{b[0], -b[2]});
        heights.add(new int[]{b[1], b[2]});
    }
    Collections.sort(heights, (a,b) -> {
        return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });
   ```
2. Use `priorityqueue` to store the heights, and in the reverse order, since we want the "skyline",
 take the highest buidling first.
  - There are two keys to distinguish the skyline:
    - Start point: If the height is changed at start point of one of the buildings, we want the start point's height.
    - End point: If the height is changed at end point of the buildings, we need next highest "height".
    
  - So in these two cases:
    - add the start point's height
    - remove the end point's height
    ```java
    if(b.height < 0) {
        pq.offer(-h[1]);
    } else {
        pq.remove(h[1]);
    }
    ```
    
  - When the height is changed, it must be the points locates at skyline.
    ```java
    if(curHeight != prevHeight) {
        List<Integer> l = new ArrayList<>();
        l.add(b.pos);
        l.add(curHeight);
        res.add(l);
        prevHeight =  curHeight;
    }
    ```

**Use BFS iteration method:**

   This is a simple BFS question. 
   
   We just need to figure out if two nodes are in the same level and have different parents or not.
   - Same level
      
        ```java
        if(node.val == A)   isAexist = true;
        if(node.val == B)   isBexist = true;
        ```
        Use two variables `isAexist` and `isBexist` distinguish if they are in the queue or not.
        
        ```java
        if (isAexist && isBexist) return true;
        else if (isAexist || isBexist) return false;
        ```

      - If only one of them exist, then it means they are not in the same queue, that is not in the same level, so the result will ne false.
      - If both of them exist in the same queue, which means that they are in the same level.
        
   
   - Different parent
     ```java
     if(node.left != null && node.right != null){ 
        if(node.left.val == A && node.right.val == B)   return false;
        if(node.left.val == B && node.right.val == A)   return false;
     }
     ```
     - Distinguish if A or B has the same parent or not.
      
    

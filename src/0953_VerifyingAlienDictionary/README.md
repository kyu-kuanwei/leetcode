1. Create a map to record the new order of alphabets.
```
  int[] newMap = new int[26];
  for(int i = 0 ; i< order.length(); i++){
    newMap[order.charAt(i) - 'a'] = i;
  }
```
2. Create a function to campare if these two strings are in order or not.
3. The compare function:
```
    for(int i = 0, j = 0 ; i < s1.length() && j < s2.length(); i++, j++){
       int pos1 = map[s1.charAt(i) - 'a'];
       int pos2 = map[s2.charAt(j) - 'a'];
       if(pos1 != pos2)
          return pos1 - pos2; 
    }
```
   - If pos1 > pos2, the result of compare function will return a positive value.
   - If pos1 < pos2, the result of the function will return a negative value.
   - If all the pos1 = pos2, then we compare the length of s1, s2. 
   ```
      return s1.length() - s2.length();
   ```
     Since the question mentions that "blank character is less than any other character, so if s1 is longer than s2,
     we return a positive value, which means they are not in the order.
   
4. Traverse the words array, and compare every two strings is in order or not.
```
      for(int i = 1 ; i < words.length ; i++){
         int res = compare(words[i-1], words[i], newMap);
         if(res > 0)
           return false;
      }
      return true;
```
   - If s1 > s2, that is not in the order.
   - If s1 <= s2, it means they are in order.

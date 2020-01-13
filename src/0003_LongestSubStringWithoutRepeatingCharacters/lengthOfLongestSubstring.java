class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int j = 0;
        int max = 1;
        if(s.length() == 0) return 0;
        
        for(int i = 0 ; i < s.length(); i++) {
            
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        
        return max;
    }
}

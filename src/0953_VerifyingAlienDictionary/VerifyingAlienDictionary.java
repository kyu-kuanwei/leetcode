public boolean isAlienSorted(String[] words, String order) {
        int[] newMap = new int[26]; // Create a map recording the new order.
        for(int i = 0 ; i< order.length(); i++){
            newMap[order.charAt(i) - 'a'] = i;
        }

        for(int i = 1 ; i < words.length ; i++){
            int res = compare(words[i-1], words[i], newMap);
            if(res > 0)
                return false;
        }
        return true;
    }

public int compare(String s1, String s2, int[] map){    // Create the function compare two string is in order or not
        for(int i = 0, j = 0 ; i < s1.length() && j < s2.length(); i++, j++){
            int pos1 = map[s1.charAt(i) - 'a'];
            int pos2 = map[s2.charAt(j) - 'a'];

            if(pos1 != pos2)
                return pos1 - pos2; // > 0 means s1 > s2; < 0 means s2 > s1;
        }
        return s1.length() - s2.length();
    }    

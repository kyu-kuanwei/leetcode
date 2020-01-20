public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        if(s.charAt(0) == '0')  return 0;      //corner case: "01", "0", "03"...
        else if(s.length() == 1)   return 1;   //else s with length 1 is 1

        for(int i = 2; i <= s.length(); i++){
            if(s.charAt(i-1) != '0'){
                dp[i] += dp[i-1];
            }
            int n = (s.charAt(i-2) - '0') * 10 + (s.charAt(i-1) - '0');
            if(n <= 26 && n >= 10){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
}

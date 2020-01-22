import java.util.Stack;

public class LC224_BasicCalculator {
    public int calculate(String s) {
        if(s.length() == 0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int sign = 1;
        int num = 0;
        int ans = 0;

        stack.push(sign);

        for(int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c <= '9' && c >= '0') {
                num = num * 10 + (c - '0');
            }else if(c == '+' || c == '-') {
                ans += sign * num;
                sign = stack.peek() * (c == '+' ? 1 : -1); // handle every sign in the bracket.
                num = 0;
            }else if(c == '(') {
                stack.push(sign);
            }else if(c == ')') {
                stack.pop();
            }
        }
        ans += sign * num; // handle last digit
        return ans;
    }

    public static void main(String[] args) {
        LC224_BasicCalculator test = new LC224_BasicCalculator();
        String test1 = "1+1 "; // ans = 2
        String test2 = "9-(8+ 2+( 3- 4 ))"; // ans = 0
        System.out.println(test.calculate(test1));
        System.out.println(test.calculate(test2));
    }
}

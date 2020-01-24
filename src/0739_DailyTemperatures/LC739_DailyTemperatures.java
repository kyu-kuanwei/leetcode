import java.util.Arrays;

public class LC739_DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        for(int i = 0 ; i < T.length; i++) {
            for(int j = i + 1; j < T.length ; j++) {
                if(T[j] > T[i]){
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC739_DailyTemperatures test = new LC739_DailyTemperatures();
        int[] test1 = new int[]{73, 74, 75, 71, 69, 72, 76, 73}; // The answer is [1, 1, 4, 2, 1, 1, 0, 0]
        System.out.println(Arrays.toString(test.dailyTemperatures(test1)));
    }
}

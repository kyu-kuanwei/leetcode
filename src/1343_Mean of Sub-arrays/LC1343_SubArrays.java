public class LC1343_SubArrays {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0, sum = 0;
        for(int i = 0 ; i < k-1 ; i++){
            sum += arr[i];
        }

        for(int i = k-1; i < arr.length; i++) {
            sum += arr[i];
            if (i - k >= 0) {
                sum -= arr[i - k];
            }
            if (sum / k >= threshold) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC1343_SubArrays test = new LC1343_SubArrays();
        int[] test1 = new int[]{2,2,2,2,5,5,5,8};
        System.out.println(test.numOfSubarrays(test1, 3, 4));
    }
}

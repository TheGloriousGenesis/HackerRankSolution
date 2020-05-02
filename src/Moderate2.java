public class Moderate2 {
    public static void main(String args[]) {
//        int[] memory = new int[6];
//        Arrays.fill(memory, -1);
//        System.out.println(fibo(5, memory));



    }

    private static int fibo(final int n, final int[] memory) {
        if (n <= 2) {
            return 1;
        }
        if (memory[n] != -1) {
            return memory[n];
        }
        int s = fibo(n-1, memory) + fibo(n-2, memory);
        memory[n] = s;
        return s;
    }

    public int Kadanes2DMatrix(int[][] array) {
        // max subMatrix
        return 0;

    }

    public int Kadanes(int[] array){
        int n = array.length;
        // sum of array until i in dp
        int[] dp = new int[n];
        //base condition
        dp[0] = array[0];
        int answer = Integer.MIN_VALUE;

        for(int i = 1; i < n; i++){
            /**
             * stores value of current array plus previous values if previous
             sum of arrays from 0 to i is not negative
             example:
                arr = [3, 4, 6]

                first round:
                    dp[1] = max(0, 0) + arr[1] --> 3
                    answer = max(min_int, dp[1]) --> dp[1] --> 3
             **/
            // this can further be improved by just storing dp[i-1] into
            // variable reducing space to O(1)
            dp[i] = Math.max(dp[i - 1], 0) + array[i];
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }


}

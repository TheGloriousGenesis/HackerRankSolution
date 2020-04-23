import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Moderate1 {
    public static void main(String args[]) {
        int[] numbers = new int[]{1, 2, 3, 4};
        numbers[2] = numbers[2] ^ numbers[3];
        // if you xor numbers[2] originally != numbers[3] then numbers[3] will flip to contain numbers[2] value
        numbers[3] = numbers[2] ^ numbers[3];
        numbers[2] = numbers[2] ^ numbers[3];
        int value = generalizedGCD(5, new int[]{2, 4, 6, 8, 10, 20});
        cellCompete(new int[]{1, 1, 1, 0, 1, 1, 1,1}, 2);
        System.out.println(value);
    }

    public static int generalizedGCD(int num, int[] arr)
    {
        arr = Arrays.stream(arr).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        int currentGeneralGCD = gcf(arr[0], arr[1]);
        for(int i = 2; i < arr.length - 1 ; i++) {
            currentGeneralGCD = gcf(currentGeneralGCD, arr[i]);
        }
        return currentGeneralGCD;
    }
    // METHOD SIGNATURE ENDS

    private static int gcf(int low, int high) {
        int[] temp = new int[] {low, high};
        Arrays.sort(temp);
        int lowestCommonNumber = temp[1] - temp[0];
        if (lowestCommonNumber != 0) {
            return gcf(lowestCommonNumber, low);
        }
        return low;
    }


    public static List<Integer> cellCompete(int[] states, int days)
    {
        int n = states.length;
        int[] nextDayState = new int[n];
        while (days > 0) {
            for(int i=0; i< n; i++) {
                if (i == 0) {
                    nextDayState[i] = states[i+1] == 0 ? 0 : 1;
                    continue;
                }
                if (i == n - 1) {
                    nextDayState[i] = states[i-1] == 0 ? 0 : 1;
                    continue;
                }
                if (states[i - 1] == states[i + 1]) {
                    nextDayState[i] = 0;
                } else {
                    nextDayState[i] = 1;
                }
            }
            states = nextDayState;
            days--;
        }

        List<Integer> listArray = new ArrayList<Integer>(nextDayState.length);
        for( int i: nextDayState) {
            listArray.add(i);
        }
        return listArray;
    }
}

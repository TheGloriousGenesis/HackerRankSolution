package Solutions.Easy;

public class Arrays_LeftRotation {
    public static void main(String[] args) {
        int[] arry = new int[]{1, 2, 3, 4};
        int[] arr = rotation(arry, arry.length, 5);
//        for(int i: arr) {
//            System.out.printf("%d ", i);
//        }
    }

    public static int[] rotation(final int[] arr, final int n, final int shiftAmount) {
        int[] rotatedArray = new int[arr.length];
        for(int i = 0; i < n; i++){
            // retrieves index in original array that should be
            // put into new array in new array order
            int newLocation = (i +  shiftAmount) % n;
            rotatedArray[i] = arr[newLocation];
        }
        return rotatedArray;
    }
}

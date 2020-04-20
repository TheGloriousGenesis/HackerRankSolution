public class Moderate1 {
    public static void main(String args[]) {
        int[] numbers = new int[]{1, 2, 3, 4};
        numbers[2] = numbers[2] ^ numbers[3];
        // if you xor numbers[2] originally != numbers[3] then numbers[3] will flip to contain numbers[2] value
        numbers[3] = numbers[2] ^ numbers[3];
        numbers[2] = numbers[2] ^ numbers[3];

        for(int i: numbers) {
            System.out.printf("%d ", i);
        }


    }
}

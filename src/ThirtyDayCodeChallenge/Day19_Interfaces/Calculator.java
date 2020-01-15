package ThirtyDayCodeChallenge.Day19_Interfaces;

class Calculator implements AdvancedArithmetic {
    public int divisorSum(int n) {
        int count = n;

        for(int i = 1; i < n; i++) {
            count+= n % i == 0 ? i : 0;
        }
        return count;
    }
}

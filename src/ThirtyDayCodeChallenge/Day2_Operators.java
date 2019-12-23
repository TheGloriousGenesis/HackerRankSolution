package ThirtyDayCodeChallenge;

public class Day2_Operators {
    static void solve(double meal_cost, int tip_percent, int tax_percent) {
        double total = meal_cost * (1.0 + (tip_percent/100.0) + (tax_percent/100.0));
        System.out.println(Math.round(total));
    }

    public static void main(String[] args){
        solve(12, 20, 8);
    }
}

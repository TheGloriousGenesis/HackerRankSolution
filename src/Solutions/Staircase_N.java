package Solutions;

public class Staircase_N {

    static void staircase(int n) {

        String spaces = "";

        int tabs=1;
        for(int i=0; i<n ; i++) {
            for(int x=1; x<n-i; x++) {
                spaces+=" ";
            }
            for(int y=0; y<tabs; y++) {
                spaces+="#";
            }
            tabs++;
            System.out.println(spaces);
            spaces="";
        }
    }

    public static void main(String[] args) {

        staircase(5);
    }
}

package Solutions.Medium;

public class NewYearChaos {
    public static void main(String[] args) {
        minimumBribes(new int[]{1,2 ,5 ,3 ,7 ,8 ,6 ,4});

    }

    static void minimumBribes(int[] a) {
        int n = a.length;
        int[] originalArray = new int[n];
//        int[] positionFromNorm = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            originalArray[i] = i + 1;
            int diffFromOrg = a[i] - originalArray[i];
            if (a[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            if (diffFromOrg >= 0) {
                count+=diffFromOrg;
            }
//            positionFromNorm[i] = diffFromOrg;
        }
//        for (int i = 0; i < n - 1; i= i + 2) {
//            if (positionFromNorm[i]==1 && positionFromNorm[i]==positionFromNorm[i+1]) {
//                count++;
//            } else if (positionFromNorm[i]==2) {
//                count+=2;
//            }
//        }
        System.out.println(count);
    }
}

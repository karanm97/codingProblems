/*
Solution of Codechef Problem - Please like me
Problem Code - PLZLYKME
Link - https://www.codechef.com/problems/PLZLYKME
*/

import java.util.Scanner;

class Plzlykme {
    public static void main(String arg[]) {

        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int p = 0; p < testCases; p++) {
            long L = sc.nextInt();
            long D = sc.nextInt();
            long S = sc.nextInt();
            long C = sc.nextInt();
            long like = S;
            for (long i = 1; i < D; i++) {
                like += like * C;
                if (like >= L)
                    break;
            }
            if (like >= L)
                System.out.println("ALIVE AND KICKING");
            else
                System.out.println("DEAD AND ROTTING");
        }
    }
}


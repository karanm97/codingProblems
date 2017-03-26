import java.util.*;
import java.io.*;

class Nukes {

    int A, K, N;
    private int[] chamber;
    Scanner sc = new Scanner(System.in);

    public void getInput() {
        A = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        chamber = new int[K];
        int i, j = 1, q=0;
        for (i = 0; i < A; i++) {
            while(j++ <= A) {
                chamber[q] = j;
            }
        }
    }

    public static void main(String args[]) {
        new Nukes().getInput();
    }
}

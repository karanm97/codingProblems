/*
	Solution of Codechef Problem - Uncle Johny
	Problem Code - JOHNY
	Link - https://www.codechef.com/problems/JOHNY
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by karan on 5.3.17.
 */
class Johny {

    int testCases, songCount;
    Scanner sc = new Scanner(System.in);
    public void getInput() {
        int j = 0;
        ArrayList<Integer> al = new ArrayList<>();
        testCases = sc.nextInt();
        while (j++ < testCases) {
            songCount = sc.nextInt();
            for (int i = 0; i < songCount; i++)
                al.add(sc.nextInt());
            int c = al.get(sc.nextInt() - 1);
            Collections.sort(al);
            System.out.println(al.indexOf(c) + 1);
            al.clear();
        }
    }

    public static void main(String[] args) {
        new Johny().getInput();
    }
}

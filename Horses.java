/*
	Solution of Codechef Problem - Racing Horses 
	Problem Code - HORSES
	Link - https://www.codechef.com/problems/HORSES
*/

import java.util.Scanner;
import java.util.Arrays;

class Horses {

    int testCases, horseCount;
    int[] horseSkill;
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new Horses().getInput();
    }

    public void getInput() {
        int j = 0, i;
        testCases = sc.nextInt();
        while (j < testCases) {
            horseCount = sc.nextInt();
            horseSkill = new int[horseCount];
            for (i = 0; i < horseCount; i++)
                horseSkill[i] = sc.nextInt();
            processArray();
            j++;
        }
    }

    public void processArray() {
        int sub = Integer.MAX_VALUE;
        Arrays.sort(horseSkill);
        for (int i = 0; i < horseCount - 1; i++) {
            if (sub > horseSkill[i + 1] - horseSkill[i]) {
                sub = horseSkill[i + 1] - horseSkill[i];
            }
        }
        System.out.println(sub);
    }
}


/*
Solution of Codechef Problem - Cats and Dogs
Problem Code - CATSDOGS
Link - https://www.codechef.com/problems/CATSDOGS
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class CATSDOGS {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while(testCases-- > 0) {
            long c = sc.nextLong();
            long d = sc.nextLong();
            long l = sc.nextLong();
            if(l % 4 != 0) {
                System.out.println("no");
            } else {
                long temp = d * 2;
                long temp1 = temp * 2;
                long rem = c + d - l / 4;
                long cond = Math.min(c, temp);
                if((c * 4 + temp1) == l || (temp1 == l && temp >= c)) {
                    System.out.println("yes");
                } else if(rem >= 0 && rem <= cond) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    }
}
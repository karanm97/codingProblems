/*
Solution of Codechef Problem - GCD and LCM
Problem Code - FLOW016
Link - https://www.codechef.com/problems/FLOW016
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class FLOW016 {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int a  =  sc.nextInt();
        while(a-- > 0) {
            long b , c, gcd = 0;
            b = sc.nextInt();
            c = sc.nextInt();
            long d = findGCD(b, c);
            System.out.println(d + " " + (b * c) / d);
        }
    }
    public static long findGCD(long a, long b) {
        long dividend = Math.max(a, b);
        long divisor = Math.min(a, b);
        long remainder;
        while(divisor != 0) {
            remainder = dividend % divisor;
            dividend = divisor;
            divisor = remainder;
        }
        return dividend;
    }
}

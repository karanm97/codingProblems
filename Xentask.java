/*
Solution of Codechef Problem - Xenny and Alternating Tasks
Problem Code - XENTASK
Link - https://www.codechef.com/MARCH17/problems/XENTASK
*/

import java.math.BigInteger;
import java.util.Scanner;

class Xentask {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int testCases;
        testCases = sc.nextInt();
        int j = 0;
        while (j++ < testCases) {
            BigInteger a = new BigInteger("0");
            BigInteger b = new BigInteger("0");
            BigInteger N = sc.nextBigInteger();
            for (
                    BigInteger i = BigInteger.ZERO;
                    i.compareTo(N) < 0;
                    i = i.add(BigInteger.ONE)
                    ) {
                int result = i.add(new BigInteger("2"))
                        .mod(new BigInteger("2"))
                        .compareTo(BigInteger.ZERO);

                if (result == 0)
                    a = a.add(sc.nextBigInteger());
                else
                    b = b.add(sc.nextBigInteger());

            }
            for (BigInteger i = BigInteger.ZERO;
                 i.compareTo(N) < 0;
                 i = i.add(BigInteger.ONE)) {
                int result = i.add(new BigInteger("2"))
                        .mod(new BigInteger("2"))
                        .compareTo(BigInteger.ZERO);

                if (result == 0)
                    b = b.add(sc.nextBigInteger());
                else
                    a = a.add(sc.nextBigInteger());

            }
            if (a.compareTo(b) < 0) 
            	System.out.println(a);
            else 
            	System.out.println(b);
        }
    }
}

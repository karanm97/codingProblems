/*
Solution of Codechef Problem - Mr Wireless
Problem Code - KOL16H
Link - https://www.codechef.com/problems/KOL16H
*/

import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

class KOL16H {

    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        int caseNumber = 1;
        final BigInteger modValue = new BigInteger("8589934592");
        final BigInteger valueTwo = new BigInteger("2");
        while(testCases-- > 0) {
            BigInteger pow = new BigInteger(fs.nextLine());
            BigInteger result = valueTwo.modPow(pow, modValue).subtract(BigInteger.ONE).add(modValue).mod(modValue);
            System.out.println("Case " + caseNumber++ + ": " + result);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException  e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
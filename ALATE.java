/*
Solution of Codechef Problem - Always Late
Problem Code - ALATE
Link - https://www.codechef.com/problems/ALATE
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class ALATE {

    private static InputStream stream;
    private static byte[] buf = new byte[1024];
    private static int curChar;
    private static int numChars;
    private static SpaceCharFilter filter;
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
    static final long MOD = (long)1e9 + 7;

    public static void main(String[] args) throws IOException {
        InputReader(System.in);
        ArrayList<Integer>[] factors = new ArrayList[100001];
        int testCases = nI();
        for(int i = 0; i <= 100000; i++) {
            factors[i] = new ArrayList();
        }
        factors = computeFactors(factors);
        while(testCases-- > 0) {
            int n = nI();
            int q = nI();
            long[] arr = new long[n + 1];
            long[] sum = new long[n + 1];
            for(int i = 1; i <= n; i++) {
                arr[i] = nL();
            }
            sum = preCompute(sum, arr, n);
            for(int k = 1; k <= q; k++) {
                if(nI() == 1) {
                    log.write(String.valueOf(sum[nI()]) + "\n");
                } else {
                    int index = nI();
                    long newValue = nL();
                    for(int a : factors[index]) {
                        sum[a] = (sum[a] - (arr[index] * arr[index]) % MOD + (newValue * newValue) % MOD + MOD) % MOD;
                    }
                    arr[index] = newValue;
                }
            }
        }
        log.flush();
    }

    public static ArrayList<Integer>[] computeFactors(ArrayList<Integer>[] factors) {
        for(int i = 1; i <= 100000; ++i) {
            for(int j = i; j <= 100000; j += i) {
                factors[j].add(i);
            }
        }
        return factors;
    }
    public static long[] preCompute(long[] sum, long[] arr, int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = i; j <= n; j += i) {
                sum[i] = (sum[i] + arr[j] * arr[j]) % MOD;
            }
        }
        return sum;
    }

    public static void InputReader(InputStream stream1) {
        stream = stream1;
    }
    private static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
    private static boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }
    private static int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }
    private static int nI() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
    private static long nL() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
    private static String nS() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }
    private static String nLi() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    }
    private static boolean isSpaceChar(int c) {
        if (filter != null) {
            return filter.isSpaceChar(c);
        }
        return isWhitespace(c);
    }
    private interface SpaceCharFilter {

        public boolean isSpaceChar(int ch);
    }
}
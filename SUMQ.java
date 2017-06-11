/*
Solution of Codechef Problem - Triplets
Problem Code - SUMQ
Link - https://www.codechef.com/problems/SUMQ
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class SUMQ {

    private static InputStream stream;
    private static byte[] buf = new byte[1024];
    private static int curChar;
    private static int numChars;
    private static SpaceCharFilter filter;
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        InputReader(System.in);
        int testCases = nI();
        int pCount, qCount, rCount;
        long[] p, q, r;
        for(int z = 0; z < testCases; z++) {
            pCount = nI();
            qCount = nI();
            rCount = nI();
            p = new long[pCount];
            q = new long[qCount];
            r = new long[rCount];
            long result = 0, maxQ = Long.MIN_VALUE;
            for(int i = 0; i < pCount; i++) {
                p[i] = nL();
            }
            for(int i = 0; i < qCount; i++) {
                q[i] = nL();
                if(q[i] > maxQ) {
                    maxQ = q[i];
                }
            }
            for(int i = 0; i < rCount; i++) {
                r[i] = nL();
            }
            Arrays.sort(p);
            Arrays.sort(q);
            Arrays.sort(r);
            for(int i = 0; i < pCount && p[i] <= maxQ; i++) {
                for(int j = 0; j < qCount; j++) {
                    for(int k = 0; k < rCount && r[k] <= maxQ; k++) {
                        if((p[i] <= q[j]) && (r[k] <= q[j])) {
                            result += ((p[i] + q[j]) * (r[k] + q[j]));
                        }
                    }
                }
            }
            result %= 1000000007;
            log.write(String.valueOf(result) + "\n");
        }
        log.flush();
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
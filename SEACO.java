/*
Solution of Codechef Problem - Sereja and Commands
Problem Code - SEACO
Link - https://www.codechef.com/problems/SEACO
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class SEACO {

    private static InputStream stream;
    private static byte[] buf = new byte[1024];
    private static int curChar;
    private static int numChars;
    private static SpaceCharFilter filter;
    private static final long MOD = 1000000007;
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        InputReader(System.in);
        int testcases = nI();
        while(testcases-- > 0) {
            int n = nI();
            int m = nI();
            int[][] commands = new int[m + 1][3];
            long[] range = new long[n + 2];
            long[] cnt = new long[m + 1];
            for(int i = 1; i <= m; i++) {
                commands[i] = new int[] {nI(), nI(), nI()};
            }
            Arrays.fill(cnt, 1);
            for(int i = m; i >= 1; i--) {
                if(commands[i][0] == 2) {
                    for(int j = commands[i][1]; j <= commands[i][2]; j++) {
                        cnt[j] += cnt[i] % MOD;
                    }
                }
            }
            for(int i = 1; i <= m; i++) {
                if(commands[i][0] == 1) {
                    range[commands[i][1]] += cnt[i] % MOD;
                    range[commands[i][2] + 1] -= cnt[i] % MOD;
                }
            }
            for(int i = 1; i <= n; i++) {
                range[i] += range[i - 1];
                log.write(String.valueOf(range[i] % MOD) + " ");
            }
            log.write("\n");
            log.flush();
        }
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
/*
Solution of Codechef Problem - Total Diamonds
Problem Code - VK18
Link - https://www.codechef.com/problems/VK18
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class VK18 {

    private static InputStream stream;
    private static byte[] buf = new byte[1024];
    private static int curChar;
    private static int numChars;
    private static SpaceCharFilter filter;
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        InputReader(System.in);
        int testCases = nI();
        long[] dp = new long[2000001];
        long[] sum = new long[2000001];
        long[] ans = new long[1000001];
        for(int i = 1; i <= 2000000; i++) {
            dp[i] = calculateDiamonds(i);
        }
        for(int i = 1; i <= 2000000; i++) {
            sum[i] = sum[i - 1] + dp[i];
        }
        ans[1] = 2;
        for(int i = 2; i <= 1000000; i++) {
            ans[i] = ans[i - 1] + 2 * (sum[2 * i - 1] - sum[i]) + dp[i * 2];
        }
        while(testCases-- > 0) {
            log.write(String.valueOf(ans[nI()]) + "\n");
        }
        log.flush();
    }

    public static long calculateDiamonds(long roomNumber) {
        int evenNumber = 0, oddNumber = 0;
        while (roomNumber > 0) {
            if ((roomNumber % 10) % 2 == 0) {
                evenNumber += roomNumber % 10;
            } else {
                oddNumber += roomNumber % 10;
            }
            roomNumber = roomNumber / 10;
        }
        return Math.abs(oddNumber - evenNumber);
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
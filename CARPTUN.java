/*
Solution of Codechef Problem - Car-pal Tunnel
Problem Code - CARPTUN
Link - https://www.codechef.com/problems/CARPTUN
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class CARPTUN {

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
        while(testCases-- > 0) {
            int n = nI();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = nI();
            }
            int carCount = nI();
            int tunnelDistance = nI();
            int speed = nI();
            double time = tunnelDistance / speed;
            double[][] dp = new double[carCount][n];
            double waitingTime = 0, arrivalTime = 0;
            dp[0][0] = arr[0];
            for(int i = 1; i < n; i++) {
                dp[0][i] = dp[0][i - 1] + arr[i] + time;
            }
            for(int i = 1; i <= carCount - 1; i++) {
                dp[i][0] = dp[i - 1][0] + arr[0];
            }
            for(int i = 1; i < carCount; i++) {
                for(int j = 1; j < n; j++) {
                    arrivalTime = dp[i][j - 1] + time;
                    if(arrivalTime > dp[i - 1][j]) {
                        waitingTime = 0;
                    } else {
                        waitingTime = dp[i - 1][j] - arrivalTime;
                    }
                    dp[i][j] = arrivalTime + waitingTime + arr[j];
                }
            }
            log.write(String.valueOf((dp[carCount - 1][n - 1] - dp[0][n - 1])) + "\n");
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
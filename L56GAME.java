/*
Solution of Codechef Problem - Chef and Game with Sequence
Problem Code - L56GAME
Link - https://www.codechef.com/problems/L56GAME
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class L56GAME {

    private static InputStream stream;
    private static byte[] buf = new byte[1024];
    private static int curChar;
    private static int numChars;
    private static SpaceCharFilter filter;
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        InputReader(System.in);
        int testCases = nI();
        while(testCases-- > 0) {
            int n = nI();
            int even = 0, odd = 0, total = 0;
            for(int i = 0; i < n; i++) {
                int temp = nI();
                if(temp % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            even = (even > 0) ? 1 : 0;
            odd = (odd > 0) ? ((odd % 2 == 0) ? (1) : (2)) : 0;
            total = odd + even;
            if(total == 3) {
                System.out.println("2");
            } else if(odd == 2) {
                System.out.println("2");
            } else if(total == 2) {
                System.out.println("1");
            } else {
                System.out.println("1");
            }
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
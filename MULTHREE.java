/*
Solution of Codechef Problem - Multiple of 3
Problem Code - MULTHREE
Link - https://www.codechef.com/problems/MULTHREE
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class MULTHREE {

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
            long k = nL();
            long d0 = nL();
            long d1 = nL();
            String s = "" + d0 + "" + d1;
            long answer = getSum(s);
            long d2 = (d0 + d1) % 10;
            if(k == 2) {
            } else if (k == 3) {
                answer += d2;
            } else {
                long alpha = ((k - 3) / 4);
                alpha = alpha * ((2 * d2) % 10 + (4 * d2) % 10 + (8 * d2) % 10 + (6 * d2) % 10);
                long beta = (k - 3) % 4;
                for(int i = 0; i < beta; i++) {
                    if(i == 0) {
                        answer += (2 * d2) % 10;
                    } else if (i == 1) {
                        answer += (4 * d2) % 10;
                    } else if (i == 2) {
                        answer += (8 * d2) % 10;
                    } else if (i == 3) {
                        answer += (6 * d2) % 10;
                    }
                }
                answer += d2 + alpha;
            }
            if(answer % 3 == 0) {
                log.write("YES\n");
            } else {
                log.write("NO\n");
            }
        }
        log.flush();
    }

    public static long getSum(String s) {
        long sum = 0;
        for(int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
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
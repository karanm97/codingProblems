/*
Solution of Codechef Problem - Chef and Sub Array
Problem Code - CHEFSUBA
Link - https://www.codechef.com/MAY17/problems/CHEFSUBA
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class CHEFSUBA {

    private static InputStream stream;
    private static byte[] buf = new byte[1024];
    private static int curChar;
    private static int numChars;
    private static SpaceCharFilter filter;
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        InputReader(System.in);
        int N = nI(), K = nI(), P = nI();
        StringBuilder string = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int temp = nI();
            string.append(temp);
        }
        char[] dogRequest = nLi().toCharArray();
        for(char charIterator : dogRequest) {
            if(charIterator == '?') {
                log.write(String.valueOf(returnWindowMax(string, K, N)) + "\n");
            } else {
                char lastChar = string.charAt(N - 1);
                string.delete(N - 1, N);
                string.insert(0, lastChar);
            }
        }
        log.close();
    }

    public static long returnWindowMax(StringBuilder string1, int K, int N) {
        long max_sum = Long.MIN_VALUE ;
        for (int i = 0; i < N - K + 1; i++) {
            int current_sum = 0;
            for (int j = 0; j < K; j++) {
                int temp = string1.charAt(i + j) - '0';
                current_sum = current_sum + temp;
            }
            max_sum = Math.max(current_sum, max_sum);
        }
        return max_sum;
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
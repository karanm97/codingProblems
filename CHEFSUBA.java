/*
Solution of Codechef Problem - Chef and Sub Array
Problem Code - CHEFSUBA
Link - https://www.codechef.com/problems/CHEFSUBA
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
        int n = nI();
        int k = nI();
        int p = nI();
        int startIndex = 0;
        k = Math.min(k, n);
        int[] arr = new int[2 * n];
        for(int i = 0; i < n; i++) {
            arr[i] = arr[i + n] = nI();
        }
        String input = nLi();
        Deque<Integer> deck = new ArrayDeque<>();
        int sum, max, windowIndex;
        for(int i = 0; i < input.length(); i++) {
            sum = 0;
            max = Integer.MIN_VALUE;
            if(input.charAt(i) == '?') {
                for(int j = startIndex; j < startIndex + k; j++) {
                    deck.add(arr[j]);
                    sum += arr[j];
                }
                max = sum;
                windowIndex = startIndex + k;
                for(int j = windowIndex; j <= startIndex + n - 1; j++) {
                    sum +=  arr[j] - deck.poll();
                    deck.add(arr[j]);
                    if(sum > max) {
                        max = sum;
                    }
                }
                deck.clear();
                log.write(String.valueOf(max + "\n"));
            } else {
                startIndex = (startIndex + n - 1) % n;
            }
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
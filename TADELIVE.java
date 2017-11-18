/*
Solution of Codechef Problem - Delivery Man
Problem Code - TADELIVE
Link - https://www.codechef.com/problems/TADELIVE
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class TADELIVE {

    static class Node {
        private int a, b, diff;
        public Node(int a, int b) {
            this.a = a;
            this.b = b;
            this.diff = a - b;
        }
    }

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
        int X = nI();
        int Y = nI();
        int[] A = new int[n];
        int[] B = new int[n];
        Node[] difference = new Node[n];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            A[i] = nI();
        }
        for(int i = 0; i < n; i++) {
            B[i] = nI();
            difference[i] = new Node(A[i], B[i]);
        }
        Arrays.sort(difference, new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return n2.diff - n1.diff;
            }
        });
        for(int i = 0; i < n; i++) {
            if(difference[i].diff > 0) {
                if(X > 0) {
                    X--;
                    sum += difference[i].a;
                } else {
                    Y--;
                    sum += difference[i].b;
                }
            } else {
                if(Y > 0) {
                    Y--;
                    sum += difference[i].b;
                } else {
                    X--;
                    sum += difference[i].a;
                }
            }
        }
        log.write(String.valueOf(sum) + "\n");
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
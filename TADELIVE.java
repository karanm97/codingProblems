/*
Solution of Codechef Problem - Delivery Man
Problem Code - TADELIVE
Link - https://www.codechef.com/problems/TADELIVE
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class TADELIVE {

    static class Node implements Comparable<Node> {
        private int value, index;
        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
        public int compareTo(Node node) {
            return this.value - node.value;
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
        int x = nI();
        int y = nI();
        int[] aTips = new int[n];
        int[] bTips = new int[n];
        int[] diffA = new int[n];
        int[] diffB = new int[n];
        int sumA = 0, sumB = 0, c = y, d = x;
        PriorityQueue<Node> queueA = new PriorityQueue<Node>((p, q) -> q.value - p.value);
        PriorityQueue<Node> queueB = new PriorityQueue<Node>((p, q) -> q.value - p.value);
        for(int i = 0; i < n; i++) {
            aTips[i] = nI();
        }
        for(int i = 0; i < n; i++) {
            bTips[i] = nI();
            diffA[i] = aTips[i] - bTips[i];
            diffB[i] = bTips[i] - aTips[i];
            queueA.add(new Node(diffA[i], i));
            queueB.add(new Node(diffB[i], i));
        }
        for(int i = 0; i < x; i++) {
            sumA += aTips[queueA.poll().index];
        }
        while(!queueA.isEmpty() && c >= 1) {
            sumA += bTips[queueA.poll().index];
            c--;
        }
        for(int i = 0; i < y; i++) {
            sumB += bTips[queueB.poll().index];
        }
        while(!queueB.isEmpty() && d >= 1) {
            sumB += aTips[queueB.poll().index];
            d--;
        }
        log.write(String.valueOf(Math.max(sumA, sumB)) + "\n");
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
/*
Solution of Codechef Problem - Game with numbers
Problem Code - GAMENUMB
Link - https://www.codechef.com/problems/GAMENUMB
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class GAMENUMB {

    private static InputStream stream;
    private static byte[] buf = new byte[1024];
    private static int curChar;
    private static int numChars;
    private static SpaceCharFilter filter;
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Pair implements Comparable<Pair> {
        int a, n;

        public Pair(int a, int n) {
            this.a = a;
            this.n = n;
        }

        public int compareTo(Pair x) {
            if(a == x.a) {
                return 0;
            } else if(a > x.a) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InputReader(System.in);
        int testCases = nI();
        while(testCases-- > 0) {
            int n = nI();
            int k = nI();
            int[] arrA = new int[n];
            int[] arrN = new int[n];
            PriorityQueue<Pair> maxQueue = new PriorityQueue<>((x, y) -> y.a - x.a);
            PriorityQueue<Pair> minQueue = new PriorityQueue<>();
            long oddSum = 0, evenSum = 0;
            for(int i = 0; i < n; i++) {
                arrA[i] = nI();
            }
            for(int i = 0; i < n; i++) {
                arrN[i] = nI();
                maxQueue.add(new Pair(arrA[i], arrN[i]));
            }
            for(int i = 0; i < k; i++) {
                int arrB = nI();
                if((i + 1) % 2 == 1) {
                    if(maxQueue.peek().n > arrB) {
                        oddSum = (maxQueue.peek().a * arrB);
                        minQueue.add(new Pair(maxQueue.peek().a, arrB));
                    } else {
                        int total = arrB;
                        Pair pair;
                        while(total > 0) {
                            pair = maxQueue.peek();
                            if(total - pair.n >= 0) {
                                total -= pair.n;
                                minQueue.add(new Pair(pair.a, pair.n));
                                oddSum += (pair.a * pair.n);
                                maxQueue.poll();
                            } else {
                                minQueue.add(new Pair(pair.a, total));
                                oddSum += (pair.a * total);
                                break;
                            }
                        }
                    }
                    maxQueue.clear();
                    evenSum = 0;
                } else {
                    if(minQueue.peek().n > arrB) {
                        evenSum = (minQueue.peek().a * arrB);
                        maxQueue.add(new Pair(minQueue.peek().a, arrB));
                    } else {
                        int total = arrB;
                        Pair pair;
                        while(total > 0) {
                            pair = minQueue.peek();
                            if(total - pair.n >= 0) {
                                total -= pair.n;
                                maxQueue.add(new Pair(pair.a, pair.n));
                                evenSum += (pair.a * pair.n);
                                minQueue.poll();
                            } else {
                                maxQueue.add(new Pair(pair.a, total));
                                evenSum += (pair.a * total);
                                break;
                            }
                        }
                    }
                    minQueue.clear();
                    oddSum = 0;
                }
            }
            log.write(String.valueOf(k % 2 == 1 ? oddSum : evenSum) + "\n");
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
/*
Solution of Codechef Problem - Chef and the Feast
Problem Code - NEO01
Link - https://www.codechef.com/problems/NEO01
*/

import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.BigInteger;

class NEO01 {

    private static InputStream stream;
    private static byte[] buf = new byte[1024];
    private static int curChar;
    private static int numChars;
    private static SpaceCharFilter filter;
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        InputReader(System.in);
        // Long approach
        /*
        int testCases = nI();
        long result, counter, positive;
        while(testCases-- > 0) {
            long size = nL();
            result = 0;
            counter = 0;
            positive = 0;
            while(size-- > 0) {
                long temp = nL();
                if(temp >= 0) {
                    positive += temp;
                    counter++;
                } else {
                    result += temp + (positive * counter);
                    positive = 0;
                    counter = 0;
                }
            }
            result += (positive * counter);
            log.write(String.valueOf(result) + "\n");
            log.flush();
            */
        // BigInteger approach
        int testCases = nI();
        for(int j = 0; j < testCases && testCases <= 8 && testCases >= 1; j++) {
            long size = nL();
            BigInteger resultBig = new BigInteger("0"),
            counterBig = new BigInteger("0"), positiveBig = new BigInteger("0");
            if(size <= 100000 && size >= 1) {
                for(int i = 0; i < size; i++) {
                    BigInteger tempBig = BigInteger.valueOf(nL());
                    if(tempBig.compareTo(BigInteger.ZERO) >= 0) {
                        positiveBig = positiveBig.add(tempBig);
                        counterBig = counterBig.add(BigInteger.ONE);
                    } else {
                        resultBig = resultBig.add(tempBig).add(positiveBig.multiply(counterBig));
                        counterBig = BigInteger.ZERO;
                        positiveBig = BigInteger.ZERO;
                    }
                }
                resultBig = resultBig.add(positiveBig.multiply(counterBig));
            }
            log.write(resultBig.toString() + "\n");
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
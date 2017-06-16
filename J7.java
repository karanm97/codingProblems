/*
Solution of Codechef Problem - The Best Box
Problem Code - J7
Link - https://www.codechef.com/problems/J7
*/

/*
	Logic - For a rectangular box to have maximum volume, two of the sides need to be equal.
	1) Let the sides of the rectangle be a, b, c.
	2) Since we need the maximum volume, let b = c. Therefore sides are a, b, b.
	3) We derive 2 Equations from the given parameters P and S. It goes as following.
	4) Equation 1 : 4a + 8b = P 	// sum of lengths that form the rectangular frame
	5) Equation 2 : 4*ab + 2*b^2 = S		// sum of the surface areas of the rectangular box
	6) Solving equations 1 and 2, we find either a or b in terms of the b or a respectively.
*/

import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.DecimalFormat;

class J7 {

    private static InputStream stream;
    private static byte[] buf = new byte[1024];
    private static int curChar;
    private static int numChars;
    private static SpaceCharFilter filter;
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        InputReader(System.in);
        DecimalFormat f = new DecimalFormat("##.00");
        int testCases = nI();
        double commonSide, uniqueSide;
        while(testCases-- > 0) {
     		int P = nI();
     		int S = nI();
     		commonSide = (P - Math.sqrt(P*P-24*S))/12;
     		uniqueSide = (P/4) - (2*commonSide);
     		log.write(f.format(uniqueSide*commonSide*commonSide) + "\n");
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
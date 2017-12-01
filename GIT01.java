/*
Solution of Codechef Problem - Chef And his Cake
Problem Code - GIT01
Link - https://www.codechef.com/problems/GIT01
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class GIT01 {

    private static InputStream stream;
    private static byte[] buf = new byte[1024];
    private static int curChar;
    private static int numChars;
    private static SpaceCharFilter filter;
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        InputReader(System.in);
        int testCases = nI();
        String[][] case1 = new String[100][100];
        String[][] case2 = new String[100][100];
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(i % 2 == 0) {
                    if(j % 2 == 0) {
                        case1[i][j] = "R";
                        case2[i][j] = "G";
                    } else {
                        case1[i][j] = "G";
                        case2[i][j] = "R";
                    }
                } else {
                    if(j % 2 == 0) {
                        case1[i][j] = "G";
                        case2[i][j] = "R";
                    } else {
                        case1[i][j] = "R";
                        case2[i][j] = "G";
                    }
                }
            }
        }
        while(testCases-- > 0) {
            int n = nI();
            int m = nI();
            String[][] matrix = new String[n][m];
            for(int i = 0; i < n; i++) {
                matrix[i] = nLi().split("");
            }
            int counter1 = 0, counter2 = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(!matrix[i][j].equals(case1[i][j])) {
                        if(matrix[i][j].equals("R")) {
                            counter1 += 5;
                        } else {
                            counter1 += 3;
                        }
                    }
                    if(!matrix[i][j].equals(case2[i][j])) {
                        if(matrix[i][j].equals("G")) {
                            counter2 += 3;
                        } else {
                            counter2 += 5;
                        }
                    }
                }
            }
            log.write(String.valueOf(Math.min(counter1, counter2)) + "\n");
            log.flush();
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
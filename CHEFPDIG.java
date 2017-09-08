/*
Solution of Codechef Problem - Chef and Pick Digit
Problem Code - CHEFPDIG
Link - https://www.codechef.com/problems/CHEFPDIG
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class CHEFPDIG {

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
            String input = nLi();
            boolean[] digit = new boolean[10];
            boolean pairOfSix = false, pairOfSeven = false, pairOfEight = false;
            Arrays.fill(digit, false);
            digit = findOccurence(input, digit);
            if(input.indexOf("6") != input.lastIndexOf("6")) {
                pairOfSix = true;
            }
            if(input.indexOf("7") != input.lastIndexOf("7")) {
                pairOfSeven = true;
            }
            if(input.indexOf("8") != input.lastIndexOf("8")) {
                pairOfEight = true;
            }
            StringBuilder stringBuilder = new StringBuilder();
            if(digit[6]) {
                for(int i = 5; i <= 9; i++) {
                    if(digit[i]) {
                        if (i != 6) {
                            char letter = (char) (60 + i);
                            log.write(letter);
                        } else if(i == 6 && pairOfSix) {
                            log.write("B");
                        }
                    }
                }
            }
            if(digit[7]) {
                for(int i = 0; i <= 9; i++) {
                    if(digit[i]) {
                        if (i != 7) {
                            char letter = (char) (70 + i);
                            log.write(letter);
                        } else if(i == 7 && pairOfSeven) {
                            log.write("M");
                        }
                    }
                }
            }
            if(digit[8]) {
                for(int i = 0; i <= 9; i++) {
                    if(digit[i]) {
                        if (i != 8) {
                            char letter = (char) (80 + i);
                            log.write(letter);
                        } else if(i == 8 && pairOfEight) {
                            log.write("X");
                        }
                    }
                }
            }
            if(digit[9] && digit[0]) {
                log.write("Z");
            }
            log.write("\n");
            log.flush();
        }
    }

    public static boolean[] findOccurence(String input, boolean[] digit) {
        for(int i = 0; i < 10; i++) {
            if(input.contains(String.valueOf(i))) {
                digit[i] = true;
            }
        }
        return digit;
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
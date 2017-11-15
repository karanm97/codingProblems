/*
Solution of Codechef Problem - Chef Hates Palindromes
Problem Code - CHEFHPAL
Link - https://www.codechef.com/problems/CHEFHPAL
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class CHEFHPAL {

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
            int n = nI();
            int a = nI();
            if(a == 1) {
                log.write(String.valueOf(n) + " ");
                for(int i = 0; i < n; i++) {
                    log.write("a");
                }
            } else if(a == 2) {
                if(n == 1) {
                    log.write("1 a");
                } else if(n == 2) {
                    log.write("1 ab");
                } else if(n == 3) {
                    log.write("2 abb");
                } else if(n == 4) {
                    log.write("2 aabb");
                } else if(n == 5) {
                    log.write("3 aabbb");
                } else if(n == 6) {
                    log.write("3 aaabbb");
                } else if(n == 7) {
                    log.write("3 aaababb");
                } else if(n == 8) {
                    log.write("3 aaababbb");
                } else {
                    String template = "aababb";
                    log.write("4 ");
                    for(int i = 0; i < n; i++) {
                        log.write(String.valueOf(template.charAt(i % 6)));
                    }
                }
            } else {
                log.write("1 ");
                for(int i = 0; i < n; i++) {
                    log.write(String.valueOf((char)('a' + (i % a))));
                }
            }
            log.write("\n");
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
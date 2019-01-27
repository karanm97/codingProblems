import java.util.*;
import java.io.*;
import java.lang.*;

class WTCH {

    private static InputStream stream;
    private static byte[] buf = new byte[1024];
    private static int curChar;
    private static int numChars;
    private static SpaceCharFilter filter;
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("case.txt"));
        InputReader(System.in);
        int t = nI();
        while (t-- > 0) {
            int n = nI();
            String s = nLi();
            if(allZeroes(s)) {
                System.out.println((n % 2 == 0) ? (n/2) : (n/2 + 1));
            } else {
                s = "x"+s+"x";
                            // System.out.println(s);
            int counter = 0;
            // System.out.println(s.charAt(1) + "  " + s.charAt(s.length() - 2));
            for(int i = 1; i <= s.length() - 2; i++) {
                if(s.charAt(i) == '1') {
                    i++;
                }
                else if (s.charAt(i - 1) == 'x' && s.charAt(i + 1) == '0') {
                    counter++;
                    i++;

                }
                else if (s.charAt(i - 1) == '0' && s.charAt(i + 1) == '0') {
                    counter++;
                    i++;
                }
                
                else if (s.charAt(i - 1) == '0' && s.charAt(i + 1) == 'x') {
                    counter++;
                    i++;
                }
            }
            System.out.println(counter);
            }

        }
        log.flush();
    }

    public static boolean allZeroes(String s) {
        boolean hasOne = true;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                return false;
            }
        }
        return hasOne;
    }

    public static boolean isValid(long a, long b, long c) {
        if (a + b < c || a + c < b || b + c < a) {
            return false;
        }
        return true;
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
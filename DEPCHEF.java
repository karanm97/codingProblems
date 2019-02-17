import java.util.*;
import java.io.*;
import java.lang.*;

class DEPCHEF {

    private static InputStream stream;
    private static byte[] buf = new byte[1024];
    private static int curChar;
    private static int numChars;
    private static SpaceCharFilter filter;
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("case.txt"));
        InputReader(System.in);
        int t = nI();
        while (t-- > 0) {
            int n = nI();
            int[] a = new int[n];
            int[] d = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nI();
            }
            for (int i = 0; i < n; i++) {
                d[i] = nI();
            }
            int maxDefenseValue = Integer.MIN_VALUE, currentDefenseValue;
            // For first soldier
            if (d[0] > (a[1] + a[n - 1])) {
                currentDefenseValue = d[0];
                maxDefenseValue = Math.max(currentDefenseValue, maxDefenseValue);
            }

            // For last soldier
            if (d[n-1] > (a[0] + a[n - 2])) {
                currentDefenseValue = d[n-1];
                maxDefenseValue = Math.max(currentDefenseValue, maxDefenseValue);
            }
            // For rest of the soldiers
            for (int i = 1; i < n - 1; i++) {
                if (d[i] > (a[i - 1] + a[i + 1])) {
                    currentDefenseValue = d[i];
                    maxDefenseValue = Math.max(currentDefenseValue, maxDefenseValue);
                }
            }
            if(maxDefenseValue == Integer.MIN_VALUE) {
                System.out.println("-1");
            }
            else {
                System.out.println(maxDefenseValue);
            }
        }
        log.flush();
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
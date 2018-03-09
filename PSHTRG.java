/*
5 4
3 1 8 9 7
2 1 5
1 2 12
2 1 3
2 2 5

op -
24
0
29
*/
import java.util.*;
import java.io.*;
import java.lang.*;

class PSHTRG {

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
        int q = nI();
        long[] array = new long[n + 1];
        for(int i = 0; i < n; i++) {
            array[i] = nL();
        }
        for(int i = 1; i <= q; i++) {
            int type = nI();
            if(type == 1) {
                array[nI() - 1] = nL();
            } else {
                int left = nI();
                int right = nI();
                if(right - left < 2) {
                    log.write("0\n");
                } else {
                    long[] tempArray = new long[right - left + 1];
                    int index = 0;
                    for(int j = left - 1; j <= right - 1; j++) {
                        tempArray[index] = array[j];
                        index++;
                    }
                    Arrays.sort(tempArray);
                    boolean isTriangle = false;
                    for(int j = right - left; j >= 2; j--) {
                        if(tempArray[j] < tempArray[j - 1] + tempArray[j - 2]) {
                            log.write(String.valueOf((tempArray[j] + tempArray[j - 1] + tempArray[j - 2])) + "\n");
                            isTriangle = true;
                            break;
                        }
                    }
                    if(!isTriangle) {
                        log.write("0\n");
                    }
                }
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
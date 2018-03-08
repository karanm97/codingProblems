/*
5 3
20 11 18 2 13
1 3
3 5
2 4

op -
2147483629
2147483645
2147483645
*/
import java.util.*;
import java.io.*;
import java.lang.*;

class XXOR {

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
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = nI();
        }
        for(int i = 1; i <= q; i++) {
            int left = nI() - 1;
            int right = nI() - 1;
            System.out.println(calculateXor(left, right, arr));
        }
    }

    public static int calculateXor(int left, int right, int[] arr) {
        int[] common = new int[32];
        int x, sum = 0;
        for(int i = left; i <= right; i++) {
            for(int j = 0; j <= 32; j++) {
                x = 1 << j;
                if ((arr[i] & x) == Math.pow(2, j)) {
                    common[j] += 1;
                }
            }
        }
        for(int i = 0; i < 32; i++) {
            if(common[i] > (right - left) / 2) {
                common[i] = 1;
                sum += Math.pow(2, i);
            } else {
                common[i] = 0;
            }
        }
        // for(int i = 0; i < 32; i++) {
        //     if(common[i] == 1) {
        //         sum += Math.pow(2, i);
        //     }
        // }
        // System.out.println("***");
        // for(int i = 0; i < 32; i++) {
        //     System.out.print(common[i] + " ");
        // }
        // System.out.println();
        // System.out.println("***");
        // System.out.println("the sum is " + sum);
        // System.out.println("the sum is " + sum);
        return Integer.MAX_VALUE - sum;
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
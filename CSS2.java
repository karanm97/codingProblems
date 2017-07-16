/*
Solution of Codechef Problem - Cascading Style Sheets
Problem Code - CSS2
Link - https://www.codechef.com/problems/CSS2
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class Css {
    int priority, value;
    public Css(int priority, int value) {
        this.priority = priority;
        this.value = value;
    }
}

class CSS2 {

    private static InputStream stream;
    private static byte[] buf = new byte[1024];
    private static int curChar;
    private static int numChars;
    private static SpaceCharFilter filter;
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void solve() throws IOException {
        InputReader(System.in);
        int n = nI();
        int m = nI();
        int id, attribute, value, priority, p;
        HashMap<Integer, HashMap<Integer, Css>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            id = nI();
            attribute = nI();
            value = nI();
            priority = nI();
            if(map.containsKey(id)) {
                Map<Integer, Css> mp = map.get(id);
                if(mp.containsKey(attribute)) {
                    Css var = mp.get(attribute);
                    if(priority >= var.priority) {
                        var.priority = priority;
                        var.value = value;
                    }
                } else {
                    mp.put(attribute, new Css(priority, value));
                }
            } else {
                HashMap<Integer, Css> mp = new HashMap<Integer, Css>();
                mp.put(attribute, new Css(priority, value));
                map.put(id, mp);
            }
        }
        for(int i = 0; i < m; i++) {
            id = nI();
            attribute = nI();
            HashMap<Integer, Css> mp = map.get(id);
            log.write(String.valueOf(mp.get(attribute).value) + "\n");
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
/*
Solution of Codechef Problem - K-good Words
Problem Code - KGOOD
Link - https://www.codechef.com/problems/KGOOD
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class KGOOD {

    private static InputStream stream;
    private static byte[] buf = new byte[1024];
    private static int curChar;
    private static int numChars;
    private static SpaceCharFilter filter;
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        InputReader(System.in);
        Map<Character, Integer> map;
        int testCases = nI(), value = 0;
        while(testCases-- > 0) {
            String[] line = nLi().split(" ");
            map = new HashMap<>();
            for(int i = 0; i < line[0].length(); i++) {
                char key = line[0].charAt(i);
                if(map.containsKey(key)) {
                    value = map.get(key);
                    map.put(key, ++value);
                } else {
                    map.put(key, 1);
                }
            }
            ArrayList<Integer> list = new ArrayList<>(map.values());
            Collections.sort(list);
            for(int a : list) {
                log.write(a + " ");
            }
            long counter = 0, value1 = 0, value2 = 0;
            for(int i = list.size() - 1; i >= 1; i--) {
                for(int j = i - 1; j >= 0; j--) {
                    value1 = list.get(i);
                    value2 = list.get(j);
                    if(Math.abs(value1 - value2) > Integer.parseInt(line[1])) {
                        counter++;
                        break;
                    }
                }
            }
            log.write(String.valueOf(counter) + "\n");
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
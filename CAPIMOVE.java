/*
Solution of Codechef Problem - Capital Movement
Problem Code - CAPIMOVE
Link - https://www.codechef.com/problems/CAPIMOVE
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class CAPIMOVE {

    private static InputStream stream;
    private static byte[] buf = new byte[1024];
    private static int curChar;
    private static int numChars;
    private static SpaceCharFilter filter;
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException, NumberFormatException {
        InputReader(System.in);
        int testCases = nI();
        while(testCases-- > 0) {
            int n = nI();
            int[] population = new int[n];
            TreeMap<Integer, Integer> map = new TreeMap<>();
            ArrayList<ArrayList<Integer>> neighbours = new ArrayList<>(n);
            for(int i = 0; i < n; i++) {
                population[i] = nI();
                map.put(population[i], i);
                neighbours.add(new ArrayList<>());
            }
            int capital = map.lastEntry().getValue();
            for(int i = 0; i < n - 1; i++) {
                int v = nI() - 1;
                int u = nI() - 1;
                neighbours.get(v).add(u);
                neighbours.get(u).add(v);
            }
            HashSet<Integer> capitalNeighbours = new HashSet<>(neighbours.get(capital));
            for(int i = 0; i < n; i++) {
                if(i == capital || capitalNeighbours.contains(i)) {
                    TreeMap<Integer, Integer> temporaryMap = new TreeMap<>();
                    temporaryMap.put(population[i], i);
                    map.remove(population[i]);
                    for(Integer a : neighbours.get(i)) {
                        temporaryMap.put(population[a], a);
                        map.remove(population[a]);
                    }
                    if(map.isEmpty()) {
                        log.write("0\n");
                    } else {
                        log.write(String.valueOf(map.lastEntry().getValue() + 1) + " ");
                    }
                    map.putAll(temporaryMap);
                } else {
                    log.write(String.valueOf(capital + 1) + " ");
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
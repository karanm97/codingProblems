/*
Solution of Codechef Problem - Permutation and Palindrome
Problem Code - PERMPAL
Link - https://www.codechef.com/problems/PERMPAL
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class PERMPAL {

    private static InputStream stream;
    private static byte[] buf = new byte[1024];
    private static int curChar;
    private static int numChars;
    private static SpaceCharFilter filter;
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int size = 27;
    private static Stack[] stack = new Stack[size];

    public static void makeStack() {
        for(int i = 1; i < size; i++) {
            stack[i] = new Stack<Integer>();
        }
    }

    public static void main(String[] args) throws IOException {
        InputReader(System.in);
        int testCases = nI();
        while(testCases-- > 0) {
            makeStack();
            String palindrome = getPalindrome(nLi());
            if(palindrome != "-1") {
                for(int i = 0; i < palindrome.length(); i++) {
                    log.write(String.valueOf((stack[getInt(palindrome.charAt(i))].pop() + " ")));
                }
            } else {
                log.write("-1");
            }
            log.write("\n");
            log.flush();
        }
    }

    public static String getPalindrome(String s) {
        if (s == null || s.equals("") ) {
            return "-1";
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            stack[getInt(charArray[i])].push(i + 1);
            if (map.containsKey(charArray[i])) {
                Integer val = map.get(charArray[i]);
                map.put(charArray[i], val + 1);
            } else {
                map.put(charArray[i], 1);
            }
        }
        int oddCount = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddCount++;
                if (oddCount > 1) {
                    return "-1";
                }
            }
        }
        int length = s.length();
        int mid = length / 2;
        char midChar = '\u0000';
        StringBuilder s1 = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            char c = entry.getKey();
            if (count % 2 != 0) {
                midChar = c;
            }
            int i = count / 2;
            while (i > 0) {
                s1.append(c);
                s1.insert(0, c);
                i--;
            }
        }
        if (midChar != '\u0000') {
            s1.insert(mid, midChar);
        }
        return s1.toString();
    }

    public static int getInt(char c) {
        return (c - 'a' + 1);
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

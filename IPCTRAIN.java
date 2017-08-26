/*
Solution of Codechef Problem - IPC Trainers
Problem Code - IPCTRAIN
Link - https://www.codechef.com/problems/IPCTRAIN
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class Trainer {
    int d, t, s;
}

class IPCTRAIN {

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
            int d = nI();
            Trainer trainer[] = new Trainer[n];
            for(int i = 0; i < n; i++) {
                trainer[i] = new Trainer();
                trainer[i].d = nI();
                trainer[i].t = nI();
                trainer[i].s = nI();
            }
            Arrays.sort(trainer, new Comparator<Trainer>() {
                public int compare(Trainer t1, Trainer t2) {
                    if(t1.d > t2.d) {
                        return 1;
                    }
                    if(t1.d < t2.d) {
                        return -1;
                    }
                    return 0;
                }
            });
            PriorityQueue<Trainer> queue = new PriorityQueue(1, new Comparator<Trainer>() {
                public int compare(Trainer t1, Trainer t2) {
                    if(t1.s > t2.s) {
                        return -1;
                    }
                    if(t1.s < t2.s) {
                        return 1;
                    }
                    return 0;
                }
            });
            int k = 0;
            for(int i = 1; i <= d; i++) {
                while(k < n && trainer[k].d == i) {
                    queue.add(trainer[k]);
                    k++;
                }
                if(queue.size() != 0) {
                    queue.peek().t--;
                    if(queue.peek().t == 0) {
                        queue.poll();
                    }
                }
            }
            long totalSadness = 0;
            while(queue.size() != 0) {
                Trainer temp = queue.poll();
                totalSadness += (long)temp.t * temp.s;
            }
            log.write(String.valueOf(totalSadness) + "\n");
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
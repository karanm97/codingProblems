import java.util.*;
import java.io.*;
import java.lang.*;

class Trainer {
    public int lectures, singleSadness;

    public Trainer(int lectures, int singleSadness) {
        this.lectures = lectures;
        this.singleSadness = singleSadness;
    }
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
        int n, d, ti, di, si, max, temp;
        long totalSadness;
        HashMap<Integer, Trainer> map;
        PriorityQueue<Integer> queue;
        while(testCases-- > 0) {
            n = nI();
            d = nI();
            totalSadness = 0;
            map = new HashMap<>();
            queue = new PriorityQueue<>((x, y) -> y - x);
            for(int i = 0; i < n; i++) {
                di = nI();
                ti = nI();
                si = nI();
                map.put(di, new Trainer(ti, si));
                totalSadness += (ti * si);
            }
            Trainer obj;
            for(int i = 1; i <= d; i++) {
                max = temp = 0;
                if(map.containsKey(i)) {
                    obj = map.get(i);
                    ti = obj.lectures;
                    si = obj.singleSadness;
                    if(ti >= 2) {
                        for(int j = 0; j < ti - 1; j++) {
                            queue.add(si);
                        }
                    }
                    if(!queue.isEmpty()) {
                        temp = queue.peek();
                    }
                    if(si >= temp) {
                        max = si;
                    } else {
                        if(!queue.isEmpty()) {
                            max = queue.poll();
                            queue.add(si);
                        }
                    }
                } else {
                    if(!queue.isEmpty()) {
                        max = queue.poll();
                    }
                }
                totalSadness -= max;
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
/*
Solution of Codechef Problem - Carvans 
Problem Code - CARVANS
Link - https://www.codechef.com/problems/CARVANS
*/

import java.io.IOException;
import java.io.InputStream;

class Carvans {

    public static void main(String[] args) throws java.lang.Exception {
        new Carvans().processData();
    }

    // Main Logic
    public void processData() throws IOException {
        int testCases, carCount;
        int[] car;
        DataReader sc = new DataReader(System.in);
        testCases = sc.nextInt();
        int j = 0;
        while (j++ < testCases) {
            carCount = sc.nextInt();
            car = new int[carCount];
            for (int i = 0; i < carCount; i++) {
                car[i] = sc.nextInt();
            }
            int min = car[0], finalCount = 0;
            for (int i = 0; i < carCount; i++) {
                if (car[i] <= min) {
                    finalCount++;
                    min = Math.min(min, car[i]);
                }
            }
            System.out.println(finalCount);
        }
    }


    // Fast Data Reader Class
    static class DataReader {
        private InputStream in = null;
        private int pos, count;
        private byte[] buf = new byte[64 * 1024];

        public DataReader(InputStream in) {
            this.in = in;
            pos = 0;
            count = 0;
        }

        public int nextInt() {
            int c, sign = 1;
            while (Character.isWhitespace(c = read())) ;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int n = c - '0';
            while ((c = read() - '0') >= 0)
                n = n * 10 + c;
            return n * sign;
        }

        public int read() {
            if (pos == count)
                fillBuffer();
            return buf[pos++];
        }

        private void fillBuffer() {
            try {
                count = in.read(buf, pos = 0, buf.length);
                if (count == -1)
                    buf[0] = -1;
            } catch (Exception ignore) {
            }
        }
    }
}


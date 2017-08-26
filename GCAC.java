/*
Solution of Codechef Problem - Greedy Candidates
Problem Code - GCAC
Link - https://www.codechef.com/problems/GCAC
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class GCAC {

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
            int m = nI();
            long[] minSalary = new long[n];
            long[] offeredSalary = new long[m];
            int[] maxJobOffers = new int[m];
            int[] jobOffer = new int[m];
            int[][] qual = new int[n][m];
            long candidateJobs = 0, totalSalary = 0, noHire = 0;
            for(int i = 0; i < n; i++) {
                minSalary[i] = nL();
            }
            for(int i = 0; i < m; i++) {
                offeredSalary[i] = nL();
                maxJobOffers[i] = nI();
            }
            for(int i = 0; i < n; i++) {
                String[] row = nLi().split("");
                for(int j = 0; j < m; j++) {
                    qual[i][j] = Integer.parseInt(row[j]);
                }
            }
            for(int i = 0; i < n; i++) {
                int indexOfCompany = -1;
                long maxSalary = 0;
                for(int j = 0; j < m; j++) {
                    if(qual[i][j] == 1 && offeredSalary[j] >= minSalary[i] && offeredSalary[j] > maxSalary && maxJobOffers[j] > jobOffer[j]) {
                        maxSalary = offeredSalary[j];
                        indexOfCompany = j;
                    }
                }
                if(indexOfCompany != -1) {
                    jobOffer[indexOfCompany]++;
                    candidateJobs++;
                    totalSalary += maxSalary;
                }
            }
            for(int i = 0; i < m; i++) {
                if(jobOffer[i] == 0) {
                    noHire++;
                }
            }
            log.write(String.valueOf(candidateJobs + " " + totalSalary + " " + noHire));
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
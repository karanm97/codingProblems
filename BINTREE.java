/*
Solution of Codechef Problem - Shortest Path in Binary Trees
Problem Code - BINTREE
Link - https://www.codechef.com/problems/BINTREE
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class BINTREE {

    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader();
        int queryCount = fs.nextInt();
        while(queryCount-- > 0) {
            int numberOne = fs.nextInt();
            int numberTwo = fs.nextInt();
            findParent(numberOne, numberTwo);
        }
        log.flush();
    }

    public static void findParent(int numberOne, int numberTwo) throws IOException {
        int counter = 0;
        while(numberOne != numberTwo) {
            if(numberOne > numberTwo) {
                numberOne = numberOne >> 1;
                counter++;
            } else {
                numberTwo = numberTwo >> 1;
                counter++;
            }
        }
        log.write(String.valueOf(counter) + "\n");
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException  e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
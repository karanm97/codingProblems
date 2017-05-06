/*
Solution of Codechef Problem - Chef and Sub Array
Problem Code - CHEFSUBA
Link - https://www.codechef.com/MAY17/problems/CHEFSUBA
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class CHEFSUBA {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        FastReader fs = new FastReader();
        int N = fs.nextInt();
        int K = fs.nextInt();
        int P = fs.nextInt();
        StringBuilder binaryArrayString = new StringBuilder();
        for(int i = 0; i < N; i++) {
            binaryArrayString.append(fs.nextInt());
        }
        int binaryArray = Integer.parseInt(binaryArrayString.toString());
        String[] dogRequest = fs.nextLine().split("");
        for(String charIterator : dogRequest) {
            if(charIterator == "?") {
            } else {
                binaryArray = returnCircular(binaryArray);
            }
        }
    }

    public static int returnCircular(int binaryArray) {
        return (binaryArray >>> 1) | (binaryArray << (Integer.SIZE - 1));
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
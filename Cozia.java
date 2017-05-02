/*
Solution of Codechef Problem - Chef Beautiful Array
Problem Code - COZIA
Link - https://www.codechef.com/problems/COZIA
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class Cozia {

    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        while(testCases-- > 0) {
            int N = fs.nextInt();
            boolean isGreater = false;
            int min = fs.nextInt() ;
            for(int i = 1; i < N; i++) {
                int temp = fs.nextInt();
                if(temp >= min) {
                    isGreater = true;
                } else {
                    min = temp;
                }
            }
            if(isGreater) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
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
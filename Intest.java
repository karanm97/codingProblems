/*
Solution of Codechef Problem - Enormous Input Test
Problem Code - INTEST
Link - https://www.codechef.com/problems/INTEST
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class Intest {

    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader();
        int N = fs.nextInt();
        int K = fs.nextInt();
        int counter = 0;
        while(N-- > 0) {
            if(fs.nextInt() % K == 0) {
                counter++;
            }
        }
        System.out.println(counter);
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
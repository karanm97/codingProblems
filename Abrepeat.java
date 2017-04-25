/*
Solution of Codechef Problem - Bear and AB
Problem Code - ABREPEAT
Link - https://www.codechef.com/problems/ABREPEAT
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class Abrepeat {

    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader();
        OutputStream log = new BufferedOutputStream(System.out);
        int testCases = fs.nextInt();
        while(testCases-- > 0) {
            int n = fs.nextInt();
            long k = fs.nextInt();
            String S = fs.nextLine();
            long countOfA = 0;
            long countOfB = 0;
            long countOfAB = 0;
            for(int i = 0; i < n; i++) {
                if(S.charAt(i) == 'a') {
                    countOfA++;
                } else if(S.charAt(i) == 'b') {
                    countOfB++;
                    countOfAB += countOfA;
                }
            }
            System.out.println(countOfAB * k + countOfA * countOfB * (k * (k - 1)) / 2);
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
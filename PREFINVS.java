/*
Solution of Codechef Problem - Prefix Inversions
Problem Code - PREFINVS
Link - https://www.codechef.com/problems/PREFINVS
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class PREFINVS {

    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader();
        String inputString = fs.nextLine();
        int index = inputString.length() - 1;
        int counter = 0, number = 0;
        for(int i = index; i >= 0; i--) {
            number = inputString.charAt(i) - '0';
            if(counter % 2 == 0) {
                if(number - 1  == 0) {
                    counter++;
                }
            } else {
                if(number - 1 == -1) {
                    counter++;
                }
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
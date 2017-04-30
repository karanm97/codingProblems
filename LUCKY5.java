/*
Solution of Codechef Problem - Lucky Long
Problem Code - LUCKY5
Link - https://www.codechef.com/problems/LUCKY5
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class LUCKY5 {

    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        while(testCases-- > 0) {
            String input = fs.nextLine();
            long counter = 0, length = input.length();
            for(int i = 0; i < length; i++) {
                char character = input.charAt(i);
                if(character != '4' && character != '7') {
                    counter++;
                }
            }
            System.out.println(counter);
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
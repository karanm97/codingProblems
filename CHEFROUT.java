/*
Solution of Codechef Problem - Chef and his daily routine
Problem Code - CHEFROUT
Link - https://www.codechef.com/problems/CHEFROUT
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class CHEFROUT {

    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        while(testCases-- > 0) {
            String inputString = fs.nextLine();
            int length = inputString.length();
            int initialValue = 0;
            boolean result = false;
            for(int i = 0; i < length; i++) {
                int ASCII_VALUE = (int) inputString.charAt(i);
                if(ASCII_VALUE >= initialValue) {
                    result = true;
                    initialValue = ASCII_VALUE;
                } else {
                    result = false;
                    break;
                }
            }
            if(result) {
                System.out.println("yes");
            } else {
                System.out.println("no");
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
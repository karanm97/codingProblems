/*
Solution of Codechef Problem - Prime Generator
Problem Code - PRIME1
Link - https://www.codechef.com/problems/PRIME1
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class PRIME1 {

    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        while(testCases-- > 0) {
            int m = fs.nextInt();
            int n = fs.nextInt();
            StringBuilder outputString = new StringBuilder();
            for(int i = m; i <= n; i++) {
                if(isPrime(i)) {
                    outputString.append(i + "\n");
                }
            }
            System.out.println(outputString);
        }
    }
    static boolean isPrime(int number) {
        if(number < 2) {
            return false;
        }
        if(number == 2) {
            return true;
        }
        if(number % 2 == 0) {
            return false;
        }
        for(int i = 3; i <= Math.sqrt(number); i += 2) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
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
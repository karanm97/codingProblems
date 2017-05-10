/*
Solution of Codechef Problem - Churu and Balls
Problem Code - CBALLS
Link - https://www.codechef.com/problems/CBALLS
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class CBALLS {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        while(testCases-- > 0) {
            int N = fs.nextInt();
            int[] array = new int[N];
            boolean[] utilArray = new boolean[N];
            for(int i = 0; i < N; i++) {
                array[i] = fs.nextInt();
            }
            for (int i = 0; i < N; i++) {
            	if(isPrime(array[i])) {
            		utilArray[i] = true;
            	}
            }
        }
    }

    public static boolean isPrime(int number) {
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
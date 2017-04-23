/*
Solution of Codechef Problem - Bear and Candies 123
Problem Code - CANDY123
Link - https://www.codechef.com/problems/CANDY123
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class Candy123 {

    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        while(testCases-- > 0) {
            int A = fs.nextInt();
            int B = fs.nextInt();
            int Limak = 0, Bob = 0;
            int counter1 = 0, counter2 = 0;
            for(int i = 1; i < 3000; i++) {
                if(i % 2 != 0) {
                    counter1 += i;
                    Limak = A - counter1;
                    if(Limak < 0) {
                        System.out.println("Bob");
                        break;
                    }
                } else {
                    counter2 += i;
                    Bob = B - counter2;
                    if(Bob < 0) {
                        System.out.println("Limak");
                        break;
                    }
                }
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
/*
Solution of Codechef Problem - Farmer Feb
Problem Code - POTATOES
Link - https://www.codechef.com/problems/POTATOES
*/

import java.io.*;
import java.util.*;

class Potatoes {

    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        int j = 0, x = 0, y = 0, sum;
        while(j++ < testCases) {
            x = fs.nextInt();
            y = fs.nextInt();
            sum = x + y + 1;
            while(!isPrime(sum)) {
                sum++;
            }
            System.out.println(sum - x - y);
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
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

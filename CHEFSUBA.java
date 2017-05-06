/*
Solution of Codechef Problem - Chef and Sub Array
Problem Code - CHEFSUBA
Link - https://www.codechef.com/MAY17/problems/CHEFSUBA
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class CHEFSUBA {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        FastReader fs = new FastReader();
        int N = fs.nextInt();
        int K = fs.nextInt();
        int P = fs.nextInt();
        StringBuilder binaryArrayString = new StringBuilder();
        for(int i = 0; i < N; i++) {
            binaryArrayString.append(fs.nextInt());
        }
        int binaryInt = Integer.parseInt(binaryArrayString.toString());
        char[] dogRequest = fs.nextLine().toCharArray();
        for(char charIterator : dogRequest) {
            // System.out.println(charIterator);
            if(charIterator == '?') {
                System.out.println(returnWindowMax(binaryInt, P, N));
            } else {
                binaryInt = returnCircular(binaryInt);
                // System.out.println("here");
            }
        }
    }

    public static int returnCircular(int binaryInt) {
        return (binaryInt >>> 1) | (binaryInt << (Integer.SIZE - 1));
    }

    public static int returnWindowMax(int binaryInt, int P, int N) {
        int[] binaryArray = new int[N];
        int max = 0;
        for(int i = N - 1; i >= 0; i--) {
            int a = binaryInt % 10;
            binaryInt = binaryInt / 10;
            binaryArray[i] = a;
        }
        System.out.println("THE array is ");
        for(int a : binaryArray) {
            System.out.println(a);
        }
        for(int i = 1; i <= binaryArray.length - P + 1; i++) {
            int a = 0;
            for(int j = i - i; j < P; j++) {
                a += binaryArray[j];
            }
            if(a > max) {
                max = a;
            }
        }
        return max;
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
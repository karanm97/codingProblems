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
        int[] binaryArray = new int[N];
        for(int i = 0; i < N; i++) {
            binaryArray[i] = fs.nextInt();
        }
        char[] dogRequest = fs.nextLine().toCharArray();
        for(char charIterator : dogRequest) {
            if(charIterator == '?') {
                System.out.println(returnWindowMax(binaryArray, P, N));
            } else {
                binaryArray = rotateArray(binaryArray, 1, N);
            }
        }
    }

    public static int[] rotateArray(int[] binaryArray, int k, int N) {
        int temp = binaryArray[N - 1], i;
        for (i = N - 2; i >= 0; i--) {
            binaryArray[i + 1] = binaryArray[i];
        }
        binaryArray[0] = temp;
        return binaryArray;
    }

    public static int returnWindowMax(int[] binaryArray, int P, int N) {
        int max = 0;
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
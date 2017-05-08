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
                System.out.println(returnWindowMax(binaryArray, K, N));
            } else {
                binaryArray = rotateArray(binaryArray, 1, N);
            }
        }
    }


    // working
    /*public static int[] rotateArray(int[] binaryArray, int K, int N) {
        int temp = binaryArray[N - 1], i;
        for (i = N - 2; i >= 0; i--) {
            binaryArray[i + 1] = binaryArray[i];
        }
        binaryArray[0] = temp;
        return binaryArray;
    }*/

    public static int[] rotateArray(int[] binaryArray, int K, int N) {
        if (binaryArray == null || K < 0) {
            throw new IllegalArgumentException("The array must be non-null and the order must be non-negative");
        }
        K = K % N;
        int newArray[] = new int[N];
        for(int i = 0 ; i < N ; i++) {
            newArray[(K + i ) % N ] = binaryArray[i];
        }
        return newArray;
    }

    public static int returnWindowMax(int binaryArray[], int K, int N) {
        int max_sum = Integer.MIN_VALUE ;
        for (int i = 0; i < N - K + 1; i++) {
            int current_sum = 0;
            for (int j = 0; j < K; j++) {
                current_sum = current_sum + binaryArray[i + j];
            }
            max_sum = Math.max(current_sum, max_sum);
        }
        return max_sum;
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
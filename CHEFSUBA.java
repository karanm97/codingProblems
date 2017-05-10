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
        int N = fs.nextInt(), K = fs.nextInt(), P = fs.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < N; i++) {
            list.add(fs.nextInt());
        }
        char[] dogRequest = fs.nextLine().toCharArray();
        for(char charIterator : dogRequest) {
            if(charIterator == '?') {
                log.write(String.valueOf(returnWindowMax(list, K, N)) + "\n");
            } else {
                int temp1 = list.get(N - 1);
                list.remove(N - 1);
                list.add(0, temp1);
            }
        }
        log.flush();
        log.close();
    }

    public static int returnWindowMax(ArrayList list, int K, int N) {
        int max_sum = Integer.MIN_VALUE ;
        for (int i = 0; i < N - K + 1; i++) {
            int current_sum = 0;
            for (int j = 0; j < K; j++) {
                int temp = (int) list.get(i + j);
                current_sum = current_sum + temp;
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
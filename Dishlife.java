/*
Solution of Codechef Problem - Dish Of Life
Problem Code - DISHLIFE
Link - https://www.codechef.com/problems/DISHLIFE
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Dishlife {

    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        while (testCases-- > 0) {
            long n = fs.nextLong();
            long k = fs.nextLong();
            boolean flag = false;
            Set<Long> set = new HashSet<>();
            for (int i = 0; i < k; i++) {
                set.add((long) (i + 1));
            }
            for (int i = 0; i < n; i++) {
                long q = fs.nextLong();
                long count = 0;
                for (int j = 0; j < q; j++) {
                    long value = fs.nextLong();
                    if (!set.remove(value)) {
                        count++;
                    }
                }
                if (count == q) {
                    flag = true;
                }
            }
            if (set.isEmpty()) {
                if (flag) {
                    System.out.println("some");
                } else {
                    System.out.println("all");
                }
            } else {
                System.out.println("sad");
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
                } catch (IOException e) {
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
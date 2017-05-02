/*
Solution of Codechef Problem - Beautiful Arrays
Problem Code - ICPC16B
Link - https://www.codechef.com/problems/ICPC16B
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class Icpc16b {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        while(testCases-- > 0) {
            int N = fs.nextInt();
            List<Long> list = new ArrayList<Long>();
            boolean doesContain = true, containsOne =  false;
            for(int i = 0; i < N; i++) {
                list.add(fs.nextLong());
            }
            Collections.sort(list);
            for(int i = 0; i < N - 1; i++) {
                for(int j = i + 1; j < N; j++) {
                    if (!(Collections.binarySearch(list, list.get(i) * list.get(j)) >= 0)) {
                        doesContain = false;
                        break;
                    }
                }
                if(doesContain) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
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
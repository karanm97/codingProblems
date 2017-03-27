/*
Solution of Codechef Problem - Worst Case Analysis
Problem Code - ICL1704
Link - https://www.codechef.com/problems/ICL1704
*/

import java.io.*;
import java.util.*;

class Icl1704 {

    BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
    FastReader fs = new FastReader();

    public static void main(String[] args) throws IOException {
        new Icl1704().process();
    }

    public void process() throws IOException {
        int testCases, j = 0, M;
        long sum = 0, result = 0;
        testCases = fs.nextInt();
        while(j++ < testCases) {
            M = fs.nextInt();
            PriorityQueue<Long> pq = new PriorityQueue<Long>();
            for (int a = 0; a < M; a++) {
                pq.add(fs.nextLong());
            }
            while(pq.size() > 1) {
                sum = pq.poll() + pq.poll();
                result += sum - 1;
                pq.add(sum);
            }
            log.write(String.valueOf(result) + "\n");
            sum = 0;
            result = 0;
        }
        log.flush();
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
    }
}
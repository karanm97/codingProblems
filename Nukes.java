/*
Solution of Codechef Problem - Nuclear Reactors
Problem Code - NUKES
Link - https://www.codechef.com/problems/NUKES
*/

import java.util.*;
import java.io.*;

class Nukes {

    int A, K, N;
    FastReader fs = new FastReader();
    BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    public void process() throws IOException {
        A = fs.nextInt();
        N = fs.nextInt();
        K = fs.nextInt();
        for(int i = 0; i < K; i++) {
            log.write((A % (N + 1)) + " ");
            A /= (N + 1);
        }
        log.flush();
    }

    public static void main(String args[]) throws IOException {
        new Nukes().process();
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

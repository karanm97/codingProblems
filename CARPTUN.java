/*
Solution of Codechef Problem - Car-pal Tunnel
Problem Code - CARPTUN
Link - https://www.codechef.com/problems/CARPTUN
*/

import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {

        public void solve(int testNumber, InputReader input, PrintWriter out) throws IOException {
            int tc = input.nextInt(), n, m;
            double ans, d, s;
            while (tc-- > 0) {
                n = input.nextInt();
                long arr[] = new long[n], max = -1;
                for (int i = 0; i < n; i++) {
                    arr[i] = input.nextInt();
                    max = Math.max(max, arr[i]);
                }
                m = input.nextInt();
                d = input.nextDouble();
                s = input.nextDouble();
                ans = (m - 1) * (max);
                out.printf("%.9f\n", ans);
            }
        }

    }

    static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
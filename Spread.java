import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Spread {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        FastReader fs = new FastReader();
        long[] N = new long[(int)fs.nextLong()];
        int M = fs.nextInt();
        int C = fs.nextInt();
        Arrays.fill(N, C);
        //        for (long i : N) {
        //            System.out.println(i);
        //        }
        for (int i = 0; i < M; i++) {
            String query[] = fs.nextLine().split(" ");
            if (query[0].equals("S")) {
                int lower = Integer.parseInt(query[1]);
                int upper = Integer.parseInt(query[2]);
                long add = Long.parseLong(query[3]);
                // System.out.println(lower + " " + upper + " " + add);
                Arrays.fill(N, lower, upper, add);
            } else {
                long P = Long.parseLong(query[1]);
                System.out.println(N[(int) P - 1]);
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
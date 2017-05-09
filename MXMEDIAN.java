import java.util.*;
import java.io.*;
import java.lang.*;

class MXMEDIAN {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        while(testCases-- > 0) {
            int N = fs.nextInt();
            Queue<Integer> queue = new PriorityQueue<Integer>((x, y) -> y - x);
            for(int i = 0; i < 2 * N; i++) {
                queue.add(fs.nextInt());
            }
            StringBuilder string = new StringBuilder();
            int[] array = new int[2 * N];
            int k = 0;
            for(int i = 1; i <= 2 * N - 1; i += 2) {
                if(i == N) {
                    string.append(queue.peek()).append("\n");
                }
                array[i] = queue.poll();
                k++;
            }
            for(int i = 0; i <= 2 * N - 2; i += 2) {
                array[i] = queue.poll();
            }
            for(int a : array) {
                string.append(a).append(" ");
            }
            System.out.println(string.toString());
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
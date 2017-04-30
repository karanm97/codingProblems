import java.util.*;
import java.io.*;
import java.lang.*;

class BEARSEG {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        while(testCases-- > 0) {
            int N = fs.nextInt();
            int P = fs.nextInt();
            int[] sequence = new int[N];
            for(int i = 0; i < N; i++) {
                sequence[i] = fs.nextInt();
            }
            int length = sequence.length, temp = 0;
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>((x, y) -> y - x);
            for (int i = 0; i < length; i++) {
                temp = 0;
                for (int j = i; j < length ; j++) {
                    temp += sequence[j];
                    queue.add(temp % P);
                }
            }
            int max = queue.poll();
            int counter = 1;
            while(queue.poll() == max) {
                counter++;
            }
            System.out.println(max + " " + counter);
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
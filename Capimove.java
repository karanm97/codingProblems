import java.util.*;
import java.io.*;
import java.lang.*;

class Capimove {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        while(testCases-- > 0) {
            int planetCount = fs.nextInt();
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>((x, y) -> y - x);
            for(int i = 1; i <= planetCount; i++) {
                int item = fs.nextInt();
                queue.add(item);
                map.put(item, i);
            }
            int[][] adjMatrix = new int[planetCount + 1][planetCount + 1];
            for(int i = 1; i <= planetCount - 1; i++) {
                int V = fs.nextInt();
                int U = fs.nextInt();
                adjMatrix[V][U] = 1;
                adjMatrix[U][V] = 1;
                adjMatrix[i][i] = 1;
            }
            adjMatrix[planetCount][planetCount] = 1;
            /*for (int i = 0; i <= planetCount; i++ ) {
                for (int j = 0; j <= planetCount; j++) {
                    System.out.print(adjMatrix[i][j] + " ");
                }
                System.out.println();
            }*/
            for(int i = 1; i <= planetCount; i++) {
                PriorityQueue<Integer> copyQueue = new PriorityQueue<Integer>(queue);
                // System.out.println(copyQueue.peek());
                int temp = map.get(copyQueue.peek());
                while(adjMatrix[i][temp] != 0) {
                    temp = map.get(copyQueue.poll());
                }
                System.out.print(temp+" ");
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
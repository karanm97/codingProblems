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
            Set<Integer> set = new HashSet<Integer>();
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int i = 1; i <= planetCount; i++) {
                int item = fs.nextInt();
                set.add(item);
                map.put(i, item);
            }
            int[][] adjMatrix = new int[planetCount + 1][planetCount + 1];
            for(int i = 1; i <= planetCount - 1; i++) {
                int V = fs.nextInt();
                int U = fs.nextInt();
                adjMatrix[V][U] = 1;
                adjMatrix[U][V] = 1;
                adjMatrix[i][i] = 1;
            }
            
            // System.out.println(Arrays.deepToString(adjMatrix));
            
            for (int i = 0; i <= planetCount; i++ ) {
                for (int j = 0; j <= planetCount; j++) {
                    System.out.print(adjMatrix[i][j]);
                }
                System.out.println();
            }

            /*for(int i = 1; i <= planetCount; i++) {
                int temp = planetCount;
                while(adjMatrix[temp][i] != 0) {
                    temp--;
                }
                System.out.println(getKeyFromValue(map, temp));
            }*/
        }
    }

    public static Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
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
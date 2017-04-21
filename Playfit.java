import java.util.*;
import java.io.*;
import java.lang.*;

class Playfit {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        while (testCases-- > 0) {
            int gamesPlayed = fs.nextInt();
            int maxGoal = 0, minGoal = 0;
            int globalMinimum = Integer.MAX_VALUE;
            int[] gameArray = new int[gamesPlayed];
            for (int i = 0; i < gamesPlayed; i++) {
                gameArray[i] = fs.nextInt();
                minGoal = gameArray[i];
                if (i != 0 && minGoal < gameArray[i]) {
                    maxGoal = gameArray[i];
                }
            }
            if(maxGoal - minGoal <= 0) {
                System.out.println("UNFIT");
            }
            else {

            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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

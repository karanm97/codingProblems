import java.util.*;
import java.io.*;
import java.lang.*;

class Playfit {

    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader();
        PrintWriter printWriter = new PrintWriter(System.out);
        int testCases = fs.nextInt();
        while (testCases-- > 0) {
            int gamesPlayed = fs.nextInt();
            int[] gameArray = new int[gamesPlayed];
            for (int i = 0; i < gamesPlayed; i++) {
                gameArray[i] = fs.nextInt();
            }
            int maxGoal = 0, minGoal = gameArray[0];
            for (int i = 1; i < gamesPlayed; i++) {
                minGoal = Math.min(minGoal, gameArray[i]);
                maxGoal = Math.max(maxGoal, gameArray[i] - minGoal);
            }
            if (maxGoal > 0) {
                printWriter.println(maxGoal);
            } else {
                printWriter.println("UNFIT");
            }
        }
        printWriter.close();
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

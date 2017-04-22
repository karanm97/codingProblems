import java.util.*;
import java.io.*;
import java.lang.*;

class Playfit {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        FastReader fs = new FastReader();
        PrintWriter printWriter = new PrintWriter(System.out);
        int testCases = fs.nextInt();
        while (testCases-- > 0) {
            int gamesPlayed = fs.nextInt();
            int[] gameArray = new int[gamesPlayed];
            int maxGoal = 0;
            for (int i = 0; i < gamesPlayed; i++) {
                gameArray[i] = fs.nextInt();
            }
            for (int i = 0; i < gamesPlayed - 1; i++) {
                for (int j = i + 1; j < gamesPlayed; j++) {
                    int goalDifference = gameArray[j] - gameArray[i];
                    if((goalDifference) > maxGoal) {
                        maxGoal = goalDifference;
                    }
                }
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

import java.util.*;
import java.io.*;
import java.lang.*;

class Marcha1 {

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        while(testCases-- > 0) {
            int noteCount = fs.nextInt();
            int muggerAmount = fs.nextInt();
            int[] coins = new int[noteCount];
            for(int i = 0; i < noteCount; i++) {
                coins[i] = fs.nextInt();
            }
            Arrays.sort(coins);
            if(makeChange(noteCount, muggerAmount, coins)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static boolean makeChange(int n, int m, int[] coins) {
        boolean[][] dp = new boolean[n + 1][m + 1];
        for(int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for(int i = 1; i < m + 1; i++) {
            dp[0][i] = false;
        }
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if(j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
        // Prints the dp matrix
        /*        for(int i = 0; i < n + 1; i++) {
                    for(int j = 0; j < m + 1; j++) {
                        System.out.print(dp[i][j] + " ");
                    }
                    System.out.println();
                }
        */
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
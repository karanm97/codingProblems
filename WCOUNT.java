import java.util.*;
import java.io.*;
import java.lang.*;

class WCOUNT {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        while(testCases-- > 0) {
            String s = fs.nextLine();
            int counter = 0;
            long length = s.length();
            Set<Character> set = new HashSet<Character>();
            for( long i = 0; i < length; i++ ) {
                char character = s.charAt((int) i);
                if(set.contains(character)) {
                    counter++;
                } else {
                    set.add(character);
                }
            }
            long factorial = length;
            long temp = length - 1;
            while(temp > 0) {
                factorial *= temp;
                temp = temp - 1;
            }
            long constant = 1000000007;
            System.out.println((factorial - counter) % constant);
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
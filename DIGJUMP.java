import java.util.*;
import java.io.*;
import java.lang.*;

class DIGJUMP {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        FastReader fs = new FastReader();
        String[] string = fs.nextLine().split("");
        int N = string.length();
        char finalChar = string.charAt(N - 1);
        char initalChar = string.charAt(0);
        if(finalChar == initalChar) {
            System.out.println("1");
        } else {
            char secondLastChar = string.charAt(N - 2);
            char position = string.charAt(0);
            int i = 0;
            while(position != finalChar) {
            	counter++;
                position = string.charAt(i + 1);
    			if(secondLastChar)
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
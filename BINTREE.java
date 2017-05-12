import java.util.*;
import java.io.*;
import java.lang.*;

class BINTREE {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        FastReader fs = new FastReader();
        int queryCount = fs.nextInt();
        while(queryCount-- > 0) {
            int numberOne = fs.nextInt();
            int numberTwo = fs.nextInt();
            System.out.println(findParent(numberOne, numberTwo));
        }
    }

    public static int findParent(int numberOne, int numberTwo) {
        int counter = 0;
        while(numberOne != numberTwo) {
            if(numberOne > numberTwo) {
                numberOne = numberOne >> 1;
                counter++;
            } else {
                numberTwo = numberTwo >> 1;
                counter++;
            }
        }
        return counter;
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
/*
Solution of Codechef Problem - Similar Dishes 
Problem Code - SIMDISH
Link - https://www.codechef.com/APRIL17/problems/SIMDISH
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Simdish {

    public static void main(String args[]) throws IOException {
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        while (testCases-- > 0) {
            String[] firstLine = fs.nextLine().split(" ");
            String[] secondLine = fs.nextLine().split(" ");
            int size = firstLine.length;
            int counter = 0;
            int decider = ((size + 2) % 2 == 0) ? (size / 2) : (size / 2 + 1);
            boolean similarity = false;
            Outer : for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (firstLine[i].equals(secondLine[j])) {
                        counter++;
                    }
                    if (counter >= decider) {
                        similarity = true;
                        break Outer;
                    }
                }
            }
            if (!similarity) {
                System.out.println("dissimilar");
            } else {
                System.out.println("similar");
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
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
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

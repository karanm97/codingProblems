import java.io.*;
import java.util.*;

class Potatoes {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        new Potatoes().process();
    }

    public void process() {
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        int j = 0, x = 0, y = 0, sum = 0, p = 1;
        while(j++ < testCases) {
            x = fs.nextInt();
            y = fs.nextInt();
            sum = x + y + p;
            for(int i = 2; i < sum / 2; i++) {
                if((sum / 2) % i == 0) {
                	System.out.println("inside for");
                    sum++;
                }
            }
            System.out.println(sum - x - y);
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

    }
}

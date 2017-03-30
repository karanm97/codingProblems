import java.io.*;
import java.util.StringTokenizer;

class Taeditor {

    public static void main(String[] args) throws IOException {
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        FastReader fs = new FastReader();
        int cases = fs.nextInt();
        StringBuilder mainString = new StringBuilder();
        while (cases-- > 0) {
            String query[] = fs.nextLine().split(" ");
            if (query[0].equals("+")) {
                mainString.insert(Integer.parseInt(query[1]), query[2]);
            } else {
                int a = Integer.parseInt(query[1]) - 1;
                int b = Integer.parseInt(query[2]) - 1;
                log.write(mainString.substring(a, a + b + 1) + "\n");
            }
        }
        log.flush();
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
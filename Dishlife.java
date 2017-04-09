import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Dishlife {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        while (testCases-- > 0) {
            StringBuilder result = new StringBuilder();
            int n = fs.nextInt();
            int k = fs.nextInt();
            int count = 0;
            for (int i = 0; i < n; i++) {

                int size = fs.nextInt();
                count += size;
//                if (size < k) {
//                    result.append("a");
//                }

//                else {
                    Set<Integer> set = new HashSet<>();
                    for (int j = 0; j < size; j++) {
                        set.add(fs.nextInt());
                    }
                    while (k-- > 0) {
                        if (!set.contains(k)) {
                            result.append("a");
                        }
                    }

//                }
            }
            System.out.println("The result is "+result);
            if (result.toString().length() == n) {
                System.out.println("sad");
            } else if (true) {
                System.out.println("some");
            } else {
                System.out.println("all");
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
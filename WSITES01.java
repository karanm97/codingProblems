import java.util.*;
import java.io.*;
import java.lang.*;

class WSITES01 {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        FastReader fs = new FastReader();
        int N = fs.nextInt();
        HashMap<Character, ArrayList<String>> map = new HashMap<Character, ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> blocked = new ArrayList<String>();
        for(int i = 0; i < N; i++) {
            String[] input = fs.nextLine().split(" ");
            if(input[0].equals("+")) {
                Character key = input[1].charAt(0);
                list.add(input[1]);
                map.put(key, list);
            } else {
                blocked.add(input[1]);
            }
        }
        for(String a : blocked) {
            System.out.println(map.get(a.charAt(0)));;
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
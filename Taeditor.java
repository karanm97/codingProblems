class Taeditor {

    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int cases = fs.nextInt();
        StringBuilder S = new StringBuilder();
        while(cases-- > 0) {
            StringBuilder query = fs.nextLine();
            if(query.charAt(0) == '+') {
       			
       			
            } else {
       
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
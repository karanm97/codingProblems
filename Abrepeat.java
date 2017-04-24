import java.util.*;
import java.io.*;
import java.lang.*;

class Abrepeat {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        while(testCases-- > 0) {
        	int n = fs.nextInt();
	        long k = fs.nextInt();
	        String S = fs.nextLine();
	        ArrayList<Integer> a1 = new ArrayList<Integer>();
	        ArrayList<Integer> b1 = new ArrayList<Integer>(); 
	       // System.out.println(a.size() + " and "+b.size());
	        for(long i = 0; i < n; i++) {
	            if(S.charAt(i) == 'a'){
	                a1.add(i);
	            }
	            if(S.charAt(i) == 'b'){
	                b1.add(i);
	            }
	        }
	        ArrayList<Long> a = new ArrayList<Long>();
	        ArrayList<Long> b = new ArrayList<Long>();
	        int nInts = a1.size();
	        int nInts1 = b1.size();
	        for (int i=0;i<nInts;++i) {
	            a.add(a1.get(i).longValue());
	        }
	        for (int i=0;i<nInts1;++i) {
	            b.add(b1.get(i).longValue());
	        }
	        long j = 0;
	        long counter = 0;
	        long asize = a.size();
	        long bsize = b.size();
	        if(k >= 2) {
	        	for (long i = 1;i<=asize;i++ ) {
	        	    j = j + n-1 ;
	        	    a.add(j);
	        	}
	        	for (long i = 1;i<=bsize;i++ ) {
	        	    j = j + n-1 ;
	        	    b.add(j);
	        	}
	        }
	        // for(long qw : a) System.out.println(qw);
	        // System.out.println(a.size() + " and "+b.size());
	        for(long qw : a) {
	            for(long qe : b) {
	                if(qw < qe) {
	                	counter++;
	                	// System.out.println("The value "+qw + "is less than "+qe);
	                }
	            }
	        }
	        System.out.println(counter);
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
/*
Solution of Codechef Problem - Bear and Segment 01
Problem Code - SEGM01
Link - https://www.codechef.com/problems/SEGM01
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class SEGM01 {

    public static void main(String[] args) throws IOException {
    	System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        while(testCases-- > 0) {
        	String[] inpustString = fs.nextLine().split("0");
        	List<String> list = new ArrayList<String>();
        	for(String s : inpustString) {
        	    if(s != null && s.length() > 0) {
        	        list.add(s);
        	    }
        	}
        	if(list.size() == 1) {
        		System.out.println("YES");
        	}else{
        		System.out.println("NO");
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
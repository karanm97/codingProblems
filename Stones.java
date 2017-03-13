/*
Solution of Codechef Problem - Jewels and Stones
Problem Code - STONES
Link - https://www.codechef.com/problems/STONES
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Stones {
 
    int testCases;
 	StringBuilder S, J;

    public void process() {
        FastReader fs = new FastReader();
        int j = 0;
        testCases = fs.nextInt();
        while(j++ < testCases) {
        	int counter = 0;
            J = new StringBuilder(fs.nextLine());
            S = new StringBuilder(fs.nextLine());
            for(int k = 0; k < S.length(); k++) {
                for(int i = 0 ; i < J.length(); i++) {
                    if(J.charAt(i) == S.charAt(k)) {
                        counter++;
                        break;
                    }
                }
            }
            System.out.println(counter);
        }
    }
    
    public static void main(String args[]) {
        new Stones().process();
    }
 
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
 
}
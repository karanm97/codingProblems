/*
Solution of Codechef Problem - Lapindromes
Problem Code - LAPIN
Link - https://www.codechef.com/problems/LAPIN
*/

import java.io.*;
import java.util.*;

class Ankpal
{
    StringBuilder inputString, string1, string2;
    int Q, I, J , K, L;

    public void process()
    {
        FastReader fs = new FastReader();
        inputString = new StringBuilder(fs.nextLine());
        Q = fs.nextInt();
        int j = 0;
        while(j++ < Q)
        {
            I = fs.nextInt();
            J = fs.nextInt();
            K = fs.nextInt();
            L = fs.nextInt();
	    	int I = 2, J = 3, K=3, L =4;
	    	StringBuilder test1 = new StringBuilder(inputString.substring(I,J+1));
	    	System.out.println(test1.reverse());
	    	inputString.replace(I,J+1,test1.toString());
		    System.out.println(inputString);
		    StringBuilder test3 = new StringBuilder(inputString.substring(K,L+1));
		    System.out.println(test3);
		    StringBuilder a = test3.reverse();
		    System.out.println(a);
		    if(test3.toString().equals(a.toString())) 
		    	System.out.println("Yes");
		    else System.out.println("No");

        }
    }

    public static void main(String[] args) throws IOException
    {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        new Ankpal().process();
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));

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
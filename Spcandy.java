/*
Solution of Codechef Problem - Splitting Candies 
Problem Code - SPCANDY
Link - https://www.codechef.com/problems/SPCANDY
*/

import java.util.*;
import java.io.*;

class Spcandy
{

    public void process()
    {
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        int j = 0;
        long candyCount, studentCount;
        while(j++ < testCases)
        {
            candyCount = fs.nextLong();
            studentCount = fs.nextLong();
            long cc = 0, sc = 0;
            if(studentCount == 0)
                sc = candyCount;
            else
            {
                cc = candyCount / studentCount;
                sc = candyCount % studentCount;
            }
            System.out.println(cc + " " + sc);
        }
    }

    public static void main(String[] args) throws IOException
    {
        new Spcandy().process();
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
    }
}

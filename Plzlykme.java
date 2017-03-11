/*
Solution of Codechef Problem - Please like me
Problem Code - PLZLYKME
Link - https://www.codechef.com/problems/PLZLYKME
*/

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Plzlykme
{
    public static void main(String arg[])
    {

        FastReader sc = new FastReader();
        int testCases = sc.nextInt();
        for (int p = 0; p < testCases; p++)
        {
            long L = sc.nextInt();
            long D = sc.nextInt();
            long S = sc.nextInt();
            long C = sc.nextInt();
            long like = S;
            for (long i = 1; i < D; i++)
            {
                like += like * C;
                if (like >= L)
                    break;
            }
            if (like >= L)
                System.out.println("ALIVE AND KICKING");
            else
                System.out.println("DEAD AND ROTTING");
        }
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


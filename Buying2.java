/*
Solution of Codechef Problem - Buying Sweets
Problem Code - BUYING2
Link - https://www.codechef.com/problems/BUYING2
*/

import java.util.*;
import java.io.*;

class Buying2
{

    int testCases, N, X, totalMoney = 0;
    int[] notes;
    public void process()
    {
        FastReader sc = new FastReader();
        int j = 0;
        testCases = sc.nextInt();

        //looping test cases
        while(j++ < testCases)
        {

            N = sc.nextInt();
            X = sc.nextInt();
            notes = new int[N];

            //looping notes
            for(int i = 0; i < N; i++)
            {
                notes[i] = sc.nextInt();
                totalMoney += notes[i];
            }

            //sorting notes
            Arrays.sort(notes);

            if(totalMoney - notes[0] >= (totalMoney / X) * X)
                System.out.println(-1);
            else
                System.out.println(totalMoney / X);
            notes = null;
            totalMoney = 0;
        }
    }

    public static void main(String args[]) throws IOException
    {
        new Buying2().process();
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
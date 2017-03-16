/*
Solution of Codechef Problem - Lapindromes
Problem Code - LAPIN
Link - https://www.codechef.com/problems/LAPIN
*/

import java.io.*;
import java.util.*;

class Lapin
{
    int testCases;
    String inputString;

    public static void main(String args[])
    {
        new Lapin().process();
    }

    public void process()
    {
        FastReader fs = new FastReader();
        int j = 0;
        testCases = fs.nextInt();
        while(j++ < testCases)
        {
            inputString = fs.nextLine();
            int stringSize = inputString.length();
            String leftHalf, rightHalf;
            if(((stringSize + 2) % 2) == 0)
            {
                leftHalf = inputString.substring(0, stringSize / 2);
                rightHalf = inputString.substring(stringSize / 2);
            }
            else
            {
                leftHalf = inputString.substring(0, stringSize / 2);
                rightHalf = inputString.substring(stringSize / 2 + 1);
            }
            char[] leftArray = leftHalf.toCharArray();
            char[] rightArray = rightHalf.toCharArray();
            Arrays.sort(leftArray);
            Arrays.sort(rightArray);
            String sortedLeft = new String(leftArray);
            String sortedRight = new String(rightArray);
            if(sortedLeft.equals(sortedRight))
                System.out.println("YES");
            else System.out.println("NO");
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
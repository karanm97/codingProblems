/*
Solution of Codechef Problem - Chef and Array Update
Problem Code - EXOCODE4
Link - https://www.codechef.com/problems/EXOCODE4
*/

import java.util.*;
import java.io.*;

class Exocode4
{
    public static void main(String[] args) throws IOException
    {
        FastReader fs = new FastReader();
        int arraySize = fs.nextInt();
        int K_element = fs.nextInt();
        int[] inputArray = new int[arraySize];
        for(int i = 0; i < arraySize; i++)
        {
            inputArray[i] = fs.nextInt();
        }
        Arrays.sort(inputArray);
        int counter = 0;
        while(inputArray[0] < K_element)
        {
            inputArray[0]++;
            counter++;
        }
        System.out.println(counter);
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
    }
}
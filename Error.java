/*
Solution of Codechef Problem - Chef and Feedback
Problem Code - ERROR
Link - https://www.codechef.com/problems/ERROR
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Error
{

    int testCases;
    String inputString;

    public void process()
    {
        FastReader fs = new FastReader();
        int j = 0;
        testCases = fs.nextInt();
        while(j++ < testCases)
        {
            inputString = fs.next();
            // System.out.println(inputString);
            int size = inputString.length();
            boolean flag = false;
            for(int i = 0; i < size - 2; i++)
            {
                if(inputString.charAt(i) == '1')
                {
                    if(inputString.charAt(i + 1) == '0')
                    {
                        if(inputString.charAt(i + 2) == '1')
                        {
                            System.out.println("Good");
                            flag = true;
                            break;
                        }
                    }
                    else continue;
                }
                else
                {
                    if(inputString.charAt(i + 1) == '1')
                    {
                        if(inputString.charAt(i + 2) == '0')
                        {
                            System.out.println("Good");
                            flag = true;
                            break;
                        }
                    }
                    else continue;
                }
            }
            if(flag == false)
            {
                System.out.println("Bad");
            }
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

    public static void main(String args[])
    {
        new Error().process();
    }
}
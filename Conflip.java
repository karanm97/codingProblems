/*
	Solution of Codechef Problem - Coin Flip
	Problem Code - CONFLIP
	Link - https://www.codechef.com/problems/CONFLIP
*/

import java.util.Scanner;

class Conflip
{
    Scanner sc = new Scanner(System.in);
    int testCases, gamesPlayed, initialState, coinCount, finalState;

    public void process()
    {
        int j = 0;
        testCases = sc.nextInt();
        while(j++ < testCases)
        {
            gamesPlayed = sc.nextInt();
            for(int i = 0; i < gamesPlayed; i++)
            {
                initialState = sc.nextInt();
                coinCount = sc.nextInt();
                finalState = sc.nextInt();
                if(((coinCount + 2) % 2) == 0)
                {
                    System.out.println(coinCount / 2);
                }
                else
                {
                    if(initialState == finalState)
                    {
                        System.out.println(coinCount / 2);
                    }
                    else
                    {
                        System.out.println((coinCount / 2) + 1);
                    }
                }
            }
        }
    }

    public static void main(String args[])
    {
        new Conflip().process();
    }
}
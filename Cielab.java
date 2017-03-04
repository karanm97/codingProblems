/*
*	Solution to Codechef Problem - Ciel and A-B Problem
*	Problem Code - CIELAB
*	Link - https://www.codechef.com/problems/CIELAB
*
*/

import java.util.Scanner;

class Cielab
{
    static int wrongAnswer(int a, int b)
    {
        int result = a - b;
        if(result % 10 != 9)
            result++;
        else result --;
        return result;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(wrongAnswer(a, b));
    }
}
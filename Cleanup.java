/*
	Solution of Codechef Problem - Cleaning Up
	Problem Code - CLEANUP
	Link - https://www.codechef.com/problems/CLEANUP
*/
	
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

class Cleanup
{
    int testCases, n, m;
    int[] incomplete_jobs;
    Set<Integer> completeSet = new HashSet<Integer>();
    Scanner sc = new Scanner(System.in);

    public void getInput()
    {
        int j = 0;
        testCases = sc.nextInt();
        while(j < testCases )
        {
            n = sc.nextInt();
            m = sc.nextInt();
            incomplete_jobs = new int[n - m];
            for(int i = 0; i < m; i++)
            {
                completeSet.add(sc.nextInt());
            }
            mainAction(n, m, completeSet);
            printResult();
            completeSet.clear();
            j++;
        }
    }

    public void mainAction(int n, int m, Set completeSet)
    {
        int j = 0;
        for(int i = 1; i <= n; i++)
        {
            if(!completeSet.contains(i))
            {
                incomplete_jobs[j] = i;
                j++;
            }
        }
    }

    public void printResult()
    {
        for(int i = 0; i < n - m; i += 2)
        {
            System.out.print(incomplete_jobs[i] + " ");
        }
        System.out.println();
        for(int i = 1; i < n - m; i += 2)
        {
            System.out.print(incomplete_jobs[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[])
    {
        Cleanup clp = new Cleanup();
        clp.getInput();
    }
}
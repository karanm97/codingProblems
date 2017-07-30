/*
Solution of Codechef Problem - Find the Maximum Value
Problem Code - LOSTMAX
Link - https://www.codechef.com/problems/LOSTMAX
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class LOSTMAX {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = input.length - 1;
            int[] arr = new int[n + 1];
            for(int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }
            Arrays.sort(arr);
            if(arr[n] == n) {
                log.write(String.valueOf(arr[n - 1]));
            } else {
                log.write(String.valueOf(arr[n]));
            }
            log.write("\n");
            log.flush();
        }
    }
}
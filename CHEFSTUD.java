/*
Solution of Codechef Problem - Chef and his Students
Problem Code - CHEFSTUD
Link - https://www.codechef.com/problems/CHEFSTUD
*/
import java.util.*;
import java.io.*;
import java.lang.*;

class CHEFSTUD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0) {
            String input = br.readLine();
            input = input.replace("*", " ");
            int sum = 0;
            for(int i = 0; i < input.length() - 1; i++) {
                if(input.charAt(i) == '<' && input.charAt(i + 1) == '>') {
                    sum++;
                }
            }
            log.write(String.valueOf(sum) + "\n");
            log.flush();
        }
    }
}
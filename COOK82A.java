/*
Solution of Codechef Problem - La Liga
Problem Code - COOK82A
Link - https://www.codechef.com/problems/COOK82A
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class COOK82A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map;
        while(testCases-- > 0) {
            map = new HashMap<>();
            for(int i = 1; i <= 4; i++) {
                String[] input = br.readLine().split(" ");
                map.put(input[0], Integer.parseInt(input[1]));
            }
            int rm = map.get("RealMadrid");
            int ma = map.get("Malaga");
            int ba = map.get("Barcelona");
            int ei = map.get("Eibar");
            if((ma > rm) && (ba > ei)) {
                log.write("Barcelona");
            } else {
                log.write("RealMadrid");
            }
            log.write("\n");
            log.flush();
        }
    }

}
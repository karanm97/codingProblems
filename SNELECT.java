/*
Solution of Codechef Problem - Snakes, Mongooses and the Ultimate Election
Problem Code - SNELECT
Link - https://www.codechef.com/problems/SNELECT
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class SNELECT {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            String string = br.readLine();
            int kills = 0, scount = 0, mcount = 0;
            for(int i = 0; i < string.length(); i++)
                if(string.charAt(i) == 's') {
                    scount++;
                } else {
                    mcount++;
                }
            for(int i = 1; i < string.length(); i++) {
                if(string.charAt(i) != string.charAt(i - 1)) {
                    kills++;
                    ++i;
                }
            }
            scount -= kills;
            if(scount > mcount) {
                log.write("snakes");
            } else if(mcount > scount) {
                log.write("mongooses");
            } else {
                log.write("tie");
            }
            log.write("\n");
            log.flush();
        }
    }
}
/*
Solution of Codechef Problem - Prefix Inversions
Problem Code - PREFINVS
Link - https://www.codechef.com/problems/PREFINVS
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class PREFINVS {

    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader();
        String[] inputArray = fs.nextLine().split("");
        int index = inputArray.length - 1;
        for(int i = index; i >= 0; i--) {
            if(inputArray[i].equals("1")) {
                index = i;
                break;
            }
        }
        int counter = 0;
        while(index != 0) {
            index = reverseArray(index, inputArray);
            counter++;
        }
        System.out.println(counter);
    }
    public static int reverseArray(int index, String[] inputArray) {
        boolean foundIndex = true;
        for(int i = index; i >= 0; i--) {
            if(inputArray[i].equals("1")) {
                inputArray[i] = "0";
                if(foundIndex) {
                    index = i;
                    foundIndex = false;
                }
            } else {
                inputArray[i] = "1";
            }
        }
        return index;
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException  e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
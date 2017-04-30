/*
Solution of Codechef Problem - Count of Maximum
Problem Code - MAXCOUNT
Link - https://www.codechef.com/problems/MAXCOUNT
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class MAXCOUNT {

    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        while(testCases-- > 0) {
            int inputSize = fs.nextInt();
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for(int i = 0; i < inputSize; i++) {
                int temp = fs.nextInt();
                if(treeMap.containsKey(temp)) {
                    int tempValue = treeMap.get(temp);
                    treeMap.put(temp, tempValue + 1);
                } else {
                    treeMap.put(temp, 1);
                }
            }
            int maxValue = Integer.MIN_VALUE, a, b;
            int maxValueKey = 0;
            Set set = treeMap.entrySet();
            Iterator i = set.iterator();
            while(i.hasNext()) {
                Map.Entry me = (Map.Entry)i.next();
                a = (int) me.getKey();
                b = (int) me.getValue();
                if(b > maxValue) {
                    maxValueKey = a;
                    maxValue = b;
                }
                if(!i.hasNext()) {
                    System.out.println(maxValueKey + " " + maxValue);
                }
            }
        }
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
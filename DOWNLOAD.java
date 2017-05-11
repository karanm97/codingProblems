/*
Solution of Codechef Problem - Alien Chefs
Problem Code - DOWNLOAD
Link - https://www.codechef.com/problems/DOWNLOAD
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class DOWNLOAD {

    static class Interval {
        public int lowerBound, upperBound;
        public Interval(int lowerBound, int upperBound) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader();
        int recipeCount = fs.nextInt();
        ArrayList<Interval> list = new ArrayList<>(recipeCount);
        for(int i = 0; i < recipeCount; i++) {
            list.add(new Interval(fs.nextInt(), fs.nextInt()));
        }
        int groupCount = fs.nextInt();
        for(int i = 0; i < groupCount; i++) {
            int alienCount = fs.nextInt();
            int[] alientTime = new int[alienCount];
            for(int j = 0; j < alienCount; j++) {
                alientTime[j] = fs.nextInt();
            }
            System.out.println(solve(recipeCount, list, alientTime));
        }
    }

    public static int solve(int recipeCount, ArrayList<Interval> list, int[] alientTime) {
        Set<Integer> set = new HashSet<>(recipeCount);
        for (int j = 0; j < alientTime.length; j++) {
            int temp = alientTime[j];
            for(int i = 0; i < recipeCount; i++) {
                int lb = list.get(i).lowerBound;
                int ub = list.get(i).upperBound;
                if(lb <= temp && temp <= ub) {
                    set.add(i);
                }
            }
        }
        return set.size();
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
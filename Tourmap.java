/*
Solution of Codechef Problem - Sridhar Likes Travelling
Problem Code - TOURMAP
Link - https://www.codechef.com/problems/TOURMAP
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Tourmap {

    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader();
        int testCases = fs.nextInt();
        while (testCases-- > 0) {
            Map<String, String> startCity = new HashMap<>();
            Map<String, String> endCity = new HashMap<>();
            Set<String> endCitySet = new HashSet<>();
            int sum = 0;
            int cityCount = fs.nextInt();
            for (int i = 0; i < cityCount - 1; i++) {
                String[] query = fs.nextLine().split(" ");
                startCity.put(query[0], query[1]);
                endCity.put(query[0], query[2]);
                endCitySet.add(query[1]);
                sum += Integer.parseInt(query[2].substring(0, query[2].length() - 1));
            }
            String start = "";
            for (String city : startCity.keySet()) {
                if (!endCitySet.contains(city)) {
                    start = city;
                    break;
                }
            }
            for (int i = 0; i < cityCount - 1; i++) {
                StringBuilder outputString = new StringBuilder();
                outputString
                .append(start + " ")
                .append(startCity.get(start) + " ")
                .append(endCity.get(start));
                System.out.println(outputString);
                start = startCity.get(start);
            }
            System.out.println(sum + "$");
        }
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
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

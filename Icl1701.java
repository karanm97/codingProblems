/*
Solution of Codechef Problem - Cards Game
Problem Code - ICL1701
Link - https://www.codechef.com/ICL2017/problems/ICL1701
*/

import java.io.*;
import java.util.*;

class Icl1701 {

    int N, K, downFaceCounter = 0, X = 0;
    int[] cardArray;
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        new Icl1701().process();
    }

    public void process() {
        FastReader fs = new FastReader();
        Icl1701 problem = new Icl1701();
        N = fs.nextInt();
        K = fs.nextInt();
        cardArray = new int[N];
        for(int i = 0; i < N; i++) {
            cardArray[i] = fs.nextInt();
            if(cardArray[i] < 0) {
                downFaceCounter++;
            }
        }
        if(downFaceCounter == 0) {
            System.out.println(0);
        } else {
            for (int i = 0; i < N; i++) {
                if(cardArray[i] < 0) {
                    cardArray[i] +=  -cardArray[i] * 2;
                    sb.append((i + 1) + " ");
                    if(i < N - 1) {
                        cardArray[i + 1] +=  -cardArray[i + 1] * 2;
                    }
                    X++;
                }
            }
            System.out.println(X);
            System.out.println(sb);
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
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
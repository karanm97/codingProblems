/*
Solution of Codechef Problem - Nuclear Reactors
Problem Code - NUKES
Link - https://www.codechef.com/problems/NUKES
*/

import java.util.*;
import java.io.*;

class Nukes {

    int A, K, N;
    int[] chamber;
    FastReader fs = new FastReader();

    public void process() {
        A = fs.nextInt();
        N = fs.nextInt();
        K = fs.nextInt();
        chamber = new int[K];
        for(int i = 0; i < A; i++) {
            chamber[0] += 1;
            // for (int a = 0; a < K ;a++) {
                int a = 0;
                while(chamber[a] > N) {
                    chamber[a] = 0;
                    try {
                        chamber[a + 1] += 1;
                        a++;
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            // }
        }
        for (int a : chamber) {
            System.out.print(a + " ");
        }
    }

    // static int[] arrayUtil(int[] chamber, int N) {
    //     while(chamber[i] > N) {
    //         chamber[i] = 0;
    //         chamber[i+1] += 1;
    //         i++;
    //     }
    //     return chamber;
    // }

    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        new Nukes().process();
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

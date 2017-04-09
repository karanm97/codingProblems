/*
Solution of Codechef Problem - Discrepancies in the Voters List
Problem Code - VOTERS
Link - https://www.codechef.com/problems/VOTERS
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Voters {

    public static void main(String[] args) throws IOException {
        Set<Integer> list1 = new HashSet<>();
        Set<Integer> list2 = new HashSet<>();
        Set<Integer> list3 = new HashSet<>();
        FastReader fs = new FastReader();
        int n1 = fs.nextInt();
        int n2 = fs.nextInt();
        int n3 = fs.nextInt();
        int totalIterations = n1 + n2 + n3;
        for (int i = 1; i <= totalIterations; i++) {
            if (i <= n1) {
                list1.add(fs.nextInt());
            } else if (i >= (n1 + n2)) {
                list3.add(fs.nextInt());
            } else {
                list2.add(fs.nextInt());
            }
        }
        Iterator iterateList1 = list1.iterator();
        while (iterateList1.hasNext()) {
            int value = (Integer) iterateList1.next();
            if (!list2.contains(value) && !list3.contains(value)) {
                iterateList1.remove();
            }
        }
        Iterator iterateList2 = list2.iterator();
        while (iterateList2.hasNext()) {
            int value = (Integer) iterateList2.next();
            if (!list1.contains(value) && !list3.contains(value)) {
                iterateList2.remove();
            }
        }
        list1.addAll(list2);
        System.out.println(list1.size());
        List<Integer> sortedList = new ArrayList<Integer>(list1);
        Collections.sort(sortedList);
        for (int data : sortedList) {
            System.out.println(data);
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
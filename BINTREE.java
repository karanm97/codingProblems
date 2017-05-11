import java.util.*;
import java.io.*;
import java.lang.*;

class BINTREE {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        FastReader fs = new FastReader();
        int queryCount = fs.nextInt();
        while(queryCount-- > 0) {
            long numberOne = fs.nextLong();
            long numberTwo = fs.nextLong();
            long levelOfNumberOne = (long) (Math.log(numberOne) / Math.log(2L));
            long levelOfNumberTwo = (long) (Math.log(numberTwo) / Math.log(2L));
            boolean isNumOneOnLeftPart = checkIfLeftHalf(numberOne);
            boolean isNumTwoOnLeftPart = checkIfLeftHalf(numberTwo);
            long difference = Math.abs(levelOfNumberTwo - levelOfNumberOne);
            if(difference > 1) {
                if(isNumOneOnLeftPart == isNumTwoOnLeftPart) {
                    System.out.println(difference);
                } else {
                    System.out.println(levelOfNumberTwo + levelOfNumberTwo);
                }
            } else if(difference == 0) {
                if(isNumTwoOnLeftPart == isNumTwoOnLeftPart) {
                    System.out.println("2");
                } else {
                    System.out.println(2 * levelOfNumberTwo);
                }
            } else if(difference == 1) {
                long max, min;
                if(numberOne > numberTwo) {
                    max = numberOne;
                    min = numberTwo;
                } else {
                    min = numberOne;
                    max = numberTwo;
                }
                if(isNumTwoOnLeftPart == isNumTwoOnLeftPart) {
                    if(max == 2 * min || max == 2 * min + 1) {
                        System.out.println("1");
                    } else {
                        System.out.println("3");
                    }
                } else {
                    System.out.println(levelOfNumberTwo + levelOfNumberTwo);
                }
            }
        }
    }

    public static boolean checkIfLeftHalf(long number) {
        long minOfLevel = (long) Math.pow(2, number);
        long maxOfLevel = minOfLevel + minOfLevel / 2 - 1;
        if(number >= minOfLevel && number <= maxOfLevel) {
            return true;
        } else {
            return false;
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
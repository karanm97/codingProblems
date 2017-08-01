import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.BigInteger;

class BOSSLOSS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0) {
            String[] input = br.readLine().split(" ");
            BigInteger n1 = new BigInteger((input[0]));
            BigInteger m1 = new BigInteger((input[1]));
            BigInteger max1 = getMax(n1);
            if(max1.compareTo(m1) == -1) {
                log.write("-1");
            } else {
                BigInteger q1 = sqrt((BigInteger.ONE).add(BigInteger.valueOf(8).multiply(m1)));
                BigInteger q2 = (q1.subtract(BigInteger.ONE)).divide(BigInteger.valueOf(2)).add(BigInteger.ONE);
                BigInteger q3 = q2;
                if(getMax(q2).compareTo(m1) < 0) {
                    while (getMax(q2).compareTo(m1) < 0) {
                        q3 = q3.add(BigInteger.ONE);
                    }
                    log.write(String.valueOf(q3));
                } else {
                    log.write(String.valueOf(q2));
                }
            }
            log.write("\n");
            log.flush();
        }
    }

    public static BigInteger getMax(BigInteger n1) {
        return n1.add(BigInteger.valueOf(1)).multiply(n1).divide(BigInteger.valueOf(2));
    }

    public static BigInteger sqrt(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = n.shiftRight(5).add(BigInteger.valueOf(8));
        while (b.compareTo(a) >= 0) {
            BigInteger mid = a.add(b).shiftRight(1);
            if (mid.multiply(mid).compareTo(n) > 0) {
                b = mid.subtract(BigInteger.ONE);
            } else {
                a = mid.add(BigInteger.ONE);
            }
        }
        return a.subtract(BigInteger.ONE);
    }
}

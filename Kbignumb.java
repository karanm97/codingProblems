import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Kbignumb {

    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("d:\\programming\\case.txt"));
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            StringBuilder A = new StringBuilder(sc.nextLine());
            StringBuilder B = new StringBuilder();
            BigInteger N = sc.nextBigInteger();
            BigInteger M = sc.nextBigInteger();
            for (
                BigInteger i = BigInteger.ZERO;
                i.compareTo(N) < 0;
                i = i.add(BigInteger.ONE)
            ) {
                B.append(A);
            }
            //            BigInteger number = new BigInteger(B.toString());
            //            BigInteger result = number.mod(M);
            //            System.out.println(result);
            System.out.println(B);
        }
    }
}

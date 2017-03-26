import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Icpc16b {

  public static void main(String args[]) {
    new Icpc16b().process();
  }

  public void process() {
    int[] input_array = {0, 1, 2, 3, 4, 5, 6, 7};
    OutermostLoop:
    for (int i = 0; i < input_array.length - 1; i++) {
      //            System.out.println("First For Loop");
      for (int j = 1; j < input_array.length; j++) {
        //                System.out.println("Second For Loop");

        for (int k = j; k < input_array.length; k++) {

          if (input_array[k] == (input_array[i] * input_array[j])) {
            System.out.println("andar hai" + i + " " + j + " " + k);

            if (i == input_array.length - 1 && j == input_array.length) System.out.println("yes");
            continue;
          }
          if (k == input_array.length) System.out.println("no");
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
  }
}

import java.util.*;
import java.io.*;
import java.lang.*;

class MAXOR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0) {
            long n = Long.parseLong(br.readLine());
            long[] input = new long[(int) n];
            String[] line = br.readLine().split(" ");
            for(int i = 0; i < n; i++) {
                input[i] = Long.parseLong(line[i]);
            }
            Arrays.sort(input);
            long counter = 0;
            for(int i = 0; i < n - 1; i++) {
                for(int j = i + 1; j < n; j++) {
                    long ai = input[i];
                    long aj = input[j];
                    if((ai | aj) <= aj) {
                        counter++;
                    }
                }
            }
            log.write(String.valueOf(counter) + "\n");
            log.flush();
        }
    }
}
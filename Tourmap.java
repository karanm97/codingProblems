import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Tourmap {

    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader(System.in);
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
    private InputStream stream;
    private byte[] buf = new byte[1024];

    private int curChar;

    private int numChars;

    public FastReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new RuntimeException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }

    public String nextLine() {
        final StringBuilder stringBuilder = new StringBuilder();
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        do {
            stringBuilder.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return stringBuilder.toString();
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long readLong() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public boolean isSpaceChar(int c) {
        return c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}

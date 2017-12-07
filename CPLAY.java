/*
Solution of Codechef Problem - Penalty Shoot-out
Problem Code - CPLAY
Link - https://www.codechef.com/problems/CPLAY
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class CPLAY {

    private static InputStream stream;
    private static byte[] buf = new byte[1024];
    private static int curChar;
    private static int numChars;
    private static SpaceCharFilter filter;
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        InputReader(System.in);
        String s = null;
        while((s = br.readLine()) != null) {
            int chefCount = 0, opponentCount = 0, chefTurns = 5, opponentTurns = 5;
            boolean isWinnerDeclared = false;
            for(int i = 0; i <= 9; i++) {
                if(i % 2 == 0) {
                    chefTurns--;
                    if(s.charAt(i) == '1') {
                        chefCount++;
                    }
                } else {
                    opponentTurns--;
                    if(s.charAt(i) == '1') {
                        opponentCount++;
                    }
                }
                if(chefCount > opponentCount + opponentTurns) {
                    log.write(String.valueOf("TEAM-A" + " " + (i + 1)));
                    isWinnerDeclared = true;
                    break;
                } else if(opponentCount > chefCount + chefTurns) {
                    log.write(String.valueOf("TEAM-B" + " " + (i + 1)));
                    isWinnerDeclared = true;
                    break;
                }
            }
            if(!isWinnerDeclared) {
                if(chefCount > opponentCount) {
                    log.write(String.valueOf("TEAM-A 10"));
                } else if (opponentCount > chefCount) {
                    log.write(String.valueOf("TEAM-B 10"));
                } else {
                    for(int i = 10; i <= 19; i++) {
                        if(i % 2 == 0) {
                            if(s.charAt(i) == '1') {
                                chefCount++;
                            }
                        } else {
                            if(s.charAt(i) == '1') {
                                opponentCount++;
                            }
                        }
                        if(i % 2 != 0) {
                            if(chefCount > opponentCount) {
                                log.write(String.valueOf("TEAM-A" + " " + (i + 1)));
                                break;
                            } else if(opponentCount > chefCount) {
                                log.write(String.valueOf("TEAM-B" + " " + (i + 1)));
                                break;
                            }
                        }
                        if(i == 19 && (chefCount == opponentCount)) {
                            log.write("TIE");
                            break;
                        }
                    }
                }
            }
            log.write("\n");
        }
        log.flush();
    }

    public static void InputReader(InputStream stream1) {
        stream = stream1;
    }

    private static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private static boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

    private static int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }

    private static int nI() {
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
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    private static long nL() {
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
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    private static String nS() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    private static String nLi() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    }

    private static boolean isSpaceChar(int c) {
        if (filter != null) {
            return filter.isSpaceChar(c);
        }
        return isWhitespace(c);
    }

    private interface SpaceCharFilter {

        public boolean isSpaceChar(int ch);
    }
}
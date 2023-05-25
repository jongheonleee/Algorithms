import java.util.*;
import java.io.*;
public class Main {

    static int eMod = 15;
    static int sMod = 28;
    static int mMod = 19;

    public static void main(String args[]) throws IOException {
        int y = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int e = Integer.parseInt(line[0]);
        int s = Integer.parseInt(line[1]);
        int m = Integer.parseInt(line[2]);

        while (true) {
            int yToE = y%eMod;
            if (yToE == 0) yToE = 15;

            int yToS = y%sMod;
            if (yToS == 0) yToS = 28;

            int yToM = y%mMod;
            if (yToM == 0) yToM = 19;

            if (yToE == e && yToS == s && yToM == m) {
                System.out.println(y);
                break;
            }
            y++;
        }

    }
}
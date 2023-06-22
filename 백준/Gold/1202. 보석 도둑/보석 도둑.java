import java.util.*;
import java.io.*;

class Jewel implements Comparable<Jewel> {
    int w;
    int v;

    Jewel(int w, int v) {
        this.w = w;
        this.v = v;
    }

    @Override
    public int compareTo(Jewel that) {
        if (this.v > that.v) {
            return -1;
        } else if (this.v == that.v) {
            return 0;
        } else {
            return 1;
        }
    }
}

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        Jewel[] jewelryBox = new Jewel[n];
        for (int i=0; i<n; i++) {
            String[] lineJewel = br.readLine().split(" ");
            jewelryBox[i] = new Jewel(Integer.parseInt(lineJewel[0]), Integer.parseInt(lineJewel[1]));
        }
        Arrays.sort(jewelryBox);
        TreeMap<Integer, Integer> d = new TreeMap<>();
        for (int i=0; i<k; i++) {
            int c = Integer.parseInt(br.readLine());
            Integer val = d.get(c);
            
            if (val == null) {
                val = 0;
            }

            val += 1;
            d.put(c, val);
        }

        

        long ans = 0;
        for (Jewel jewel : jewelryBox) {
            Map.Entry<Integer, Integer> it = d.ceilingEntry(jewel.w);

            if (it != null) {
                ans += jewel.v;
                int c = (int)it.getKey();
                Integer val = it.getValue() - 1;

                if (val == 0) {
                    d.remove(c);
                }else {
                    d.put(c, val);
                }
            }
        }
        System.out.println(ans);

    }
}
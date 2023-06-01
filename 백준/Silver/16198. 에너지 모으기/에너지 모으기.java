import java.io.*;
import java.util.*;
public class Main {


    static int go(ArrayList<Integer> a, int energy) {
        if (a.size() <= 2) {
            return energy;
        }
        int maxEnergy = 0;

        for (int i=1; i<a.size()-1; i++) {
            ArrayList<Integer> tmpA = new ArrayList<>(a);
            tmpA.remove(i);

            int tmpEnergy = go(tmpA, energy + (a.get(i-1) * a.get(i+1)));
            if (maxEnergy < tmpEnergy) {
                maxEnergy = tmpEnergy;
            }
        }

        return maxEnergy;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> a = new ArrayList<>();
        String[] line = br.readLine().split(" ");

        for (int i=0; i<n; i++) {
            a.add(Integer.parseInt(line[i]));
        }

        int maxEnergy = go(a, 0);

        System.out.println(maxEnergy);

    }
}
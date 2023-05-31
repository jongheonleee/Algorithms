import java.util.*;
import java.io.*;
public class Main {

    static int max = -1-000-000-000;
    static int min = 1-000-000-000;

    static int calculate(int[] num, int[] a) {
        int result = num[0];

        for (int i=1; i<num.length; i++) {
            int kind = a[i-1];
            if (kind == 0) {
                result += num[i];
            } else if (kind == 1) {
                result -= num[i];
            } else if (kind == 2) {
                result *= num[i];
            } else {
                result /= num[i];
            }
        }


        return result;
    }

    static boolean next_permutation(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) i--;

        if (i <= 0) return false;

        int j = a.length-1;
        while ( j > i && a[i-1] >= a[j]) j--;

        int tmp = a[i-1];
        a[i-1] = a[j]; a[j] = tmp;

        j = a.length-1;
        while (j > i) {
            tmp = a[i];
            a[i] = a[j]; a[j] = tmp;

            i++; j--;
        }

        return true;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 수열 입력받기
        int[] num = new int[n];
        String[] line1 = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            num[i] = Integer.parseInt(line1[i]);
        }


        // 1. 각 연산자의 개수 입력받기 -> 0:+, 1:-, 2:*, 3:/
        // 2. 연산자 조합을 수열로 나타내기 -> (예시) ++- : 001
        int[] a = new int[n-1];
        String[] line2 = br.readLine().split(" ");
        for (int i=0, j=0; i<4; i++) {
            int cnt = Integer.parseInt(line2[i]);
            for (int k=0; k<cnt; k++) {
                a[j] = i;
                j++;
            }
        }

        Arrays.sort(a);

        ArrayList<Integer> store = new ArrayList<>();
        do {
            int result = calculate(num, a);
            store.add(result);
        } while (next_permutation(a));

        Collections.sort(store);
        System.out.println(store.get(store.size()-1));
        System.out.println(store.get(0));

    }
}
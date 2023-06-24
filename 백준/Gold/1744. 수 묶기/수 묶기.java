import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> plus = new ArrayList<Integer>();
        ArrayList<Integer> minus = new ArrayList<Integer>();
        int zero = 0;
        int one = 0;
        for (int i=0; i<n; i++) {
            int x = sc.nextInt();
            if (x == 1) {
                one += 1;
            } else if (x > 0) {
                plus.add(x);
            } else if (x < 0) {
                minus.add(x);
            } else {
                zero += 1;
            }
        }
        Collections.sort(plus);
				Collections.reverse(plus);

        Collections.sort(minus);
       
        if (plus.size() % 2 == 1) {
            plus.add(1);
        }
        if (minus.size() % 2 == 1) {
            minus.add(zero > 0 ? 0 : 1);
        }
        int ans = one;
        for (int i=0; i<plus.size(); i+=2) {
            ans += plus.get(i) * plus.get(i+1);
        }
        for (int i=0; i<minus.size(); i+=2) {
            ans += minus.get(i) * minus.get(i+1);
        }
        System.out.println(ans);
    }
}
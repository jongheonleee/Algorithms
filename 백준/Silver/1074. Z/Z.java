import java.util.*;
public class Main {
    static int power2(int k) {
        return (1 << k);
    }
    static int go(int n, int x, int y){
        if (n==1) {
            return 2*x+y;
        } else {
            if (x < power2(n-1)) {
                if (y < power2(n-1)) {
                    return go(n-1,x,y);
                } else {
                    return go(n-1,x,y-power2(n-1))+power2(2*n-2);
                }
            } else {
                if (y < power2(n-1)) {
                    return go(n-1,x-power2(n-1),y)+power2(2*n-2)*2;
                } else {
                    return go(n-1,x-power2(n-1),y-power2(n-1))+power2(2*n-2)*3;
                }
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(go(n,x,y));
    }
}
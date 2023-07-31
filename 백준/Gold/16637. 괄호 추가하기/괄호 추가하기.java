import java.util.*;
import java.io.*;

class Term {
    int num;
    int op;

    Term(int num, int op) {
        this.num = num;
        this.op = op;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String formula = br.readLine();

        Term[] a = new Term[n];
        int ans = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            if (i % 2 == 0) {
                int num = formula.charAt(i) - '0';
                a[i] = new Term(num, 0);
            } else {
                int op = 1;
                if (formula.charAt(i) == '-') {
                    op = 2;
                } else if (formula.charAt(i) == '*') {
                    op = 3;
                }

                a[i] = new Term(0, op);
            }
        }

        int m = (n-1)/2;
        for (int i=0; i<(1<<m); i++) {
            boolean ok = true;
            for (int j=0; j<m-1; j++) {
                if ((i&(1<<j)) > 0 && (i&(1<<(j+1))) > 0) {
                    ok = false;
                }
            }

            if (!ok) continue;

            int res = 0;
            Term[] b = new Term[n];
            for (int j=0; j<n; j++) {
                b[j] = new Term(a[j].num, a[j].op);
            }

            for (int j=0; j<m; j++) {
                if ((i&(1<<j)) > 0) {
                    int k = 2*j+1;

                    if (b[k].op == 1) {
                        b[k-1].num += b[k+1].num;
                        b[k+1].num = 0;
                    } else if (b[k].op == 2) {
                        b[k-1].num -= b[k+1].num;
                        b[k+1].num = 0;
                        b[k].op = 1;
                    } else {
                        b[k-1].num *= b[k+1].num;
                        b[k+1].num = 0;
                        b[k].op = 1;
                    }
                }
            }

            res = b[0].num;
            for (int j=0; j<m; j++) {
                int k = 2*j+1;

                if (b[k].op == 1) {
                    res += b[k+1].num;
                } else if (b[k].op == 2) {
                    res -= b[k+1].num;
                } else {
                    res *= b[k+1].num;
                }
            }

            if (ans < res) ans = res;
        }

        System.out.println(ans);

    }
}
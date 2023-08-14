import java.util.*;
import java.io.*;

class Term {
    int number, op;

    Term(int number, int op) {
        this.number = number;
        this.op = op;
    }
}


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Term[] a = new Term[n];
        String line = br.readLine();
        for (int i=0; i<n; i++) {
            char ch = line.charAt(i);
            if (i%2 == 0) {
                a[i] = new Term(ch-'0', 0);
            } else {
                if (ch == '+') {
                    a[i] = new Term(0, 1);
                } else if (ch == '-') {
                    a[i] = new Term(0, 2);
                } else {
                    a[i] = new Term(0, 3);
                }
            }
        }

        int m = (n-1)/2, ans = Integer.MIN_VALUE;
        for (int i=0; i<(1<<m); i++) {
            boolean ok = true;

            for (int j=0; j<m-1; j++) {
                if ((i&(1<<j)) > 0 && (i&(1<<(j+1))) > 0) {
                    ok = false;
                }
            }

            if (ok == false) continue;
            Term[] b = new Term[n];
            for (int j=0; j<n; j++) {
                b[j] = new Term(a[j].number, a[j].op);
            }

            for (int j=0; j<m; j++) {
                if ((i&(1<<j)) != 0) {
                    int k = 2*j+1;
                    // +
                    if (b[k].op == 1) {
                        b[k-1].number += b[k+1].number;
                        b[k+1].number = 0;
                        b[k].op = -1;
                        // -
                    } else if (b[k].op == 2) {
                        b[k-1].number -= b[k+1].number;
                        b[k+1].number = 0;
                        b[k].op = -1;
                        // *
                    } else if (b[k].op == 3){
                        b[k-1].number *= b[k+1].number;
                        b[k+1].number = 0;
                        b[k].op = -1;
                    }
                }
            }

            ArrayList<Term> c = new ArrayList<>();
            for (int j=0; j<n; j++) {
                if (j%2 == 0) {
                    c.add(b[j]);
                } else {
                    if (b[j].op == -1) {
                        j++;
                    } else {
                        if (b[j].op == 3) {
                            int number = c.get(c.size()-1).number * b[j+1].number;
                            c.remove(c.size()-1);
                            c.add(new Term(number, 0));
                            j++;
                        } else {
                            c.add(b[j]);
                        }
                    }
                }
            }

            b = c.toArray(new Term[c.size()]);
            int m2 = (b.length-1)/2;
            int res = b[0].number;

            for (int j=0; j<m2; j++) {
                int k = 2*j+1;

                if (b[k].op == 1) {
                    res += b[k+1].number;
                } else if (b[k].op == 2) {
                    res -= b[k+1].number;
                } else if (b[k].op == 3) {
                    res *= b[k+1].number;
                }
            }

            if (ans < res) ans = res;
        }

        System.out.println(ans);

    }
}
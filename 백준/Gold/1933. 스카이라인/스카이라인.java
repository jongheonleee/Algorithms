import java.util.*;
import java.io.*;
class Building implements Comparable<Building> {
    int start, end, height;

    Building(int start, int end, int height) {
        this.start = start;
        this.end = end;
        this.height = height;
    }

    @Override
    public int compareTo(Building that) {
        if (this.start < that.start) {
            return -1;
        } else if (this.start == that.start) {
            if (this.height < that.height) {
                return -1;
            } else if (this.height == that.height) {
                if (this.end < that.end) {
                    return 1;
                } else if (this.end == that.end) {
                    return 0;
                }
                else {
                    return -1;
                }
            }
            else {
                return 1;
            }
        }
        else {
            return 1;
        }
    }
}
class Pair {
    int x, height;

    Pair(int x, int height) {
        this.x = x;
        this.height = height;
    }
}

class Result {
    ArrayList<Pair> ans;
    Result() {
        this.ans = new ArrayList<>();
    }

    Pair get(int index) {
        return ans.get(index);
    }

    int size() {
        return ans.size();
    }

    void append(Pair p) {
        int n = size();

        if (n > 0) {
            Pair last = ans.get(n-1);

            if (last.height == p.height) return;

            if (last.x == p.x) {
                last.height = p.height;
                ans.remove(n-1);
                ans.add(last);
                return;
            }
        }

        ans.add(p);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pair p : ans) {
            sb.append(p.x).append(" ").append(p.height).append(" ");
        }

        return sb.toString();
    }
}
public class Main {

    static Result merge(Result left, Result right) {
        Result ans = new Result();
        int i = 0, j = 0, h1 = 0, h2 = 0;

        while (i < left.size() && j < right.size()) {
            Pair u = left.get(i);
            Pair v = right.get(j);

            if (u.x < v.x) {
                int x = u.x;
                h1 = u.height;
                int h = Math.max(h1, h2);
                ans.append(new Pair(x, h));
                i++;
            }
            else {
                int x = v.x;
                h2 = v.height;
                int h = Math.max(h1, h2);
                ans.append(new Pair(x, h));
                j++;
            }
        }

        while (i < left.size()) {
            ans.append(left.get(i));
            i++;
        }

        while (j < right.size()) {
            ans.append(right.get(j));
            j++;
        }

        return ans;
    }

    static Result go(Building[] a, int start, int end) {
        if (start == end) {
            Result ans = new Result();
            ans.append(new Pair(a[start].start, a[start].height));
            ans.append(new Pair(a[start].end, 0));

            return ans;
        }

        int mid = (start+end)/2;
        Result left = go(a, start, mid);
        Result right = go(a, mid+1, end);

        return merge(left, right);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Building[] a = new Building[n];

        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int height = Integer.parseInt(line[1]);
            int end = Integer.parseInt(line[2]);
            a[i] = new Building(start, end, height);
        }

        Arrays.sort(a);
        Result ans = go(a, 0, n-1);
        System.out.println(ans.toString());
    }
}
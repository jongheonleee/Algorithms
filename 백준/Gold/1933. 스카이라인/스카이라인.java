import java.util.*;
import java.io.*;
class Building implements Comparable<Building> {
    int left, height, right;
    Building(int left, int height, int right) {
        this.left = left;
        this.height = height;
        this.right = right;
    }
    public int compareTo(Building that) {
        if (this.left < that.left) {
            return -1;
        } else if (this.left == that.left) {
            if (this.height < that.height) {
                return -1;
            } else if (this.height == that.height) {
                if (this.right < that.right) {
                    return 1;
                } else if (this.right == that.right) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                return 1;
            }
        } else {
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
        int n = ans.size();
        if (n > 0) {
            Pair last = ans.get(n-1);
            if (last.height == p.height) {
                return;
            }
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
            sb.append(p.x + " " + p.height + " ");
        }
        return sb.toString();
    }
}
public class Main {
    static Result merge(Result l, Result r) {
        Result ans = new Result();
        int h1 = 0;
        int h2 = 0;
        int i = 0;
        int j = 0;
        while (i < l.size() && j < r.size()) {
            Pair u = l.get(i);
            Pair v = r.get(j);
            if (u.x < v.x) {
                int x = u.x;
                h1 = u.height;
                int h = Math.max(h1, h2);
                ans.append(new Pair(x, h));
                i += 1;
            } else {
                int x = v.x;
                h2 = v.height;
                int h = Math.max(h1, h2);
                ans.append(new Pair(x, h));
                j += 1;
            }
        }
        while (i < l.size()) {
            ans.append(l.get(i));
            i += 1;
        }
        while (j < r.size()) {
            ans.append(r.get(j));
            j += 1;
        }
        return ans;
    }
    static Result go(Building[] a, int start, int end) {
        if (start == end) {
            Result ans = new Result();
            ans.append(new Pair(a[start].left, a[start].height));
            ans.append(new Pair(a[start].right, 0));
            return ans;
        }
        int mid = (start + end) / 2;
        Result l = go(a, start, mid);
        Result r = go(a, mid+1, end);
        return merge(l, r);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Building[] a = new Building[n];
        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            int l = Integer.parseInt(line[0]);
            int h = Integer.parseInt(line[1]);
            int r = Integer.parseInt(line[2]);
            a[i] = new Building(l, h, r);
        }
        Arrays.sort(a);
        Result ans = go(a, 0, n-1);
        System.out.println(ans.toString());
    }
}

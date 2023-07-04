import java.util.*;
import java.io.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class PointComparatorX implements Comparator<Point> {
    public int compare(Point u, Point v) {
        if (u.x < v.x) {
            return -1;
        } else if (u.x == v.x) {
            if (u.y < v.y) {
                return -1;
            } else if (u.y == v.y) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
class PointComparatorY implements Comparator<Point> {
    public int compare(Point u, Point v) {
        if (u.y < v.y) {
            return -1;
        } else if (u.y == v.y) {
            if (u.x < v.x) {
                return -1;
            } else if (u.x == v.x) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
public class Main {
    static int dist(Point p1, Point p2) {
        return (p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y);
    }
    static int brute_force(Point[] a, int start, int end) {
        int ans = -1;
        for (int i=start; i<=end-1; i++) {
            for (int j=i+1; j<=end; j++) {
                int d = dist(a[i], a[j]);
                if (ans == -1 || ans > d) {
                    ans = d;
                }
            }
        }
        return ans;
    }
    static int closest(Point[] ax, ArrayList<Point> ay, int start, int end) {
        int n = end-start+1;
        if (n <= 3) {
            return brute_force(ax, start, end);
        }
        int mid = (start + end) / 2;
        Point mid_p = ax[mid];
        ArrayList<Point> ayl = new ArrayList<>();
        ArrayList<Point> ayr = new ArrayList<>();
        PointComparatorX cmp = new PointComparatorX();
        for (Point p : ay) {
            if (cmp.compare(p, mid_p) != 1) {
                ayl.add(p);
            } else {
                ayr.add(p);
            }
        }
        int left = closest(ax, ayl, start, mid);
        int right = closest(ax, ayr, mid+1, end);
        int ans = Math.min(left, right);
        ArrayList<Point> b = new ArrayList<>();
        for (Point p : ay) {
            int d = p.x - mid_p.x;
            if (d*d < ans) {
                b.add(p);
            }
        }
        int m = b.size();
        for (int i=0; i<m-1; i++) {
            for (int j=i+1; j<m; j++) {
                int dy = b.get(j).y - b.get(i).y;
                if (dy*dy < ans) {
                    int d = dist(b.get(i), b.get(j));
                    if (d < ans) {
                        ans = d;
                    }
                } else {
                    break;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Point[] a = new Point[n];
        for (int i=0; i<n; i++) {
            String[] line = bf.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            a[i] = new Point(x, y);
        }
        ArrayList<Point> ay = new ArrayList<>(Arrays.asList(a));
        Arrays.sort(a, new PointComparatorX());
        Collections.sort(ay, new PointComparatorY());
        System.out.println(closest(a, ay, 0, n-1));
    }
}

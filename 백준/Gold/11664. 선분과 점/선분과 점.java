import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.*;

class Point {
    double x, y, z;

    Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}




public class Main {

    static double power2(double k) {
        return k * k;
    }
    static double dist(Point p1, Point p2) {
        return Math.sqrt(power2(p2.x - p1.x) + power2(p2.y - p1.y) + power2(p2.z - p1.z));
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        Point p1 = new Point(Double.parseDouble(line[0]), Double.parseDouble(line[1]), Double.parseDouble(line[2]));
        Point p2 = new Point(Double.parseDouble(line[3]), Double.parseDouble(line[4]), Double.parseDouble(line[5]));
        Point p3 = new Point(Double.parseDouble(line[6]), Double.parseDouble(line[7]), Double.parseDouble(line[8]));

        double dx = p2.x - p1.x, dy = p2.y - p1.y, dz = p2.z - p1.z;
        double left = 0.0, right = 1.0, m = 0;

        while (true) {
            if (Math.abs(right - left) < 1e-9) {
                m = (left+right)/2;
                break;
            }

            double m1 = left + (right-left)/3, m2 = right - (right-left)/3;
            Point m1p = new Point(p1.x + m1*dx, p1.y + m1*dy, p1.z + m1*dz);
            Point m2p = new Point(p1.x + m2*dx, p1.y + m2*dy, p1.z + m2*dz);
            double d1 = dist(m1p, p3);
            double d2 = dist(m2p, p3);

            if (d1 > d2) {
                left = m1;
            } else {
                right = m2;
            }
        }

        Point p0 = new Point(p1.x+m*dx, p1.y+m*dy, p1.z+m*dz);
        double ans = dist(p0, p3);
        System.out.printf("%.10f\n", ans);


    }
}
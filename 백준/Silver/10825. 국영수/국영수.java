import java.util.*;
import java.io.*;

class Student implements Comparable<Student> {
    String name;
    int kor;
    int eng;
    int mat;

    Student(String name, int kor, int eng, int mat) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    @Override
    public int compareTo(Student that) {
        if (this.kor < that.kor) {
            return 1;
        } else if (this.kor == that.kor) {
            if (this.eng < that.eng) {
                return -1;
            } else if (this.eng == that.eng) {
                if (this.mat < that.mat) {
                    return 1;
                } else if (this.mat == that.mat) {
                    return this.name.compareTo(that.name);
                } else {
                    return -1;
                }
            } else {
                return 1;
            }
        } else {
            return -1;
        }
    }
}


public class Main {



    static void show(Student[] a) {
        StringBuilder sb = new StringBuilder();
        for (Student s : a) {
            sb.append(s.name).append("\n");
        }
        System.out.println(sb);
    }

    static void shuffle(Student[] a) {
        Random random = new Random();
        
        for (int i=a.length-1; i>=0; i--) {
            int idx = random.nextInt(i+1);
            Student tmp = a[idx];
            a[idx] = a[i]; a[i] = tmp;
        }
    }



    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Student[] a = new Student[n];
        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            String name = line[0];
            int kor = Integer.parseInt(line[1]);
            int eng = Integer.parseInt(line[2]);
            int mat = Integer.parseInt(line[3]);

            a[i] = new Student(name, kor, eng, mat);
        }

        shuffle(a);
        Arrays.sort(a);
        show(a);
    }
}
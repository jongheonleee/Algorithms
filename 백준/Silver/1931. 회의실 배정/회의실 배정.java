import java.util.*;
import java.io.*;

class Meeting implements Comparable<Meeting> {
    int start, end;

    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting that) {
        if (this.end < that.end) {
            return -1;
        } else if (this.end == that.end) {
            if (this.start < that.start) {
                return -1;
            } else if (this.start == that.start) {
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


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        Meeting[] meetingsList = new Meeting[n];
        for (int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            meetingsList[i] = new Meeting(start, end);
        }

        Arrays.sort(meetingsList);

        int maxCount = 0;
        int takenTime = 0;
        for (Meeting meeting : meetingsList) {
            if (takenTime <= meeting.start) {
                maxCount++;
                takenTime = meeting.end;
            }
        }

        System.out.println(maxCount);

    }
}
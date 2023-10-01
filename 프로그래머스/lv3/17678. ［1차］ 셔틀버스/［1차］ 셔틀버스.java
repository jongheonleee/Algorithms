import java.util.*;

class Solution {
  public String solution(int n, int t, int m, String[] timetable) {
        List<Integer> timetableToInt = new ArrayList<>(timetable.length); 
        for (int i = 0; i < timetable.length; i++) {
            int hours = parseInt(timetable[i].substring(0, 2));
            int minutes = parseInt(timetable[i].substring(3, 5));
            timetableToInt.add(hours * 60 + minutes);
        }

        int first = 540;
        int last = first + (n - 1) * t;
        int conPassTime = 0;

        Collections.sort(timetableToInt);
        Queue<Integer> crewQueue = new LinkedList<>(timetableToInt); 
        for (int i = 0; i < n; i++) {
            int validTime = first + i * t;
            int onBoardCnt = 0;
            int lastBoardTime = 0;
            for (int j = 0; j < m; j++) {
                if (crewQueue.isEmpty()) {
                    break;
                }
                int targetCrewTime = ((LinkedList<Integer>) crewQueue).peekFirst();
                if (targetCrewTime <= validTime) {
                    lastBoardTime = ((LinkedList<Integer>) crewQueue).removeFirst();
                    onBoardCnt++;
                }
            }

            if (i == n - 1) {
                if (onBoardCnt == m) {
                    conPassTime = lastBoardTime - 1;
                }
                if (onBoardCnt < m) {
                    conPassTime = last;
                }
            }
        }

        String answer = parseTime(conPassTime);
        return answer;
    }

    private static String parseTime(int conPassTime) {
        int hours = conPassTime / 60;
        int minutes = conPassTime % 60;
        return String.format("%02d:%02d", hours, minutes);
    }

    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }
}
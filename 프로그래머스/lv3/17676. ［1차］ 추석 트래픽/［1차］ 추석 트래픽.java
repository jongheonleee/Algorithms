import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;

class Log {
        private long start;
        private long end;
        private long duration;

        Log(String logLine) {
            String[] splitLogLine = logLine.split(" ");
            String dateString = splitLogLine[0] + " " + splitLogLine[1];

            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateString);
                this.end = date.getTime();

                String[] durationString = splitLogLine[2].split("s");
                double second = Double.parseDouble(durationString[0]);
                this.duration = (long) (second * 1000);

                this.start = this.end - this.duration;
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        public boolean isIn(long start, long end) {
            if (this.end < start || this.start >= end) {
                return false;
            } else {
                return true;
            }
        }

        public long getStart() {
            return start;
        }
        
        public long getEnd() {
            return end;
        }
        
        public long getDuration() {
            return duration;
        }
}

class Solution {
    public int solution(String[] lines) {
        List<Long> checkPointList = new ArrayList<>();
        List<Log> logList = new ArrayList<>();

        // 1. String -> Log
        for (String logLine : lines) {
            Log log = new Log(logLine);
            checkPointList.add(log.getStart());
            checkPointList.add(log.getEnd());
            logList.add(log);
        }
        // 2. sort
        Collections.sort(checkPointList);

        // 3. execute
        int answer = 0;
        for (Long point : checkPointList) {
            int count = 0;
            for (Log log : logList) {
                if (log.isIn(point, point+999)) {
                    count+=1;
                }
            }

            if (count > answer) {
                answer = count;
            }
        }


        return answer;

    }
}
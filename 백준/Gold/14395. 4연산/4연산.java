import java.util.*;
import java.io.*;

public class Main {

    static final long MIN = 1;
    static final long MAX = 1000000000L;

    static final int IMPOSSIBLE = -1;

    static boolean isValid(Long number) {
        return (MIN <= number && number <= MAX);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long start = Long.parseLong(st.nextToken()), target = Long.parseLong(st.nextToken());

        if (start == target) {
            System.out.println(0);
            System.exit(0);
        }

        Queue<Long> resultsQueue = new LinkedList<>();
        Queue<String> usedOperatorsQueue = new LinkedList<>();
        HashSet<Long> check = new HashSet<>();

        resultsQueue.add(start);
        usedOperatorsQueue.add("");
        check.add(start);

        while (!(resultsQueue.isEmpty())) {
            long result = resultsQueue.remove();
            String usedOperators = usedOperatorsQueue.remove();

            if (result == target) {
                System.out.println(usedOperators);
                System.exit(0);
            }

            // *
            if (isValid(result * result) && check.contains(result * result) == false) {
                resultsQueue.add(result * result);
                usedOperatorsQueue.add(usedOperators + "*");
                check.add(result * result);
            }

            if (isValid(result + result) && check.contains(result + result) == false) {
                resultsQueue.add(result + result);
                usedOperatorsQueue.add(usedOperators + "+");
                check.add(result + result);
            }

            if (isValid(result - result) && check.contains(result - result) == false) {
                resultsQueue.add(result - result);
                usedOperatorsQueue.add(usedOperators + "-");
                check.add(result - result);
            }

            if (isValid(result / result) && check.contains(result / result) == false) {
                resultsQueue.add(result / result);
                usedOperatorsQueue.add(usedOperators + "/");
                check.add(result / result);
            }

        }
        System.out.println(IMPOSSIBLE);

    }
}
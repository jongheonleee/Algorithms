import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] givenState = new String[3];
        for (int i=0; i<3; i++) {
            int count = sc.nextInt();
            if (count > 0) {
                givenState[i] = sc.next();
            } else {
                givenState[i] = "";
            }
        }

        int[] countDiameter = {0, 0, 0};
        for (String eachBar : givenState) {
            for (char diameter : eachBar.toCharArray()) {
                countDiameter[diameter-'A'] += 1;
            }
        }

        Queue<List<String>> q = new LinkedList<>();
        HashMap<List<String>, Integer> dist = new HashMap<>();

        dist.put(Collections.unmodifiableList(Arrays.asList(givenState)), 0);
        q.add(Arrays.asList(givenState));

        while (!q.isEmpty()) {
            String[] currentState = q.remove().toArray(new String[3]);

            for (int from=0; from<3; from++) {
                for (int to=0; to<3; to++) {
                    if (from == to) continue;
                    if (currentState[from].length() == 0) continue;
                    String[] nextState = {currentState[0], currentState[1], currentState[2]};

                    nextState[to] += nextState[from].charAt(nextState[from].length()-1);
                    nextState[from] = nextState[from].substring(0, nextState[from].length()-1);

                    List<String> key = Collections.unmodifiableList(Arrays.asList(nextState));
                    if (dist.containsKey(key) == false) {
                        dist.put(key, dist.get(Arrays.asList(currentState))+1);
                        q.add(Arrays.asList(nextState));
                    }
                }
            }
        }

        String[] completeState = new String[3];
        for (int i=0; i<3; i++) {
            completeState[i] = "";
            int count = countDiameter[i];
            for (int j=0; j<count; j++) {
                completeState[i] += (char)('A'+i);
            }
        }

        System.out.println(dist.get(Arrays.asList(completeState)));

    }
}
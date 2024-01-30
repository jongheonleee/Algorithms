import java.util.*;
import java.io.*;
import java.util.Map.Entry;


public class Main {

    private static String s;
    private static List<String> ans;
    private static char[] arr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0. 세팅
        s = br.readLine();
        ans = new ArrayList<>();

        arr = new char[s.length()];
        for (int i=0; i<s.length(); i++) {
            arr[i] = s.charAt(i);
        }

        // 1. 두개 인덱스 선택
        // 1-0. 세가지 작업 적용
        // 1-1. 기록된 것과 비교
        // 1-2. 사전순 낮은거 기록
        for (int i=1; i<s.length(); i++) {
            for (int j=i+1; j<s.length(); j++) {
                String tmp = "";

                for (int x=i-1; x>=0; x--) {
                    tmp += arr[x];
                }

                for (int x=j-1; x>=i; x--) {
                    tmp += arr[x];
                }

                for (int x=arr.length-1; x>=j; x--) {
                    tmp += arr[x];
                }

                ans.add(tmp);
            }
        }


        // 2. 출력
        Collections.sort(ans);
        System.out.println(ans.get(0));
    }
}


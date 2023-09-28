import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
            String[] map = new String[n];

            for (int i=0; i<n; i++) {
                char[] rowCharArr = new char[n];

                for (int k=0; k<n; k++) {
                    int mask = 1<<k;

                    if ((mask & arr1[i]) != 0 || (mask & arr2[i]) != 0) {
                        rowCharArr[k] = '#';
                    } else {
                        rowCharArr[k] = ' ';
                    }
                }

                String rowStr = "";
                for (int k=n-1; k>=0; k--) {
                    rowStr += rowCharArr[k];
                }

                map[i] = rowStr;
            }

            return map;
    }
}
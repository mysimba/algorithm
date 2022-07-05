package hashAndTreeMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Algo54 {
    public static int solution(String str1, String str2) {
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> compareMap = new HashMap<>();
        int lt = 0;
        char[] strArr2 = str2.toCharArray();
        char[] strArr1 = str1.toCharArray();

        for (int i = 0; i < str2.length(); i++) {
            map.put(strArr2[i], map.getOrDefault(strArr2[i], 0) + 1);
            compareMap.put(strArr1[i], compareMap.getOrDefault(strArr1[i], 0) + 1);
        }

        boolean flag = true;
        for (char c : compareMap.keySet()) {
            if (map.containsKey(c)) {
                if (map.get(c) != compareMap.get(c)) {
                    flag = false;
                }
            } else {
                flag = false;
            }
        }

        if (flag) result++;

        for (int rt = str2.length(); rt < strArr1.length; rt++) {
            flag = true;
            compareMap.put(strArr1[lt], compareMap.get(strArr1[lt]) - 1);
            if (compareMap.get(strArr1[lt]) == 0) {
                compareMap.remove(strArr1[lt]);
            }
            compareMap.put(strArr1[rt], compareMap.getOrDefault(strArr1[rt], 0) + 1);
            lt++;
            for (char c : compareMap.keySet()) {
                if (map.containsKey(c)) {
                    if (map.get(c) != compareMap.get(c)) {
                        flag = false;
                    }
                } else {
                    flag = false;
                }
            }
            if (flag) result++;
        }


        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.print(solution(str1, str2));
    }
}

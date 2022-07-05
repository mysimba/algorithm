package hashAndTreeMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algo53 {
    public static ArrayList<Integer> solution(int n, int m, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int lt = 0;

        for (int i = 0; i < m; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        result.add(map.size());

        for (int rt = m; rt < n; rt++) {
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) <= 0) {
                map.remove(arr[lt]);
            }
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            lt++;
            result.add(map.size());
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : solution(n, k, arr)) {
            System.out.print(i + " ");
        }
    }
}

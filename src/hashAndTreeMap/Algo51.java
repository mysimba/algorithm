package hashAndTreeMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Algo51 {
    public static char solution(int n, char[] arr) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int result = 0;
        char resultC = arr[0];

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        }
        for (char a : map.keySet()) {
            if (result < map.get(a)) {
                result = map.get(a);
                resultC = a;
            }
        }

        return resultC;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        char[] arr = str.toCharArray();
        System.out.print(solution(n, arr));
    }
}

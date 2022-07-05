package hashAndTreeMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Algo55 {

    public static int solution(int n, int k, int[] arr) {
        int result = -1;
        int cnt = 1;
        TreeSet<Integer> tree = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n - 2; i++) {
            for (int j  = i + 1; j < n - 1; j++) {
                for (int l = j + 1; l < n; l++) {
                    tree.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        for (int a : tree) {
            if (k == cnt++) result = a;
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
        System.out.print(solution(n, k, arr));
    }
}

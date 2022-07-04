package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo42 {
    public static int solution(int n, int k, int[] arr) {
        int result = 0;
        int startNum = 0;

        for (int i = 0; i < k; i++) {
            startNum += arr[i];
        }

        result = startNum;

        for (int i = k; i < n; i++) {
            startNum += (arr[i] - arr[i - k]);
            result = Math.max(startNum, result);
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

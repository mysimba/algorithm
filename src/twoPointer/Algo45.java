package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo45 {
    public static int solution(int n, int k, int[] arr) {
        int result = 0;
        int zeroCnt = 0;
        int lt = 0, gt = k -1;

        for (int i = 0; i < k; i++) {
            if (arr[i] == 0) zeroCnt++;
        }

        while (gt < n - 1) {
            if (zeroCnt < k) {
                gt++;
                if (arr[gt] != 1) {
                    zeroCnt++;
                }
            } else if (zeroCnt == k) {
                if(arr[gt + 1] == 1) {
                    gt++;
                } else {
                    if (arr[lt] == 0) {
                        zeroCnt--;
                    }
                    lt++;
                }
            }
            result = Math.max(result, gt - lt + 1);
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

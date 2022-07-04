package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo43 {
    public static int solution(int n, int k, int[] arr) {
        int result = 0;
        int lt = 0, gt = 0;
        int num = arr[lt];

        while (gt < n) {
            if (num < k) {
                gt++;
                if (gt < n) {
                    num += arr[gt];
                } else {
                    break;
                }
            } else if (num > k) {
                num -= arr[lt];
                lt++;
            } else if (num == k){
                result++;
                num -= arr[lt];
                lt++;
            }
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

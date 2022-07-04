package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo44 {
    public static int solution(int n) {
        int result = 0;
        int[] arr = new int[n -1];

        for (int i = 0; i < n - 1; i++) {
            arr[i] = i + 1;
        }

        int lt = 0, gt = 0;
        int num = arr[lt];

        while (gt < n - 1) {
            if (num < n) {
                gt++;
                if (gt >= n -1) {
                    break;
                } else {
                    num += arr[gt];
                }
            } else if (num > n) {
                num -= arr[lt];
                lt++;
            } else if (num == n) {
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
        int k = Integer.parseInt(st.nextToken());
        System.out.print(solution(k));
    }
}

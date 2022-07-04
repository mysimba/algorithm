package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Algo41 {

    public static List<Integer> solution(int num1, int num2, int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<Integer>();
        int p1 = 0, p2 = 0;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        while (p1 < num1 && p2 < num2) {
            if(arr1[p1] == arr2[p2]) {
                result.add(arr1[p1++]);
                p2++;
            } else if (arr1[p1] < arr2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[num1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int num2 = Integer.parseInt(st.nextToken()) ;
        int[] arr2 = new int[num2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        for (int a : solution(num1, num2, arr1, arr2)) {
            System.out.print(a + " ");
        }
    }
}

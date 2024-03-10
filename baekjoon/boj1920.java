package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class boj1920 {
    static int N,M;
    static int[] arr;
    static int[] targets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss1 = br.readLine().split(" ");
        String[] ss2= br.readLine().split(" ");
        N = Integer.parseInt(ss1[0]);
        arr = new int[N];

        for (int i = 0; i < ss2.length; i++) {
            arr[i] = Integer.parseInt(ss2[i]);
        }

        M = Integer.parseInt(br.readLine());
        targets = new int[M];

        String[] ss3= br.readLine().split(" ");
        for (int i = 0; i < targets.length; i++) {
            targets[i] = Integer.parseInt(ss3[i]);
        }

        //정렬
        Arrays.sort(arr);
        for (int i = 0; i < M; i++) {
            System.out.println(findExist(targets[i]));
        }

    }

    private static int findExist(int target) {
        int len = arr.length;
        int lo = 0;
        int hi = arr.length-1;
        int mid = len/2;

        if (arr[0] == target || arr[arr.length-1] == target) {
            return 1;
        }
        if (target < arr[0] || target > arr[arr.length-1]) {
            return 0;
        }

        while(lo<=hi) {
            mid = (lo+hi)/2;

            if (arr[mid] > target) {
                hi = mid-1;
                continue;
            }

            if (arr[mid] < target) {
                lo = mid+1;
                continue;
            }

            if (arr[mid] == target) {
                return 1;
            }

        }
        return 0;
    }
}

//100000 * 100000
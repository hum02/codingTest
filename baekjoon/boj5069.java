package baekjoon;
import java.util.*;

public class boj5069 {
    static int[] dy = {-1, 0, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 0, -1, -1};
//    static Map<Integer, Map<Integer, Map<Integer, Integer>>> dp = new HashMap<>();
    static int[][][] dpArr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        dpArr = new int[15][29][29];
        int[] cases = new int[n];

        for (int i = 0; i < n; i++) {
            cases[i] = Integer.parseInt(scanner.nextLine());
        }

        for (int i = 0; i < n; i++) {
            System.out.println(fn(14, 14, cases[i]));
        }
    }

    //0,0에서 y,x,까지 remain만큼 이동하는 경우의 수
    static int fn(int y, int x, int remain) {
        if (remain == 0) {
            return (y == 14 && x == 14) ? 1 : 0;
        }

        if (dpArr[remain][y][x] != 0) {
            return dpArr[remain][y][x];
        }

//        if (dp.containsKey(y) && dp.get(y).containsKey(x) && dp.get(y).get(x).containsKey(remain)) {
//            return dp.get(y).get(x).get(remain);
//        }
//        dp.putIfAbsent(y, new HashMap<>());
//        dp.get(y).putIfAbsent(x, new HashMap<>());

        int ret = 0;
        for (int d = 0; d < 6; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            ret += fn(ny, nx, remain - 1);
        }
//        dp.get(y).get(x).put(remain, ret);
        dpArr[remain][y][x] = ret;
        return ret;
    }
}

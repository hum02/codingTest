package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj14719 {
    static int w,h;
    static int[] map;
    static int ans = 0;
    static int left;
    static int right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = (br.readLine());
        String[] sa = s.split(" ");

        h = Integer.parseInt(sa[0]);
        w = Integer.parseInt(sa[1]);
        map = new int[w];

        String s2 = br.readLine();
        String[] sa2 = s2.split(" ");
        for (int i = 0; i < sa2.length; i++) {
            map[i] = Integer.parseInt(sa2[i]);
        }

        //답찾기
        //왼쪽부터 높이, 오르쪽가다가 자기 이상이면 그 사이의 넓이 확정.
        //왼쪽부터 가다가 끝까지 자기 이상인 거 없으면 오른쪽 기준으로 넓이 확정
        //포인터 2개 두고 둘 중 작은 것 부터 기준으로 이동할까
        left = 0;
        right = map.length-1;

        while (true) {
            if (left >= right) {
                break;
            }
            //왼쪽부터 이동
            if (map[left] <= map[right]) {
                moveFromLeft();
            } else {
                moveFromRight();
            }
//
//            System.out.println("left" + left + "," + "right" + right);
        }
        System.out.println(ans);
    }

    public static void moveFromLeft() {
        int rain = 0;
        int leftV = map[left];
        for (int i = left+1; i <= right; i++) {

            ++left;
            if (map[i] < leftV) {
                rain+=leftV-map[i];
                continue;
            }
            if (map[i] >= leftV) {
                ans+=rain;
                return;
            }
        }
    }

    public static void moveFromRight() {
        int rain = 0;
        int rightV = map[right];
        for (int i = right-1; i >= left; i--) {
            --right;
            if (map[i] < rightV) {
                rain+=rightV-map[i];
                continue;
            }
            if (map[i] >= rightV) {
                ans+=rain;
                return;
            }
        }
    }

}

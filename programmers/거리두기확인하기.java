package programmers;

import java.util.*;

class Solution {
    char[][] map = new char[5][5];
    int[] dx = {0,0,1,1,2};
    int[] dy = {2,1,1,0,0};

    public int[] solution(String[][] places) {
        int[] answer = {};

        answer = new int[places.length];
        for (int i=0; i< places.length; i++) {
            answer[i] = check(places[i]);
        }

        return answer;
    }

    int check(String[] place) {
        //p끼리 맨해튼 거리 2이하 검사, 파티션 맞혀있으면 허용
        //1.각 위치별로 맨해튼 2거리 이하에 p존재검사, 칸막이 존재 검사
        for (int i=0; i<place.length; i++) {
            String s = place[i];
            char[] chars = s.toCharArray();
            for (int j=0; j< chars.length; j++) {
                map[i][j] = chars[j];
            }
        }


        for (int i=0; i<place.length; i++) {
            for (int j=0; j< place[0].length(); j++) {

                //맨해튼 거리 내에 p검사
                for (int k = 0; k<5; k++) {
                    int ny = i+ dy[k];
                    int nx = j+ dx[k];

                    if (ny<0||ny>4||nx<0||nx>4) {
                        continue;
                    }

                    if (map[ny][nx]=='P') {
                        //사이의 벽 검사
                        int check = 0;
                        for (int y = i; y<= ny; y++) {
                            for (int x = j; x<= nx; x++) {
                                if (y<0||y>4||x<0||x>4) {continue;}
                                if (map[y][x] == 'P') {continue;}
                                if (map[y][x] == 'X') {
                                    if (i == ny || j == nx) {check = 1;}
                                }
                            }
                        }

                        if (i!=ny && j!=nx) {
                            if (i+1<0||i+1>4||j+1<0||j+1>4) {continue;}
                            if (!(map[i+1][j] == 'X' && map[i][j+1] == 'X')) {
                                check = 0;
                            }
                        }

                        //i와 ny, j와 nx가 다르면 y가 다른 벽이 있어야 함
                        //i와 ny가 같으면 뭐라도 있으면 됨
                        if (check ==0) {return check;}
                    }

                }
            }
        }
        return 1;
    }

}

/**
 pooop
 oxxox
 opxpx
 ooxox
 poxxp
 **/

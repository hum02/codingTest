package programmers;
import java.util.*;

class Solution {

    List<String> ws = new ArrayList<>();
    List<char[]> cs = new ArrayList<>();
    boolean[] visited;
    int answer = 99999;

    public int solution(String begin, String target, String[] words) {

        for (String w : words) {
            ws.add(w);
            cs.add(w.toCharArray());
        }
        if (!ws.contains(target)) {
            return 0;
        }
        visited = new boolean[ws.size()+1];

        dfs(begin, target,0);
        if (answer == 99999) {return 0;}
        return answer;
    }

    public void dfs(String begin, String target, int count) {
        if (begin.equals(target)) {
            answer = Math.min(answer,count);
            return;
        }

        if (count >= ws.size()) {
            return;
        }

        char[] beginc = begin.toCharArray();
        for (char[] c : cs) {
            if (visited[cs.indexOf(c)] == true) {
                continue;
            }
            int dif = 0;
            for (int i=0;i<beginc.length; i++) {
                if (c[i]!=beginc[i]) {
                    dif++;
                }
            }

            if (dif == 1) {
                int idx = cs.indexOf(c);
                visited[idx] = true;
                dfs(ws.get(idx), target, count+1);
                visited[idx] = false;
            }
        }
    }
}


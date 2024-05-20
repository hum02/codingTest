package programmers;

import java.util.*;

class Solution {

    String[][] ticks;
    Map<String, Integer> visitc = new HashMap<>();
    Map<String, List<String>> maps = new HashMap<>();
    String[] ans = new String[2];
    List<String> paths = new ArrayList<>();
    String path = "";
    boolean[] visit;

    public String[] solution(String[][] tickets) {
        ticks = tickets;
        ans = new String[ticks.length+1];
        visit = new boolean[ticks.length];
        //정렬해서 map에 넣기
        //icn부터 순회
        //이 노드로 갔을 떄 - 다 사용이 가능한지, 알파벳 순인지 판단

        for (String[] t:tickets) {
            List<String> links = maps.getOrDefault(t[0], new ArrayList<>());
            links.add(t[1]);
            maps.put(t[0], links);
        }

        for (Map.Entry<String, List<String>> et:maps.entrySet()) {
            List<String> links = et.getValue();

            if (links.size()>1) {
                Collections.sort(links);
                maps.put(et.getKey(), links);
            }
        }

        visit("ICN", 0, "");

        Collections.sort(paths);

        return paths.get(0).split(" ");
    }

    public void visit(String cur, int c, String path) {
        if (c == ticks.length) {
            path+=cur+" ";
            paths.add(path);
            return;
        }

        //다음에 갈 노드 선택
        for (int i=0; i< ticks.length; i++) {
            if (ticks[i][0].equals(cur) && visit[i] == false) {
                visit[i] = true;
                visit(ticks[i][1], c+1, path+cur+" ");
                visit[i] = false;
            }
        }


    }
}

//모든 항공권 사용 위해 알파벳 순으로 뒤에 있는것부터 방문하는 경우도 있다.
//썼던 항공권 또 쓸수있나??
//백트래킹으로 어떤 조건을 검사해야 모든 항공권 다 쓸 수 있는지 생각 or 다 검사해서 마지막에 알파벳 앞순 반환


package programmers;

import java.util.*;

class Solution {

    static int gen = 0;
    static int line = 0;
    static int donut = 0;
    static int eight = 0;
    static int[][] edges;

    public int[] solution(int[][] edges) {

        //그래프 합한 거에서 모양 알아내기
        //들어온 게 없는 노드 찾아서 간선 제거
        //나머지 노드 순회하며 모양 찾기
        this.edges = edges;
        Set<Integer> ins = new HashSet<>();
        Set<Integer> outs = new HashSet<>();
        Map<Integer, Integer> outcount = new HashMap<>();

        for (int i=0; i<edges.length; i++) {
            int[] edge = edges[i];
            ins.add(edge[1]);
            outs.add(edge[0]);

            int c = outcount.getOrDefault(edge[0],0);
            outcount.put(edge[0], c+1);
        }

        Set<Integer> outCopy = new HashSet<>();
        outCopy.addAll(outs);

        outs.removeAll(ins);
        for (int n:outs){
            if (outcount.get(n) >=2) {
                gen = n;
            }
        }

        //총 그래프 개수 구하기
        int total = outcount.get(gen);
        outcount.remove(gen);

        //8자 개수세기
        for (Map.Entry<Integer, Integer> m:outcount.entrySet()) {
            int k = m.getKey();

            if (m.getValue() == 2) {
                eight++;
            }
        }

        //막대 개수 세기
        ins.removeAll(outCopy);
        line = ins.size();
        donut = total - (line+eight);

        return new int[]{gen,donut,line,eight};
    }


}
//애초에 그래프를 순회할 때 언제 멈춰야 될지, 언제 다음 순회를 등록안할지, 그래프의 특징을 정확히 파악 못 했었음.


package programmers;



import java.util.*;

class Solution {


    int cur;
    Node[] table;
    Stack<Integer> canceled = new Stack<>(); //위치
    Stack<Node> cancelNxt = new Stack<>();
    int[] ispop;

    static class Node {
        Node pre;
        int v;
        Node nxt;

        Node (Node p, int v, Node n) {
            this.pre = p;
            this.v = v;
            this.nxt = n;
        }

        Node (Node p, int v) {
            this.pre = p;
            this.v = v;
            this.nxt = null;
        }

        Node (int v) {
            this.pre = null;
            this.v = v;
            this.nxt = null;
        }
    }

    public String solution(int n, int k, String[] cmd) {

        table = new Node[n];
        ispop = new int[n]; //0이면 존재
        //초기화
        table[0] = new Node(0);
        table[0].pre = table[0];
        for (int i=1; i<n-1; i++) {
            table[i] = new Node(table[i-1], i);
            table[i-1].nxt = table[i];
        }
        table[n-1] = new Node(table[n-2], n-1);
        table[n-1].nxt = table[n-1];
        table[n-2].nxt = table[n-1];

        cur = k;
        for (String c : cmd) {
            run(c);
        }

        StringBuilder sb = new StringBuilder();
        int[] ans = new int[n];
        //없어졌는지 판단
        for (int i=0; i<n;i++) {
            if (ispop[i]==0) {
                sb.append("O");
            } else {
                sb.append("X");
            }
        }

        return sb.toString();
    }

    void run(String c) {

        String[] cargs = c.split(" ");
        switch (cargs[0]) {
            case "D":
                int count = Integer.valueOf(cargs[1]);
                while (count !=0) {
                    Node next = table[cur].nxt;
                    cur = next.v;
                    --count;
                }
                break;
            case "U":
                int count2 = Integer.valueOf(cargs[1]);
                while (count2 !=0) {
                    Node prev = table[cur].pre;
                    cur = prev.v;
                    --count2;
                }
                break;
            case "C":
                ispop[cur] = 1;
                canceled.push(table[cur].v);
                cancelNxt.push(table[cur].nxt);
                int tmp = table[cur].nxt.v;

                if (table[cur].nxt != table[cur]) {
                    //이전 노드
                    table[cur].pre.nxt = table[cur].nxt;
                    //다음 노드
                    table[cur].nxt.pre = table[cur].pre;
                    cur = tmp;
                } else if (table[cur].nxt == table[cur]){//마지막께 빠지면?
                    table[cur].pre.nxt = table[cur].pre;
                    cur = table[cur].pre.v;
                } else {
                    //제일 앞거 빠짐
                    table[cur].nxt.pre = table[cur].nxt;
                    cur = table[cur].nxt.v;
                }

                break;

            case "Z":
                //선택행은 바뀌지 않음
                int cancelIdx = canceled.pop();
                Node next = cancelNxt.pop();
                ispop[cancelIdx] = 0;

                if (table[cancelIdx].nxt == table[cancelIdx]) {
                    table[cancelIdx].pre.nxt = table[cancelIdx];
                    break;
                }
                if (table[cancelIdx].pre == table[cancelIdx]) {
                    table[cancelIdx].nxt.pre = table[cancelIdx];
                    break;
                }
                //이전 노드 수정
                //다음 노드 수정
                table[cancelIdx].pre.nxt = table[cancelIdx];
                table[cancelIdx].nxt.pre = table[cancelIdx];

                break;
        }
        return;
    }
}

//테이블 크기 n <=1000000


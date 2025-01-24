package programmers;

import java.util.*;

class Solution {

    List<Integer> ans = new ArrayList<>();
    Map<String, Integer> dic = new HashMap<>();
    int Didx = 27;

    public int[] solution(String msg) {
        int[] answer = {};

        for (int i = 1; i<=26; i++) {
            char c = (char)('A'+(i-1));
            String alp = String.valueOf(c);
            dic.put(alp, i);
        }

        List<Integer> ans = new ArrayList<>();
        int end = 1;
        int num = 0;
        for (int i=0; i<msg.length()+1;) {
            if (end>msg.length()) {break;}

            String cur = msg.substring(i,end);
            String next = cur;
            num = dic.getOrDefault(cur,0);

            //사전에 이미 있는거면, 다음꺼 검사
            while (num!=0) {
                cur = next;
                end++;
                if (end>msg.length()) {
                    //끝. 이전에 사전에서 검사한 거 출력해야됨
                    int idx = dic.getOrDefault(cur,0);
                    ans.add(idx);
                    break;
                }
                next = msg.substring(i,end);
                num = dic.getOrDefault(next,0);
            }
            if (num ==0) {
                dic.put(next, Didx++);
                int idx = dic.getOrDefault(cur,0);
                ans.add(idx);
                i=end-1;
            }
        }



        //msg에서 글자를 뽑고
//         List<Integer> ans = new ArrayList<>();
//         int last = 0;
//         int lastIdx = 0;
//         int idxNum =0;
//         int i=1;
//         for (; i<=msg.length(); i++) {
//             String s1 = msg.substring(last,i);
//             // System.out.println("last: "+last+"i: "+i);
//             lastIdx = idxNum;
//             idxNum = dic.getOrDefault(s1, 0);
//             if (idxNum == 0) {//사전에 없는 거면
//                 ans.add(lastIdx);
//                 dic.put(s1, idx++);
//                 last = i-1;
//                 i=last;
//             }
//         }
//         //마지막으로 검사한게 사전에 있는거였으면 출력
//         if (last != i-1) {
//             ans.add(idxNum);
//         }

        answer = new int[ans.size()];
        int idx = 0;
        for (int n:ans) {
            answer[idx++] = n;
        }

        // System.out.println(ans);



        // int last = 0;
//         for (int i=0; i<msg.length(); i++) {
//             String find = msg.substring(last,i);
//             int num = dic.getOrDefault(find, 0);
//             int prev = num;
//             while (num!=0 ) {
//                 //사전에 있으면 한번더 나아가 찾기
//                 ++i;
//                 if (i>msg.length()) {
//                     ans.add(num);
//                     break;
//                 }
//                 prev = num;
//                 find = msg.substring(last,i);
//                 num = dic.getOrDefault(find, 0);
//             }

//             //사전에 없는거임
//             if (num ==0) {
//                 dic.put(find, idx);
//                 ++idx;
//             }

//             //사전에 있던 거 출력
//             if (i>msg.length()) {
//                 break;
//              }
//             last = i;
//             ans.add(prev);

//         }

//         System.out.println(ans);
//         return answer;
        return answer;
    }
}

/**
 사전 초기화

 사전 찾아봐서 있으면, 다음 단어까지 사전에서 찾아보기
 해당 단어가 없으면, 등록하고 이전까지 사전에서 찾을 거 출력

 **/
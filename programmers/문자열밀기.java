//class Solution {
//    public int solution(String A, String B) {
//        int answer = 0;
//
//        for (int i=0; i<=A.length(); i++) {
//            if (A.equals(B)) {
//                return answer;
//            }
//
//            A = charPush(A);
//            answer++;
//        }
//
//
//        return -1;
//    }
//
//    public String charPush(String target) {
//        String s = target.substring(0,target.length()-1);
//        String a =  target.charAt(target.length()-1) + s;
//        System.out.println(a);
//        return a;
//    }
//}
//
////A=B인 비교 어케하지 char다 돌아야 하나
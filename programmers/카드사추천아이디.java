package programmers;

public class 카드사추천아이디 {

    static String[] rl;
    public static void main(String[] registed_list, String new_id) {
        rl = registed_list;
        String S = "", N= "";
        //기존에 존재하는 id인지 검사
        boolean isOnly = true;
        for (String id:rl) {
            if (id.equals(new_id)) {
                isOnly = false;
                break;
            }
        }
        if (isOnly) {
            System.out.println(new_id);
            return new_id;
        }

        //존재하면,숫자를 +1해가며 존재하는지 검사
        //s와 n 분리
        int i = 0;
        String next = "";
        for (; i < new_id.length(); i++) {
            char cur = new_id.charAt(i);
            if (cur>='0' && cur<= '9') {
                S = new_id.substring(0, i);
                N = new_id.substring(i, new_id.length());
                N = nextNum(N);
                next = S+N;
                break;
            }
        }
        if(i == new_id.length()) {//숫자부분이 없으면
            S = new_id;
            N = "1";
            next = S+N;
        }


        //숫자부분 늘려가며 기존에 있는지 검사

       while (isContain(next)) {
           N = nextNum(N);
           next=S+N;
       }

        System.out.println(next);
       return next;

    }

    static String nextNum(String n) {
        return String.valueOf(Integer.parseInt(n)+1);
    }
    static boolean isContain(String cur) {
        for (String id:rl) {
            if (id.equals(cur)) {
                return true;
            }
        }

        return false;
    }
}

/**
 *
 * new id가 이미 있는건지 검사
 * **/
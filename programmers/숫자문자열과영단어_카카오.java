package programmers;

import java.util.*;

class 숫자문자열과영단어_카카오 {

    String[] arr = {"zero","one","two","three","four","five","six","seven","eight","nine"};

    public int solution(String s) {
        //char배열에서 숫자를 어케찾지
        //char마다 String만들어가면서 words에서 존재검사.

        for (int i=0; i< arr.length; i++) {
            if (s.contains(arr[i])) {
                s.replace(arr[i], Integer.toString(i));
            }
        }
        return Integer.valueOf(s);
    }
}


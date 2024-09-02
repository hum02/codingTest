package programmers;

import java.util.HashSet;
import java.util.Set;

public class 두개뽑아더하기 {

    public int[] solution(int[] numbers) {
        //두개씩 더해 set에
        //set에 있는 거 정렬해 반환
        int len = numbers.length;
        Set<Integer> nums = new HashSet<>();

        for(int i=0; i<len-1; i++) {
            for (int j = i+1; j<len; j++) {
                int sum=numbers[i] + numbers[j];
                nums.add(sum);
            }
        }

        return nums.stream().sorted()
                .mapToInt(Integer::intValue)
                .toArray();

    }
}

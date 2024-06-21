package Lv1;

import java.util.HashSet;
import java.util.Set;

/*
 *   N마리의 폰켓몬 중에서 N/2마리를 가져갈 수 있다.
 *   폰켓몬은 종류에 따라 번호를 붙여 구분합니다.
 *   따라서 같은 종류의 폰켓몬은 같은 번호를 가지고 있습니다.
 *   최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택하려 합니다.
 * */
public class Phonekemon {

  public static void main(String[] args) {
    Phonekemon solution = new Phonekemon();
    int[] nums = {3, 3, 3, 2, 2, 2};
    System.out.println(solution.solution(nums));
  }

  public int solution(int[] nums) {
    int answer = 0, N = nums.length;
    Set<Integer> phonekemonSet = new HashSet<>();

    for (int i : nums) {
      phonekemonSet.add(i);
    }

    answer = Math.min(phonekemonSet.size(), N / 2);

    return answer;
  }

}

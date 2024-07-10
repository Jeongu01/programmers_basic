package Lv0;

import java.util.HashMap;
import java.util.Map;

public class FindMode {

  public static void main(String[] args) {
    FindMode Solution = new FindMode();
    int[] arr = {1,2,3,3,3,4};
    System.out.println(Solution.solution(arr));
    int[] arr2 = {1, 1, 2, 2, 3, 3};
    System.out.println(Solution.solution(arr2));
    int[] arr3 = {12, 12, 1};
    System.out.println(Solution.solution(arr3));
    int[] arr4 = {1};
    System.out.println(Solution.solution(arr4));
  }

  public int solution(int[] array) {
    int answer = 0;

    Map<Integer, Integer> map = new HashMap<>();

    for (int i : array) {
      int temp = map.getOrDefault(i, 0);
      map.put(i, temp + 1);
    }

    int[] temp = new int[2];

    int max = 0;
    for (Integer integer : map.keySet()) {
      max = Math.max(map.get(integer), max);
      if (map.get(integer) >= max) {
        max = map.get(integer);
        answer = integer;
        if (temp[0] < temp[1]) {
          temp[0] = max;
        } else {
          temp[1] = max;
        }
      }
    }

    if (temp[0] == temp[1]) answer = -1;

    return answer;
  }
}

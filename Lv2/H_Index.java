package Lv2;

import java.util.ArrayList;
import java.util.Arrays;

public class H_Index {

  public static void main(String[] args) {
    H_Index solution = new H_Index();
    int[] citations = {3, 0, 6, 1, 5};
    int[] citations2 = {5, 6, 7, 8};
    System.out.println(solution.solution(citations2));
  }

  public int solution(int[] citations) {
    int answer = citations.length;
    Arrays.sort(citations);

    for (int citation : citations) {
      if (citation < answer) answer--;
      else break;
    }

    return answer;
  }
}

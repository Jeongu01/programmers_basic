package Lv2;

import java.util.ArrayList;
import java.util.Comparator;

public class BiggestNumber {

  public static void main(String[] args) {
    int[] numbers = {6, 10, 2};
    int[] numbers2 = {3, 30, 34, 5, 9};
    int[] numbers3 = {979, 97, 978, 81, 818, 817};
    int[] numbers4 = {10, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    BiggestNumber solution = new BiggestNumber();
    System.out.println(solution.solution(numbers));
    System.out.println(solution.solution(numbers2));
    System.out.println(solution.solution(numbers3));
    System.out.println(solution.solution(numbers4));
  }

  public String solution(int[] numbers) {
    String answer = "";

    ArrayList<String> arr = new ArrayList<>();
    for (int i = 0; i < numbers.length; i++) {
      arr.add(String.valueOf(numbers[i]));
    }

    // comparator 쓸 때 항상 1, 0, -1을 반환할 수 있는 조건을 넣어줘야 한다네요
    arr.sort(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if ((o1 + o2).compareTo(o2 + o1) > 0){
          return -1;
        } else if ((o1 + o2).compareTo(o2 + o1) < 0){
          return 1;
        } else {
          return 0;
        }
      }
    });

    if (arr.get(0).equals("0"))
      answer += "0";
    else {
      for (String s : arr){
        answer = answer.concat(s);
      }
    }

    return answer;
  }
}

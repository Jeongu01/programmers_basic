package Lv1;

import java.util.Arrays;
import java.util.Stack;

public class HateSameNumber {

  public static void main(String[] args) {
    HateSameNumber Solution = new HateSameNumber();
    int[] arr1 = {1,1,3,3,0,1,1};
    System.out.println(Arrays.toString(Solution.solution(arr1)));
    int[] arr2 = {4,4,4,3,3};
    System.out.println(Arrays.toString(Solution.solution(arr2)));
  }

  public int[] solution(int[] arr) {
    Stack<Integer> stack = new Stack<>();

    stack.push(arr[0]);
    for (int i : arr) {
      if (stack.peek() != i) {
        stack.push(i);
      }
    }

    int[] answer = new int[stack.size()];
    for (int i = answer.length - 1; i >= 0; i--) {
      answer[i] = stack.pop();
    }
    return answer;
  }

}

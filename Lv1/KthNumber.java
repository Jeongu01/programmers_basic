package Lv1;

import java.util.ArrayList;
import java.util.Arrays;

public class KthNumber {

  public static void main(String[] args) {
    KthNumber solution = new KthNumber();
    int[] array = {1, 5, 2, 6, 3, 7, 4};
    int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
    int[] answer = solution.solution(array, commands);
    for (int i : answer) {
      System.out.print(i + " ");
    }
  }

  public int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];

    int resultIndex = 0;

    for (int[] command : commands){
      int[] arr = new int[command[1] - command[0] + 1];
      int index = 0;
      for (int i = command[0] - 1; i < command[1]; i++){
        arr[index++] = array[i];
      }
      Arrays.sort(arr);
      answer[resultIndex++] = arr[command[2] - 1];
    }

    return answer;
  }
}

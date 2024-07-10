package Lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ProcessProb {

  public static void main(String[] args) {
    ProcessProb Solution = new ProcessProb();
    int[] priorities = {2, 1, 3, 2};
    System.out.println(Solution.solution(priorities, 2));
    int[] priorities2 = {1, 1, 9, 1, 1, 1};
    System.out.println(Solution.solution(priorities2, 0));

  }

  public int solution(int[] priorities, int location) {
    int answer = 0;

    Queue<Integer> queue = new LinkedList<>();
    Integer[] sortedArray = new Integer[priorities.length];
    for (int i = 0; i < sortedArray.length; i++) {
      sortedArray[i] = priorities[i];
      queue.add(priorities[i]);
    }
    Arrays.sort(sortedArray, (a, b) -> b - a);

    int count = 0;
    for (Integer integer : sortedArray) {
      while (!queue.peek().equals(integer)) {
        queue.add(queue.remove());
        location -= 1;
        if (location < 0 ) location = queue.size() - 1;
      }
      count++;
      queue.remove();
      if (location == 0) return count;
      location -= 1;
      if (location < 0 ) location = queue.size() - 1;
    }

    return answer;
  }
}

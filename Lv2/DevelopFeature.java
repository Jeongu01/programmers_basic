package Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DevelopFeature {

  public static void main(String[] args) {
    DevelopFeature Solution = new DevelopFeature();
    int[] progresses = {93, 30, 55};
    int[] speeds = {1, 30, 5};
    System.out.println(Arrays.toString(Solution.solution(progresses, speeds)));
    int[] progresses2 = {95, 90, 99, 99, 80, 99};
    int[] speeds2 = {1, 1, 1, 1, 1, 1};
    System.out.println(Arrays.toString(Solution.solution(progresses2, speeds2)));
    int[] progresses3 = {98, 99, 98};
    int[] speeds3 = {1, 1, 1};
    System.out.println(Arrays.toString(Solution.solution(progresses3, speeds3)));

  }

  public int[] solution(int[] progresses, int[] speeds) {

    Queue<Integer> queue = new LinkedList<>();
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < progresses.length; i++) {
      int temp = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
      if (queue.isEmpty() || queue.peek() >= temp) {
        queue.add(temp);
      } else {
        list.add(queue.size());
        queue.clear();
        queue.add(temp);
      }
    }

    if (!queue.isEmpty()) {
      list.add(queue.size());
    }

    int[] answer = new int[list.size()];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = list.get(i);
    }

    return answer;
  }
}

package Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class PassingTruckOverBridge {

  public static void main(String[] args) {
    PassingTruckOverBridge Solution = new PassingTruckOverBridge();
    int[] truck_weights = {7, 4, 5, 6};
    System.out.println(Solution.solution(2, 10, truck_weights));
    int[] truck_weights2 = {10};
    System.out.println(Solution.solution(100, 100, truck_weights2));
    int[] truck_weights3 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
    System.out.println(Solution.solution(100, 100, truck_weights3));

  }

  public int solution(int bridge_length, int weight, int[] truck_weights) {
    Queue<Integer> move = new LinkedList<>();
    Queue<Integer> wait = new LinkedList<>();

    for (int truck_weight : truck_weights) {
      wait.add(truck_weight);
    }

    for (int i = 0; i < bridge_length; i++) {
      move.add(0);
    }

    int time = 0;
    int sum = 0;
    while (!(sum == 0 && wait.isEmpty())) {
      sum -= move.peek();   //  무브 큐에선 무조건 하나씩 빠짐
      move.remove();

      int temp = wait.isEmpty() ? 0 : wait.peek();  // 대기 중인 트럭이 없으면 0

      if (!wait.isEmpty() && sum + temp <= weight) {
        sum += wait.peek();
        move.add(wait.remove());
      } else {
        move.add(0);
      }

      time++;
    }

    return time;
  }

}

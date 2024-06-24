package Lv1;

import java.util.HashMap;

public class MemoryScore {

  public static void main(String[] args) {
    MemoryScore solution = new MemoryScore();
    String[] name = {"may", "kein", "kain", "radi"};
    int[] yearning = {5, 10, 1, 3};
    String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"},
        {"kon", "kain", "may", "coni"}};
    solution.solution(name, yearning, photo);
  }

  public int[] solution(String[] name, int[] yearning, String[][] photo) {
    int[] answer = new int[photo.length];

    HashMap<String, Integer> yearningMap = new HashMap<>();
    for (int i = 0; i < name.length; i++) {
      yearningMap.put(name[i], yearning[i]);
    }

    int index = 0;
    for (String[] p : photo) {
      int sum = 0;
      for (String person : p) {
        sum += yearningMap.getOrDefault(person, 0);
      }
      answer[index] = sum;
      index++;
    }

    return answer;
  }
}

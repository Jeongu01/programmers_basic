package Lv2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Costume {

  public static void main(String[] args) {
    Costume solution = new Costume();
    String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"},
        {"green_turban", "headgear"}};
    System.out.println(solution.solution(clothes));

    String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
    System.out.println();
    System.out.println(solution.solution(clothes2));
  }

  public int solution(String[][] clothes) {
    int answer = 1;
    HashMap<String, Integer> clothesMap = new HashMap<>();

    for (String[] cloth : clothes) {
      if (!clothesMap.containsKey(cloth[1])){
        clothesMap.put(cloth[1], 2);
      } else {
        clothesMap.put(cloth[1], clothesMap.get(cloth[1]) + 1);
      }
    }

    for (String clothType : clothesMap.keySet()) {
      answer *= clothesMap.get(clothType);
    }

    return answer - 1;
  }
}

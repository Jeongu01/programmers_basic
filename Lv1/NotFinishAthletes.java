package Lv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import javax.lang.model.type.NullType;

public class NotFinishAthletes {

  public static void main(String[] args) {
    NotFinishAthletes solution = new NotFinishAthletes();
//    String[] participant = {"leo", "kiki", "eden"};
//    String[] completion = {"kiki", "eden"};
//    System.out.println(solution.solution(participant, completion));
//
//    String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
//    String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
//    System.out.println(solution.solution(participant2, completion2));

    String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
    String[] completion3 = {"stanko", "ana", "mislav"};
    System.out.println(solution.solution(participant3, completion3));
  }

  public String solution(String[] participant, String[] completion) {
    String answer = "";
    HashMap<String, Integer> hashmap = new HashMap<>();

    for (String athlete : participant) {
      if (hashmap.containsKey(athlete)){
        hashmap.put(athlete, hashmap.get(athlete) + 1);
      } else {
        hashmap.put(athlete, 1);
      }
    }

    for (String athlete : completion){
      if (hashmap.get(athlete) == 1) {
        hashmap.remove(athlete);
      } else {
        hashmap.put(athlete, hashmap.get(athlete) - 1);
      }
    }

    answer = (String) hashmap.keySet().toArray()[0];

    return answer;
  }
}

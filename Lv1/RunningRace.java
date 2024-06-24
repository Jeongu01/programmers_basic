package Lv1;

import java.util.HashMap;

public class RunningRace {

  public static void main(String[] args) {
    RunningRace solution = new RunningRace();
    String[] players = {"mumu", "soe", "poe", "kai", "mine"};
    String[] callings = {"kai", "kai", "mine", "mine"};
    solution.solution(players, callings);
    for (String player : players) {
      System.out.println(player);
    }
  }

  public String[] solution(String[] players, String[] callings) {

    HashMap<String, Integer> findPlayerRanking = new HashMap<>();
    for (int i = 0; i < players.length; i++) {
      findPlayerRanking.put(players[i], i);
    }

    for (String calling : callings) {
      int callingRank = findPlayerRanking.get(calling);
      String athleteFront = players[findPlayerRanking.get(calling) - 1];
      players[findPlayerRanking.get(calling)] = athleteFront;
      players[findPlayerRanking.get(calling) - 1] = calling;
      findPlayerRanking.put(calling, callingRank - 1);
      findPlayerRanking.put(athleteFront, callingRank);
    }

    return players;
  }


}

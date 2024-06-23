package Lv1;

import java.util.HashMap;

/*
 *   2024 KAKAO WINTER INTERNSHIP
 *
 * */
public class MostReceivedGift {

  public static void main(String[] args) {
    MostReceivedGift solution = new MostReceivedGift();
    String[] friends = {"muzi", "ryan", "frodo", "neo"};
    String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi",
        "frodo muzi", "frodo ryan", "neo muzi"};
    System.out.println(solution.solution(friends, gifts));
  }

  public int solution(String[] friends, String[] gifts) {
    int answer = 0;

    // HashMap< 준 사람, HashMap< 받은 사람, 개수 > >
    HashMap<String, HashMap<String, Integer>> giveAndTakeGift = new HashMap<>();

    for (String friend : friends) {
      giveAndTakeGift.put(friend, new HashMap<>());
    }

    // 선물 기록
    for (String gift : gifts) {
      String[] giveAndTakeRecord = gift.split(" ");
      String give = giveAndTakeRecord[0];
      String from = giveAndTakeRecord[1];
      giveAndTakeGift.get(give).put(from, giveAndTakeGift.get(give).getOrDefault(from, 0) + 1);
    }

    // 선물 지수 계산
    HashMap<String, Integer> giftPoint = new HashMap<>();

    for (String give : friends) {
      for (String from : friends) {
        // 선물 주고 받은 기록 확인
//        System.out.println(give + " -> " + from + " : " + giveAndTakeGift.get(give).getOrDefault(from, 0) + " ");
        giftPoint.put(give,
            giftPoint.getOrDefault(give, 0) + giveAndTakeGift.get(give).getOrDefault(from, 0));
        giftPoint.put(from,
            giftPoint.getOrDefault(from, 0) - giveAndTakeGift.get(give).getOrDefault(from, 0));
      }
    }

    // 선물 지수 확인
//    for (String friend : friends) {
//      System.out.println(friend + " : " + giftPoint.get(friend) + " ");
//    }

    // 받을 선물 개수 계산
    HashMap<String, Integer> giftCount = new HashMap<>();

    for (String friend1 : friends) {
      for (String friend2 : friends) {
        System.out.println("friend1 : " + friend1 + ", friend2 : " + friend2);
        if (giveAndTakeGift.get(friend1).getOrDefault(friend2, 0) > giveAndTakeGift.get(friend2)
            .getOrDefault(friend1, 0)) {
          // friend1이 준 선물이 더 많은 경우
          giftCount.put(friend1, giftCount.getOrDefault(friend1, 0) + 1);
        } else if (giveAndTakeGift.get(friend1).getOrDefault(friend2, 0) < giveAndTakeGift.get(
            friend2).getOrDefault(friend1, 0)) {
          // friend2가 준 선물이 더 많은 경우
          giftCount.put(friend2, giftCount.getOrDefault(friend2, 0) + 1);
        } else {
          // 주고 받은 선물 개수가 같은 경우
          if (giftPoint.getOrDefault(friend1, 0) > giftPoint.getOrDefault(friend2, 0)) {
            // friend1이 선물 지수가 높은 경우
            giftCount.put(friend1, giftCount.getOrDefault(friend1, 0) + 1);
          } else if (giftPoint.getOrDefault(friend1, 0) < giftPoint.getOrDefault(friend2, 0)) {
            // friend2가 선물 지수가 높은 경우
            giftCount.put(friend2, giftCount.getOrDefault(friend2, 0) + 1);
          }
        }
      }
    }

    for (String friend : friends) {
      answer = Math.max(answer, giftCount.getOrDefault(friend, 0));
    }

    return answer / 2;
  }
}

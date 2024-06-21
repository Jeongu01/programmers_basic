package Lv1;

/*  2022 KAKAO BLIND RECRUITMENT 신고 결과 받기
 *   각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
 *   신고 횟수 제한은 없습니다.
 *   동일 유저에 대한 신고는 1회로 처리됩니다.
 *   k번 이상 신고되면 정지되고, 해당 유저를 신고한 모든 유저에게 그 사실을 알립니다.
 *    -> 마지막에 한꺼번에 정지 메일을 발송합니다.
 *
 *  */

import java.util.*;

public class GetReportResults {

  public static void main(String[] args) {
    GetReportResults solution = new GetReportResults();
    String[] id_list = {"con", "ryan"};
    String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
    int k = 3;
    solution.solution(id_list, report, k);

    System.out.println();

    String[] id_list2 = {"muzi", "frodo", "apeach", "neo"};
    String[] report2 = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
    k = 2;
    solution.solution(id_list2, report2, k);
  }

  public int[] solution(String[] id_list, String[] report, int k) {
    int[] answer = new int[id_list.length];
    HashMap<String, HashSet<String>> reported = new HashMap<>();

    for (String r : report) {
      String[] reportDetail = r.split(" ");
      String reporterId = reportDetail[0];
      String reportedId = reportDetail[1];

      if (!reported.containsKey(reportedId)) {
        reported.put(reportedId, new HashSet<String>());
        reported.get(reportedId).add(reporterId);
      } else {
        reported.get(reportedId).add(reporterId);
      }
    }

    for (int i = 0; i < id_list.length; i++) {
      if (reported.containsKey(id_list[i]) && reported.get(id_list[i]).size() >= k) {
        for (int j = 0; j < id_list.length; j++){
          if (reported.get(id_list[i]).contains(id_list[j])) answer[j]++;
        }
      }
    }

    return answer;
  }

//  public int[] solution(String[] id_list, String[] report, int k) {
//    HashMap<String, Integer> countReported = new HashMap<>();
//    HashMap<String, String> whoReported = new HashMap<>();
//    int[] answer = new int[id_list.length];
//
//    // 중복되는 신고 삭제
//    Set<String> set = new LinkedHashSet<>(Arrays.asList(report));
//    report = set.toArray(new String[0]);
//
//    for (String r : report) {
//      String[] reportArr = r.split(" ");
//      String reporterId = reportArr[0];
//      String reportedId = reportArr[1];
//
//      if (!countReported.containsKey(reportedId)) {
//        // id가 처음 신고 당한 경우
//        countReported.put(reportedId, 1);
//        whoReported.put(reportedId, reporterId);
//      } else {
//        // id가 신고 당한 적 있는 경우
//        countReported.put(reportedId, countReported.get(reportedId) + 1);
//        whoReported.put(reportedId, whoReported.get(reportedId) + " " + reporterId);
//      }
//    }
//
//    for (int i = 0; i < id_list.length; i++) {
//      if (countReported.containsKey(id_list[i]) && countReported.get(id_list[i]) >= k) {
//        // 신고를 k번 이상 신고 당한 경우
//        String[] reporters = whoReported.get(id_list[i]).split(" ");
//        for (int j = 0; j < reporters.length; j++) {
//          // 신고자 리스트에 따라서
//          for (int l = 0; l < id_list.length; l++) {
//            // id_list에서 같은 id를 탐색
//            if (id_list[l].equals(reporters[j])) {
//              answer[l]++;
//            }
//          }
//        }
//      }
//    }
//
//    for (int a : answer) {
//      System.out.print(a + " ");
//    }
//
//    return answer;
//  }
}

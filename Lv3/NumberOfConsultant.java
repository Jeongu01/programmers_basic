package Lv3;

import java.util.ArrayList;

public class NumberOfConsultant {

  public static void main(String[] args) {
    NumberOfConsultant Solution = new NumberOfConsultant();

    int k = 3;
    int n = 5;
    int[][] reqs = {{10, 60, 1}, {15, 100, 3}, {20, 30, 1}, {30, 50, 3}, {50, 40, 1}, {60, 30, 2}, {65, 30, 1}, {70, 100, 2}};

    System.out.println("1번 : " + Solution.solution(k, n, reqs));

    k = 2;
    n = 3;
    int[][] reqs2 = {{5, 55, 2}, {10, 90, 2}, {20, 40, 2}, {50, 45, 2}, {100, 50, 2}};

    System.out.println("2번 : " + Solution.solution(k, n, reqs2));
  }

  // k : 상담 유형의 수
  // n : 멘토 수
  // reqs {a, b, c}
  //  - a : 시각
  //  - b : 상담 시간
  //  - c : 유형
  // k 크기의 type 배열
  //
  // 각 유형별 멘토 수에 따른 대기 시간 배열
  // total[][]  1     2     3    ~~
  // type[1]   155    5     0
  // type[2]    20    0     0
  // type[3]    85    0     0
  //
  // 멘토 수에 따라 감소폭이 가장 큰 유형에 멘토를 1명씩 증가
  //
  //
  // 1 유형 시나리오
  // total[1][1] # mentor 1명
  // {10, 60, 1}
  // {20, 30, 1}
  // {50, 40, 1}
  // {65, 30, 1}
  // mentor[1] = 70(10 + 60)
  // total[1][1] 에 50(70 - 20) 더함   # total = 50
  // mentor[1] = 100(70 + 30)
  // total[1][1] 에 50(100 - 50) 더함  # total = 100
  // mentor[1] = 140(100 + 40)
  // total[1][1] 에 75(140 - 65) 더함  # total = 175
  // total[1][1] 에 175 저장
  //
  // total[1][2] # mentor 2명
  // mentor[1] = 70(10 + 60)
  // mentor[2] = 50(20 + 30)
  // total[1][2] 에 0(50 - 50 < 70 - 50) 더함  # total = 0
  // mentor[1] = 70(그대로)
  // mentor[2] = 90(50 + 40)
  // total[1][2] 에 5(70 - 65 < 90 - 65) 더함  # total = 5
  // total[1][2] 에 5 저장
  //
  // total[1][3] # mentor 3명
  // mentor[1] = 70(10 + 60)
  // mentor[2] = 50(20 + 30)
  // mentor[3] = 90(50 + 40)
  // total[1][3] 에 0 (50 - 65, 0) 더함  # total = 0
  // mentor[2] = 95(65 + 30)
  // total[1][3] 에 0 저장
  //
  // 반복 중지하고 다음 유형으로 넘어감
  //
  // k = 3, n = 5
  public int solution(int k, int n, int[][] reqs) {
    int answer = 0;

    int[] mentor = new int[n - k + 2];    // 멘토 번호는 1부터 시작
    int[] type = new int[k + 1];          // 유형별 멘토 수
    int[][] total = new int[type.length][mentor.length];

    // mentor[1] = 70(10 + 60)
    // total[1][1] 에 50(70 - 20) 더함   # total = 50
    // mentor[1] = 100(70 + 30)
    // total[1][1] 에 50(100 - 50) 더함  # total = 100
    // mentor[1] = 140(100 + 40)
    // total[1][1] 에 75(140 - 65) 더함  # total = 175
    // total[1][1] 에 175 저장

    // 유형별 검사
    for (int t = 1; t < type.length; t++) {
      // 멘토 인원 수 별
      for (int mSize = 1; mSize < mentor.length; mSize++) {

        // 멘토 초기화
        for (int m = 1; m <= mSize; m++) {
          mentor[m] = 0;
        }

        // 요청 처리
        for (int[] req : reqs) {

          int reqTime = req[0];       // 찾아온 시각
          int durationTime = req[1];  // 상담 시간
          int reqType = req[2];       // 상담 유형

          if (reqType == t) {
            int freeMentor = 1;
            for (int m = 1; m <= mSize; m++) {
              freeMentor = (mentor[freeMentor] <= mentor[m]) ? freeMentor : m;  // 가장 먼저 끝나는 멘토 찾기
            }
            if (reqTime < mentor[freeMentor]) { // 대기 시간이 생긴 경우
              total[t][mSize] += mentor[freeMentor] - reqTime;  // 기다린 시간만큼 더해주기
              mentor[freeMentor] += durationTime; // 멘토의 상담이 끝나는 시간 갱신
            } else {  // 대기 시간이 안 생긴 경우
              mentor[freeMentor] = reqTime + durationTime;
            }
          }
        }
      }
    }

//    for (int t = 1; t < type.length; t++) {
//      // 멘토 인원 수 별
//      for (int mSize = 1; mSize < mentor.length; mSize++) {
//        System.out.print(total[t][mSize] + " ");
//      }
//      System.out.println();
//    }

    // 유형별 멘토 수 1로 초기화
    for (int t = 1; t < type.length; t++) {
      type[t] = 1;
    }

    while (k != n) {
      int max = 1;
      for (int t = 2; t < type.length; t++) {
        int t1 = total[max][type[max]] - total[max][type[max] + 1];
        int t2 = total[t][type[t]] - total[t][type[t] + 1];
        max = (t1 > t2) ? max : t;  // 멘토 수 증가에 따른 시간 감소가 가장 큰 유형 찾기
      }
      type[max]++;
      k++;
    }

    for (int i = 1; i < type.length; i++) {
//      System.out.println("i : " + i + ", type[i] : " + type[i] + ", total :" + total[i][type[i]]);
      answer += total[i][type[i]];
    }

    return answer;
  }
}

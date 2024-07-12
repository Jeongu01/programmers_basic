package Lv2;

public class OilDrilling {

  public static void main(String[] args) {
    OilDrilling Solution = new OilDrilling();
    int[][] land = {
        {0, 0, 0, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 1, 1, 0, 0},
        {1, 1, 0, 0, 0, 1, 1, 0},
        {1, 1, 1, 0, 0, 0, 0, 0},
        {1, 1, 1, 0, 0, 0, 1, 1}
    };
    System.out.println(Solution.solution(land));
    int[][] land2 = {
        {1, 0, 1, 0, 1, 1},
        {1, 0, 1, 0, 0, 0},
        {1, 0, 1, 0, 0, 1},
        {1, 0, 0, 1, 0, 0},
        {1, 0, 0, 1, 0, 1},
        {1, 0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1, 1}
    };
    System.out.println(Solution.solution(land2));
    int[][] land3 = {
        {1, 1, 1, 1},
        {1, 0, 0, 0},
        {1, 0, 1, 0},
        {1, 0, 0, 0},
        {1, 1, 1, 1}
    };
    System.out.println(Solution.solution(land3));
    int[][] land4 = {
        {1, 1, 1, 0, 0, 0},
        {1, 1, 1, 0, 0, 0},
        {0, 0, 0, 1, 1, 1},
        {0, 0, 1, 1, 0, 0}
    };
    System.out.println(Solution.solution(land4));

  }

  public int solution(int[][] land) {
    int answer = 0;
    boolean[][] isVisited = new boolean[land.length][land[0].length];

    for (int row = 0; row < land.length; row++) {
      for (int col = 0; col < land[0].length; col++) {
        if (!isVisited[row][col] && land[row][col] != 0) {
          int value = checkAround(land, isVisited, row, col);
          if (value != 0) {
            saveAmount(land, isVisited, value);
          }
        }
      }
    }

    for (int row = 0; row < land.length; row++) {
      for (int col = 0; col < land[0].length; col++) {
        System.out.print(land[row][col] + " ");
      }
      System.out.println();
    }

    for (int col = 0; col < land[0].length; col++) {
      int sum = 0;
      boolean same = false;
      for (int row = 0; row < land.length; row++) {
        if (land[row][col] == 0) {
          same = false;
        } else if (!same) {
          sum += land[row][col];
          same = true;
        }
      }
      answer = Math.max(answer, sum);
    }

    return answer;
  }

  public int checkAround(int[][] land, boolean[][] isVisited, int row, int col) {
    if (row < 0 || col < 0) {
      return 0; // 배열 범위 확인
    } else if (row >= land.length || col >= land[0].length) {
      return 0;
    } else if (isVisited[row][col]) {
      return 0;  // 방문한 곳인지 확인
    } else if (land[row][col] == 0) {
      return 0;   // 석유가 없으면 0 반환
    } else if (land[row][col] == 1) {    // 석유가 있으면
      isVisited[row][col] = true;
      return checkAround(land, isVisited, row - 1, col) +
          checkAround(land, isVisited, row, col - 1) +
          checkAround(land, isVisited, row + 1, col) +
          checkAround(land, isVisited, row, col + 1) +
          land[row][col];
    }
    return 0;
  }

  public void saveAmount(int[][] land, boolean[][] isVisited, int value) {
    for (int row = 0; row < land.length; row++) {
      for (int col = 0; col < land[0].length; col++) {
        if (isVisited[row][col]) {
          land[row][col] = value;
          isVisited[row][col] = false;
        }
      }
    }
  }


}

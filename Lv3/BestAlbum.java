package Lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

/*
 * 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시합니다.
 * 노래는 고유 번호로 구분합니다.
 * 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 *
 * */
public class BestAlbum {

  public static void main(String[] args) {
    BestAlbum solution = new BestAlbum();
    String[] genres = {"classic", "classic", "classic", "classic", "pop"};
    int[] plays = {50, 60, 100, 30, 8000};
    int[] answer = solution.solution(genres, plays);
    for (int a : answer){
      System.out.print(a + " ");
    }
  }

  public int[] solution(String[] genres, int[] plays) {

    HashMap<String, int[][]> albumRank = new HashMap<>();
    HashMap<String, Integer> genrePlayCount = new HashMap<>();

    //    고유번호  재생수
    //  0 3         800
    //  1 0         500

    // -1로 초기화
    for (String genre : genres) {
      if (!albumRank.containsKey(genre)) {
        albumRank.put(genre, new int[2][2]);
        Arrays.fill(albumRank.get(genre)[0], -1);
        Arrays.fill(albumRank.get(genre)[1], -1);
      }
    }

    for (int i = 0; i < genres.length; i++) {
      if (albumRank.get(genres[i])[1][0] >= 0) {
        // 각 장르별 상위 2위 배열에 2개의 앨범이 있는 경우
        if (albumRank.get(genres[i])[0][1] < plays[i]) {
          // i번 앨범의 재생 횟수가 가장 많은 경우
          albumRank.get(genres[i])[1][0] = albumRank.get(genres[i])[0][0];
          albumRank.get(genres[i])[1][1] = albumRank.get(genres[i])[0][1];
          albumRank.get(genres[i])[0][0] = i;
          albumRank.get(genres[i])[0][1] = plays[i];
        } else if (albumRank.get(genres[i])[1][1] < plays[i]) {
          // i번 앨범의 재생 횟수가 2번째로 많은 경우
          albumRank.get(genres[i])[1][0] = i;
          albumRank.get(genres[i])[1][1] = plays[i];
        }
      } else if (albumRank.get(genres[i])[0][0] >= 0) {
        // 1개의 앨범만 있는 경우
        if (albumRank.get(genres[i])[0][1] >= plays[i]) {
          // i번 앨범의 재생 횟수가 더 적은 경우
          albumRank.get(genres[i])[1][0] = i;
          albumRank.get(genres[i])[1][1] = plays[i];
        } else {
          // i번 앨범의 재생 횟수가 더 많은 경우
          albumRank.get(genres[i])[1][0] = albumRank.get(genres[i])[0][0];
          albumRank.get(genres[i])[1][1] = albumRank.get(genres[i])[0][1];
          albumRank.get(genres[i])[0][0] = i;
          albumRank.get(genres[i])[0][1] = plays[i];
        }
      } else {
        // 아무것도 없는 경우
        albumRank.get(genres[i])[0][0] = i;
        albumRank.get(genres[i])[0][1] = plays[i];
      }

      // 장르 총 재생 횟수
      if (!genrePlayCount.containsKey(genres[i])) {
        genrePlayCount.put(genres[i], plays[i]);
      } else {
        genrePlayCount.put(genres[i], genrePlayCount.get(genres[i]) + plays[i]);
      }
    }

    // 장르 총 횟수 순위별 내림차순 정렬
    Comparator<Integer> comparator = Comparator.reverseOrder();
    TreeMap<Integer, String> genreRank = new TreeMap<>(comparator);
    for (String genre : genrePlayCount.keySet()) {
      genreRank.put(genrePlayCount.get(genre), genre);
    }

    ArrayList<Integer> answerList = new ArrayList<>();

    for (int rank : genreRank.keySet()) {
      if (albumRank.get(genreRank.get(rank))[1][0] >= 0) {
        answerList.add(albumRank.get(genreRank.get(rank))[0][0]);
        answerList.add(albumRank.get(genreRank.get(rank))[1][0]);
      } else if (albumRank.get(genreRank.get(rank))[0][0] >= 0) {
        answerList.add(albumRank.get(genreRank.get(rank))[0][0]);
      }
    }

    int[] answer = new int[answerList.size()];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = answerList.get(i);
    }

    return answer;
  }
}

package Lv2;

import java.util.Arrays;
import java.util.Comparator;

/*
 *   2018 KAKAO BLIND RECRUITMENT
 *   파일명은 영문 대소문자, 숫자, 공백" ", 마침표".", 빼기 부호"-"만으로 이루어져 있다.
 *   파일명 구성 :
 *     HEAD : 숫자가 아닌 문자로 이루어져있다.
 *     NUMBER : 한 글자에서 최대 다섯 글자 사이며 앞쪽에 0이 올 수 있다.
 *     TAIL : 나머지 부분으로 숫자가 다시 나타날 수도 있고, 아무 글자도 없을 수도 있다.
 *   정렬 기준 :
 *     우선 HEAD 부분을 기준으로 정렬한다. 대소문자 구분하지 않는다.
 *     NUMBER의 숫자 순으로 정렬한다. 숫자 앞의 0은 무시한다. 012와 12는 같은 값으로 처리된다.
 *     둘 다 같을 경우 원래 입력 순서를 유지한다.
 * */
public class SortFileName {

  public static void main(String[] args) {

    SortFileName solution = new SortFileName();
    String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
    String[] files2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II",
        "F-14 Tomcat"};
    solution.solution(files);
    System.out.println("==============");
    solution.solution(files2);
  }

  public String[] solution(String[] files) {
    String[] answer = {};

    Comparator<String> comparator = new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        int o1NumStart = findDigitPos(o1);
        int o2NumStart = findDigitPos(o2);
        if (o1.substring(0, o1NumStart).equalsIgnoreCase(o2.substring(0, o2NumStart))) {
          // HEAD 영역이 같은 경우
          return Integer.parseInt(o1.substring(o1NumStart, findCharPos(o1, o1NumStart)))
              - Integer.parseInt(o2.substring(o2NumStart, findCharPos(o2, o2NumStart)));
        }
        // HEAD 영역이 다른 경우
        return o1.substring(0, o1NumStart).toUpperCase()
            .compareTo(o2.substring(0, o2NumStart).toUpperCase());
      }
    };

    Arrays.sort(files, comparator);

    answer = files;

    return answer;
  }

  public static int findDigitPos(String file) {

    for (int i = 0; i < file.length(); i++) {
      if ('0' <= file.charAt(i) && file.charAt(i) <= '9') {
        return i;
      }
    }

    return 0;
  }

  public static int findCharPos(String file, int numStart) {

    for (int i = numStart; i < file.length(); i++) {
      if ('a' <= file.charAt(i) && file.charAt(i) <= 'z') {
        return i;
      } else if ('A' <= file.charAt(i) && file.charAt(i) <= 'Z') {
        return i;
      }

      switch (file.charAt(i)) {
        case ' ', '.', '-' -> {
          return i;
        }
      }
    }

    return file.length();
  }
}

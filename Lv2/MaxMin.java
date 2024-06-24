package Lv2;

public class MaxMin {

  public static void main(String[] args) {
    MaxMin solution = new MaxMin();
    String s = "1 -3 4 2";
    System.out.println(solution.solution(s));
  }

  public String solution(String s) {
    String answer = "";
    int max, min;

    String[] integers = s.split(" ");
    max = Math.max(Integer.valueOf(integers[0]), Integer.valueOf(integers[1]));;
    min = Math.min(Integer.valueOf(integers[0]), Integer.valueOf(integers[1]));;

    for (String integer : integers){
      max = Math.max(max, Integer.valueOf(integer));
      min = Math.min(min, Integer.valueOf(integer));
    }

    answer = new String(min + " " + max);

    return answer;
  }

}

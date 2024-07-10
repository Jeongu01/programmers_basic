package Lv2;

import java.util.Stack;

public class CorrectParenthesis {

  public static void main(String[] args) {
    CorrectParenthesis Solution = new CorrectParenthesis();
    System.out.println(Solution.solution("()()"));
    System.out.println(Solution.solution("(())()"));
    System.out.println(Solution.solution(")()("));
    System.out.println(Solution.solution("(()("));
  }

  boolean solution(String s) {
    char[] arr = s.toCharArray();
    Stack<Character> stack = new Stack<>();

    for (char c : arr) {
      if (c == '(') {
        stack.push(c);
      } else if (c == ')') {
        if (stack.isEmpty()) return false;
        stack.pop();
      }
    }

    return stack.isEmpty();
  }
}

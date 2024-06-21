package Lv2;

import java.util.Arrays;

public class PhoneNumberList {

  public static void main(String[] args) {
    PhoneNumberList solution = new PhoneNumberList();
    String[] phone_book = {"123", "11233"};
    System.out.println(solution.solution(phone_book));
  }

  public boolean solution(String[] phone_book) {

    Arrays.sort(phone_book);

    if (phone_book.length == 1) {
      return true;
    }

    for (int i = 0; i < phone_book.length - 1; i++) {
      if (phone_book[i].length() <= phone_book[i + 1].length() && phone_book[i].equals(
          phone_book[i + 1].substring(0, phone_book[i].length()))) {
        return false;
      }
    }

    return true;
  }

}

package Lv2;

import java.util.Arrays;
import java.util.Stack;

public class StockPrice {

  public static void main(String[] args) {
    StockPrice Solution = new StockPrice();
    int[] prices = {1,2,3,2,3};
    System.out.println(Arrays.toString(Solution.solution(prices)));
  }

  public int[] solution(int[] prices) {
    int[] answer = new int[prices.length];

    Stack<Stock> stack = new Stack<>();

    int time = 1;
    for (int i = 0; i < prices.length; i++) {
      Stock s = new Stock(i, prices[i], time);

      while (!stack.isEmpty() && stack.peek().price > prices[i]) {
        Stock temp = stack.pop();
        answer[temp.index] = time - temp.time;
      }

      stack.push(s);
      time++;
    }

    time = prices.length;
    while (!stack.isEmpty()) {
      Stock temp = stack.pop();
      answer[temp.index] = time - temp.time;
    }

    return answer;
  }

  class Stock {

    public int index;
    public int price;
    public int time;

    Stock(int index, int price, int time) {
      this.index = index;
      this.price = price;
      this.time = time;
    }
  }
}

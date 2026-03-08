package ru.mentee.power;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LiveCodingDemo {
  // Не использоваться статик методы кроме мэйн, статические переменные, класс мэйн только аркестрирует вызовы. Метод поиска максимума из массива 10 чисел, рандомный, не отсортированный.

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>(List.of(1, 3, 5, 3, 2, 5, 3, 8, 6, 4));
    numbers.add(null);
    LiveCodingDemo object = new LiveCodingDemo();
    int max = object.maxNumber(numbers);
    System.out.println(max);
  }


  public int maxNumber(List<Integer> numbers) {
    int max = 0;
    for (int i = 0; i < numbers.size(); i++) {
      if (numbers.get(i) != null && numbers.get(i) > max) {
        max = numbers.get(i);
      }
    }
    return max;
  }
}

package ru.mentee.power.progress;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MenteeTest {

  @Test
  void testConstructorShouldCreateMenteeWithValidData() {
    String name = "Иван Иванов";
    String city = "Москва";
    String goal = "Backend разработка";
    int completedLessons = 5;
    int totalLessons = 12;

    Mentee mentee = new Mentee(name, city, goal, completedLessons, totalLessons);

    assertEquals(name, mentee.name());
    assertEquals(city, mentee.city());
    assertEquals(goal, mentee.goal());
    assertEquals(completedLessons, mentee.completedLessons());
    assertEquals(totalLessons, mentee.totalLessons());
  }

  @Test
  void testConstructorShouldThrowExceptionWhenCompletedLessonsNegative() {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new Mentee("Анна", "СПб", "Fullstack", -1, 10)
    );

    assertTrue(exception.getMessage().contains("Некорректные значения прогресса"));
  }

  @Test
  void testConstructorShouldThrowExceptionWhenTotalLessonsZero() {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new Mentee("Мария", "Казань", "Java", 5, 0)
    );

    assertTrue(exception.getMessage().contains("Некорректные значения прогресса"));
  }

  @Test
  void testConstructorShouldThrowExceptionWhenTotalLessonsNegative() {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new Mentee("Сергей", "Екатеринбург", "Frontend", 3, -5)
    );

    assertTrue(exception.getMessage().contains("Некорректные значения прогресса"));
  }

  @Test
  void testConstructorShouldThrowExceptionWhenCompletedMoreThanTotal() {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new Mentee("Ольга", "Новосибирск", "QA", 15, 10)
    );

    assertTrue(exception.getMessage().contains("Некорректные значения прогресса"));
  }

  @Test
  void testConstructorShouldAcceptEdgeCases() {
    Mentee zeroCompleted = new Mentee("Дмитрий", "Ростов", "DevOps", 0, 5); // 0 из 5
    Mentee allCompleted = new Mentee("Анна", "Краснодар", "Mobile", 10, 10); // 10 из 10

    assertEquals(0, zeroCompleted.completedLessons());
    assertEquals(5, zeroCompleted.totalLessons());
    assertEquals(10, allCompleted.completedLessons());
    assertEquals(10, allCompleted.totalLessons());
  }

  @Test
  void testEqualsShouldReturnTrueForSameData() {
    Mentee mentee1 = new Mentee("Алексей", "Уфа", "Python", 8, 10);
    Mentee mentee2 = new Mentee("Алексей", "Уфа", "Python", 8, 10);

    assertTrue(mentee1.equals(mentee2));
  }

  @Test
  void testHashCodeShouldBeSameForEqualObjects() {
    Mentee mentee1 = new Mentee("Елена", "Пермь", "C#", 5, 8);
    Mentee mentee2 = new Mentee("Елена", "Пермь", "C#", 5, 8);

    assertEquals(mentee1.hashCode(), mentee2.hashCode());
  }

  @Test
  void testToStringShouldContainAllFields() {
    Mentee mentee = new Mentee("Виктор", "Волгоград", "Go", 3, 6);

    String result = mentee.toString();

    assertTrue(result.contains("Виктор"));
    assertTrue(result.contains("Волгоград"));
    assertTrue(result.contains("Go"));
    assertTrue(result.contains("3"));
    assertTrue(result.contains("6"));
  }
}
package ru.mentee.power.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StudentTest {

  @Test
  void testConstructorShouldCreateStudentWithCorrectNameAndCity() {
    String name = "Иван Иванов";
    String city = "Москва";

    Student student = new Student(name, city);

    assertEquals(name, student.name());
    assertEquals(city, student.city());
  }

  @Test
  void testEqualsShouldReturnTrueForSameNameAndCity() {
    Student student1 = new Student("Анна Петрова", "Санкт-Петербург");
    Student student2 = new Student("Анна Петрова", "Санкт-Петербург");

    assertTrue(student1.equals(student2));
    assertTrue(student2.equals(student1));
  }

  @Test
  void testHashCodeShouldBeSameForEqualObjects() {
    Student student1 = new Student("Сергей Сидоров", "Казань");
    Student student2 = new Student("Сергей Сидоров", "Казань");

    assertEquals(student1.hashCode(), student2.hashCode());
  }

  @Test
  void testToStringShouldContainNameAndCity() {
    Student student = new Student("Мария Козлова", "Екатеринбург");

    String result = student.toString();

    assertTrue(result.contains("Мария Козлова"));
    assertTrue(result.contains("Екатеринбург"));
  }
}
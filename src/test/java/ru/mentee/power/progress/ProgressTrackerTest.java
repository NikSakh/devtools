package ru.mentee.power.progress;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ProgressTrackerTest {

  private final ProgressTracker tracker = new ProgressTracker();

  @Test
  void testCalculateTotalProgressShouldReturnZeroProgressForNullArray() {
    String result = tracker.calculateTotalProgress(null);

    assertEquals("Суммарно: пройдено 0 из 0 уроков, осталось 0 уроков", result,
        "Для null массива должен возвращаться нулевой прогресс");
  }

  @Test
  void testCalculateTotalProgressShouldReturnZeroProgressForEmptyArray() {
    Mentee[] emptyArray = new Mentee[0];

    String result = tracker.calculateTotalProgress(emptyArray);

    assertEquals("Суммарно: пройдено 0 из 0 уроков, осталось 0 уроков", result,
        "Для пустого массива должен возвращаться нулевой прогресс");
  }

  @Test
  void testCalculateTotalProgressShouldCalculateCorrectlyForSingleMentee() {
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend разработка", 5, 12)
    };

    String result = tracker.calculateTotalProgress(mentees);

    assertEquals("Суммарно: пройдено 5 из 12 уроков, осталось 7 уроков", result,
        "Для одного менти с 5/12 должно быть 5 пройдено, 7 осталось");
  }

  @Test
  void testCalculateTotalProgressShouldSumProgressForMultipleMentees() {
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
        new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
        new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
    };

    String result = tracker.calculateTotalProgress(mentees);

    assertEquals("Суммарно: пройдено 25 из 36 уроков, осталось 11 уроков", result,
        "Должен правильно суммировать прогресс всех менти: 5+8+12=25, 12+12+12=36, 36-25=11");
  }

  @Test
  void testCalculateTotalProgressShouldHandleAllLessonsCompleted() {
    Mentee[] mentees = {
        new Mentee("Анна", "Екатеринбург", "Frontend", 10, 10),
        new Mentee("Сергей", "Новосибирск", "Mobile", 15, 15)
    };

    String result = tracker.calculateTotalProgress(mentees);

    assertEquals("Суммарно: пройдено 25 из 25 уроков, осталось 0 уроков", result,
        "Когда все уроки пройдены, оставшихся должно быть 0");
  }

  @Test
  void testCalculateTotalProgressShouldHandleNoLessonsCompleted() {
    Mentee[] mentees = {
        new Mentee("Ольга", "Ростов", "QA", 0, 8),
        new Mentee("Дмитрий", "Краснодар", "DevOps", 0, 10)
    };

    String result = tracker.calculateTotalProgress(mentees);

    assertEquals("Суммарно: пройдено 0 из 18 уроков, осталось 18 уроков", result,
        "Когда ни один урок не пройден, пройдено должно быть 0");
  }

  @Test
  void testCalculateTotalProgressShouldHandleMixedProgress() {
    Mentee[] mentees = {
        new Mentee("Алексей", "Уфа", "Python", 3, 5),
        new Mentee("Елена", "Пермь", "C#", 7, 10),
        new Mentee("Виктор", "Волгоград", "Go", 0, 8)
    };

    String result = tracker.calculateTotalProgress(mentees);

    assertEquals("Суммарно: пройдено 10 из 23 уроков, осталось 13 уроков", result,
        "Должно правильно считать смешанный прогресс: 3+7+0=10, 5+10+8=23, 23-10=13");
  }

  @Test
  void testCalculateTotalProgressShouldHandleLargeNumbers() {
    Mentee[] mentees = {
        new Mentee("Максим", "Челябинск", "Data Science", 150, 200),
        new Mentee("Наталья", "Самара", "Machine Learning", 180, 200)
    };

    String result = tracker.calculateTotalProgress(mentees);

    assertEquals("Суммарно: пройдено 330 из 400 уроков, осталось 70 уроков", result,
        "Должно корректно работать с большими числами");
  }

  @Test
  void testCalculateTotalProgressShouldHandleSingleLesson() {
    Mentee[] mentees = {
        new Mentee("Ольга", "Ростов", "QA", 1, 1)
    };

    String result = tracker.calculateTotalProgress(mentees);

    assertEquals("Суммарно: пройдено 1 из 1 уроков, осталось 0 уроков", result,
        "Для одного урока (пройденного) должно быть 1/1, осталось 0");
  }
}


package ru.mentee.power;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MenteeProgressTest {

  @Test
  void testConstructorShouldCreateObjectWithCorrectValues() {
    String name = "Анна Иванова";
    int sprintNumber = 3;
    int plannedHours = 5;

    MenteeProgress progress = new MenteeProgress(name, sprintNumber, plannedHours);

    assertEquals(name, progress.menteeName());
    assertEquals(sprintNumber, progress.sprintNumber());
    assertEquals(plannedHours, progress.plannedHoursPerWeek());
  }

  @Test
  void testReadyForSprintShouldReturnTrueWhenPlannedHours3OrMore() {
    MenteeProgress progress3 = new MenteeProgress("Иван", 1, 3);
    MenteeProgress progress5 = new MenteeProgress("Мария", 2, 5);
    MenteeProgress progress10 = new MenteeProgress("Сергей", 3, 10);

    assertTrue(progress3.readyForSprint());
    assertTrue(progress5.readyForSprint());
    assertTrue(progress10.readyForSprint());
  }

  @Test
  void testReadyForSprintShouldReturnFalseWhenPlannedHoursLessThan3() {
    MenteeProgress progress0 = new MenteeProgress("Ольга", 1, 0);
    MenteeProgress progress1 = new MenteeProgress("Дмитрий", 2, 1);
    MenteeProgress progress2 = new MenteeProgress("Елена", 3, 2);

    assertFalse(progress0.readyForSprint());
    assertFalse(progress1.readyForSprint());
    assertFalse(progress2.readyForSprint());
  }

  @Test
  void testSummaryShouldReturnFormattedStringWithCorrectValues() {
    MenteeProgress progress = new MenteeProgress("Анна Петрова", 2, 6);

    String result = progress.summary();

    assertEquals("Sprint 2 → Анна Петрова: planned 6 h", result);
  }

  @Test
  void testSummaryShouldHandleEdgeCases() {
    MenteeProgress zeroHours = new MenteeProgress("Алексей", 1, 0);
    MenteeProgress minReady = new MenteeProgress("Наталья", 5, 3);

    assertEquals("Sprint 1 → Алексей: planned 0 h", zeroHours.summary());
    assertEquals("Sprint 5 → Наталья: planned 3 h", minReady.summary());
  }

  @Test
  void testEqualsShouldWorkCorrectlyForRecords() {
    MenteeProgress p1 = new MenteeProgress("Иван", 1, 5);
    MenteeProgress p2 = new MenteeProgress("Иван", 1, 5);
    MenteeProgress p3 = new MenteeProgress("Мария", 1, 5);

    assertTrue(p1.equals(p2));
    assertFalse(p1.equals(p3));
  }

  @Test
  void testHashCodeShouldBeSameForEqualObjects() {
    MenteeProgress p1 = new MenteeProgress("Ольга", 2, 4);
    MenteeProgress p2 = new MenteeProgress("Ольга", 2, 4);

    assertEquals(p1.hashCode(), p2.hashCode());
  }
}
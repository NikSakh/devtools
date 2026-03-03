package ru.mentee.power;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class ProgressDemoTest {

  @Test
  void testMainShouldPrintExpectedOutput() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    try {
      ProgressDemo.main(new String[0]);
      String output = outContent.toString().trim();

      assertTrue(output.contains("Sprint 1 → Имя студента: planned 6 h"));
      assertTrue(output.contains("Status: sprint ready"));

      System.out.println("=== ACTUAL OUTPUT ===");
      System.out.println(output);
      System.out.println("======================");
    } finally {
      System.setOut(originalOut);
    }
  }

  @Test
  void testMainShouldPrintBacklogFirstForLowHours() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    try {
      var progress = new MenteeProgress("Тестовый студент", 1, 2);

      System.out.println(progress.summary());
      if (progress.readyForSprint()) {
        System.out.println("Status: sprint ready");
      } else {
        System.out.println("Status: backlog first");
      }

      String output = outContent.toString().trim();

      assertTrue(output.contains("Sprint 1 → Тестовый студент: planned 2 h"));
      assertTrue(output.contains("Status: backlog first"));
    } finally {
      System.setOut(originalOut);
    }
  }
}
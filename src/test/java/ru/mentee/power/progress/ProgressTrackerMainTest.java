package ru.mentee.power.progress;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class ProgressTrackerMainTest {

  @Test
  void testMainShouldExecuteWithoutExceptions() {
    assertDoesNotThrow(() -> ProgressTrackerMain.main(new String[0]),
        "main метод должен выполняться без исключений");
  }
}
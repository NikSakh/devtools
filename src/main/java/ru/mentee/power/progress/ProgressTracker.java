package ru.mentee.power.progress;

public class ProgressTracker {

  public String calculateTotalProgress(Mentee[] mentees) {
    if (mentees == null || mentees.length == 0) {
      return "Суммарно: пройдено 0 из 0 уроков, осталось 0 уроков";
    }

    int totalCompleted = 0;
    int totalTotal = 0;
    int index = 0;

    while (index < mentees.length) {
      totalCompleted += mentees[index].completedLessons();
      totalTotal += mentees[index].totalLessons();
      index++;
    }

    int totalRemaining = totalTotal - totalCompleted;

    return String.format("Суммарно: пройдено %d из %d уроков, осталось %d уроков",
        totalCompleted, totalTotal, totalRemaining);
  }
}


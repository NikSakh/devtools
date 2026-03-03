package ru.mentee.power.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentListTest {

  private StudentList studentList;
  private Student student1;
  private Student student2;
  private Student student3;

  @BeforeEach
  void setUp() {
    studentList = new StudentList();
    student1 = new Student("Иван Иванов", "Москва");
    student2 = new Student("Анна Петрова", "Санкт-Петербург");
    student3 = new Student("Сергей Сидоров", "Москва");
  }

  @Test
  void testConstructorShouldInitializeEmptyList() {
    StudentList list = new StudentList();

    assertNotNull(list.getStudentsFromSpecificCity("Москва"));
    assertTrue(list.getStudentsFromSpecificCity("Москва").isEmpty());
  }

  @Test
  void testAddStudentShouldAddNonNullStudentToList() {
    studentList.addStudent(student1);

    List<Student> studentsFromMoscow = studentList.getStudentsFromSpecificCity("Москва");
    assertEquals(1, studentsFromMoscow.size());
    assertTrue(studentsFromMoscow.contains(student1));
  }

  @Test
  void testAddStudentShouldNotAddNullStudent() {
    studentList.addStudent(null);

    List<Student> allStudents = studentList.getStudentsFromSpecificCity("Любой город");
    assertTrue(allStudents.isEmpty());
  }

  @Test
  void testGetStudentsFromSpecificCityShouldReturnEmptyListForNonExistentCity() {
    studentList.addStudent(student1); // Москва
    studentList.addStudent(student2); // Санкт-Петербург

    List<Student> result = studentList.getStudentsFromSpecificCity("Новосибирск");

    assertNotNull(result);
    assertTrue(result.isEmpty());
  }

  @Test
  void testGetStudentsFromSpecificCityShouldReturnCorrectStudentsForExistingCity() {
    studentList.addStudent(student1); // Москва
    studentList.addStudent(student2); // Санкт-Петербург
    studentList.addStudent(student3); // Москва

    List<Student> moscowStudents = studentList.getStudentsFromSpecificCity("Москва");

    assertEquals(2, moscowStudents.size());
    assertTrue(moscowStudents.contains(student1));
    assertTrue(moscowStudents.contains(student3));
  }

  @Test
  void testGetStudentsFromSpecificCityShouldReturnEmptyListWhenNoStudents() {
    List<Student> result = studentList.getStudentsFromSpecificCity("Москва");

    assertNotNull(result);
    assertTrue(result.isEmpty());
  }

  @Test
  void testGetStudentsFromSpecificCityShouldBeCaseSensitive() {
    studentList.addStudent(new Student("Ольга Волкова", "Москва"));

    List<Student> lowerCaseResult = studentList.getStudentsFromSpecificCity("москва");
    List<Student> upperCaseResult = studentList.getStudentsFromSpecificCity("МОСКВА");
    assertTrue(lowerCaseResult.isEmpty());
    assertTrue(upperCaseResult.isEmpty());
  }
}
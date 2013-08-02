/*
 * CS 2340 Final Project
 * Gradebook
 * By Alec Fenichel
 */
package gradebook.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * The Class CourseTest.
 *
 * @author Alec Fenichel
 */

@RunWith(JUnit4.class)
public class CourseTest {

    /** The prerequisites. */
    ArrayList<Course> prerequisites =
            new ArrayList<Course>();

    /** The course. */
    Course course =
            new Course(
                    "CS", 2340, "Objects and Design", prerequisites);

    /** The class one. */
    Class classOne =
            new Class(
                    course, "Summer 2013");

    /** The class two. */
    Class classTwo =
            new Class(
                    course, "Summer 2013");

    /** The section. */
    Section section =
            new Section(
                    "A", classOne);

    /** The section2. */
    Section section2 =
            new Section(
                    "B", classTwo);

    /** The gradebook category. */
    GradebookCategory gradebookCategory =
            new GradebookCategory(
                    "Test", 1);

    /** The new student. */
    Student newStudent =
            new Student(
                    "Alec Fenichel");

    /** The new student2. */
    Student newStudent2 =
            new Student(
                    "John Doe");

    /** The new student3. */
    Student newStudent3 =
            new Student(
                    "Jane Doe");

    /** The new student4. */
    Student newStudent4 =
            new Student(
                    "Jack Doe");

    /** The new student5. */
    Student newStudent5 =
            new Student(
                    "Jessica Doe");

    /**
     * Test get and create.
     */
    @Test
    public
            void testGetAndCreate() {
        assertNotNull(
                "Course creation test failed.", course);
        String subject =
                course.getSubject();
        int courseNumber =
                course.getCourseNumber();
        String courseName =
                course.getCourseName();
        ArrayList<Course> retreievedPrereqs =
                course.getPrerequisites();
        assertEquals(
                "CS", subject);
        assertEquals(
                2340, courseNumber);
        assertEquals(
                "Objects and Design", courseName);
        assertSame(
                prerequisites, retreievedPrereqs);
    }

    /**
     * Test setters.
     */
    @Test
    public
            void testSetters() {
        course.setSubject("ECE");
        course.setCourseNumber(3710);
        course.setCourseName("Linear Circuits");
        prerequisites
                .add(new Course(
                        "MATH", 1501, "Calculus I"));
        course.setPrerequisites(prerequisites);
        String subject =
                course.getSubject();
        int courseNumber =
                course.getCourseNumber();
        String courseName =
                course.getCourseName();
        ArrayList<Course> retreievedPrereqs =
                course.getPrerequisites();
        assertEquals(
                "setSubject test failed.", "ECE", subject);
        assertEquals(
                "setCourseNumber test failed.", 3710, courseNumber);
        assertEquals(
                "setCouseName test failed.", "Linear Circuits", courseName);
        assertSame(
                "setPrerequisites test failed.", prerequisites,
                retreievedPrereqs);
    }

    /**
     * Test averages.
     */
    @Test
    public
            void testAverages() {
        newStudent
                .addGradebookItem(new GradebookItem(
                        "Test 1", gradebookCategory, 100));
        newStudent
                .addGradebookItem(new GradebookItem(
                        "Test 2", gradebookCategory, 20));
        newStudent2
                .addGradebookItem(new GradebookItem(
                        "Test 1", gradebookCategory, 85));
        newStudent2
                .addGradebookItem(new GradebookItem(
                        "Test 2", gradebookCategory, 90));
        newStudent3
                .addGradebookItem(new GradebookItem(
                        "Test 1", gradebookCategory, 90));
        newStudent3
                .addGradebookItem(new GradebookItem(
                        "Test 2", gradebookCategory, 85));
        newStudent4
                .addGradebookItem(new GradebookItem(
                        "Test 1", gradebookCategory, 85));
        newStudent4
                .addGradebookItem(new GradebookItem(
                        "Test 2", gradebookCategory, 85));
        newStudent5
                .addGradebookItem(new GradebookItem(
                        "Test 1", gradebookCategory, 85));
        newStudent5
                .addGradebookItem(new GradebookItem(
                        "Test 2", gradebookCategory, 75));
        section.addStudent(newStudent);
        section.addStudent(newStudent2);
        section.addStudent(newStudent3);
        section2.addStudent(newStudent4);
        section2.addStudent(newStudent5);
        classOne.addSection(section);
        classTwo.addSection(section2);
        course.addClass(classOne);
        course.addClass(classTwo);
        ArrayList<Course> classes =
                new ArrayList<Course>();
        classes.add(classOne);
        classes.add(classTwo);
        assertEquals(
                classes, course.getClasses());
        GradingScheme defaultGrading =
                new DefaultGrading();
        String letterGrade =
                course.calculateLetterGrade(defaultGrading);
        assertEquals(
                "LetterGrade calculation failed.", "B", letterGrade);
        double averageScore =
                course.calculateAverageScore(defaultGrading);
        assertEquals(
                80.41, averageScore, 0.00);
    }
}

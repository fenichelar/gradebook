/*
 * CS 2340 Final Project
 * Gradebook
 * By Alec Fenichel
 */
package gradebook.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * The Class ClassTest.
 *
 * @author Alec Fenichel
 */

@RunWith(JUnit4.class)
public class ClassTest {

    /** The course. */
    Course course =
            new Course(
                    "CS", 2340, "Objects and Design");

    /** The class as class. */
    Class classAsClass =
            new Class(
                    course, "Summer 2013");

    /** The class as course. */
    Course classAsCourse =
            new Class(
                    course, "Summer 2013");

    /** The section. */
    Section section =
            new Section(
                    "A", classAsClass);

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

    /** The section2. */
    Section section2 =
            new Section(
                    "B", classAsClass);

    /** The new student4. */
    Student newStudent4 =
            new Student(
                    "Jack Doe");

    /** The new student5. */
    Student newStudent5 =
            new Student(
                    "Jessica Doe");

    /**
     * Test create.
     */
    @Test
    public
            void testCreate() {
        assertNotNull(
                "Class as class failed", classAsClass);
        assertNotNull(
                "Class as course failed", classAsCourse);
    }

    /**
     * Test get and set.
     */
    @Test
    public
            void testGetAndSet() {
        String subject =
                classAsClass
                        .getSubject();
        int courseNumber =
                classAsClass
                        .getCourseNumber();
        String courseName =
                classAsClass
                        .getCourseName();
        String semester =
                classAsClass
                        .getSemester();
        assertEquals(
                "getSubject test failed.", "CS", subject);
        assertEquals(
                "getCourseNumber test failed.", 2340, courseNumber);
        assertEquals(
                "getCourseName test failed.", "Objects and Design", courseName);
        assertEquals(
                "getSemester test failed.", "Summer 2013", semester);
        classAsClass
                .setSemester("Fall 2013");
        assertEquals(
                "getSemester test failed.", "Fall 2013",
                classAsClass
                        .getSemester());
    }

    /**
     * Test add and get section.
     */
    @Test
    public
            void testAddAndGetSection() {
        classAsClass
                .addSection(section);
        ArrayList<Section> sections =
                classAsClass
                        .getSections();
        assertTrue(
                "Section test failed.", sections.contains(section));
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
        section.addStudent(newStudent);
        section.addStudent(newStudent2);
        section.addStudent(newStudent3);
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
        section2.addStudent(newStudent4);
        section2.addStudent(newStudent5);
        classAsClass
                .addSection(section);
        classAsClass
                .addSection(section2);
        assertEquals(
                2, classAsClass
                        .getSections().size());
        GradingScheme defaultGrading =
                new DefaultGrading();
        double averageScore =
                classAsClass
                        .calculateAverageScore(defaultGrading);
        assertEquals(
                80.41, averageScore, 0.00);
        String letterGrade =
                classAsClass
                        .calculateLetterGrade(defaultGrading);
        assertEquals(
                "LetterGrade calculation failed.", "B", letterGrade);

    }
}

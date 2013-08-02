/*
 * CS 2340 Final Project
 * Gradebook
 * By Alec Fenichel
 */
package gradebook.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * The Class SectionTest.
 *
 * @author Alec Fenichel
 */

@RunWith(JUnit4.class)
public class SectionTest {

    /** The course. */
    Course course =
            new Course(
                    "CS", 2340, "Objects and Design");

    /** The parent class. */
    Class parentClass =
            new Class(
                    course, "Summer 2013");

    /** The parent class. */
    Class parentClass2 =
            new Class(
                    course, "Fall 2013");

    /** The section. */
    Section section =
            new Section(
                    "A", parentClass);

    /** The new student. */
    Student newStudent =
            new Student(
                    "Alec Fenichel");

    /** The gradebook category. */
    GradebookCategory gradebookCategory =
            new GradebookCategory(
                    "Test", 1);

    /** The new student2. */
    Student newStudent2 =
            new Student(
                    "John Doe");

    /** The new student3. */
    Student newStudent3 =
            new Student(
                    "Jane Doe");

    /**
     * Test create.
     */
    @Test
    public
            void testCreate() {
        assertNotNull(
                "Section creation failed.", section);
    }

    /**
     * Test add and get students.
     */
    @Test
    public
            void testAddAndGetStudents() {
        section.addStudent(newStudent);
        ArrayList<Student> students =
                section.getStudents();
        assertTrue(
                "Add and Get students failed.", students.contains(newStudent));
    }

    /**
     * Test set and get section name.
     */
    @Test
    public
            void testSetAndGetSectionName() {
        assertEquals(
                "A", section.getSectionName());
        section.setSectionName("B");
        assertEquals(
                "B", section.getSectionName());
    }

    /**
     * Test set and get parent class.
     */
    @Test
    public
            void testSetAndGetParentClass() {
        assertSame(
                parentClass, section.getParentClass());
        section.setParentClass(parentClass2);
        assertEquals(
                parentClass2, section.getParentClass());
    }

    /**
     * Test averages.
     */
    @Test
    public
            void testAverages() {
        GradingScheme defaultGrading =
                new DefaultGrading();
        newStudent
                .addGradebookItem(new GradebookItem(
                        "Test 1", gradebookCategory, 100));
        newStudent
                .addGradebookItem(new GradebookItem(
                        "Test 2", gradebookCategory, 20));
        section.addStudent(newStudent);
        String letterGrade =
                section.calculateLetterGrade(defaultGrading);
        assertEquals(
                "LetterGrade calculation failed.", "D", letterGrade);
        newStudent2
                .addGradebookItem(new GradebookItem(
                        "Test 1", gradebookCategory, 85));
        newStudent2
                .addGradebookItem(new GradebookItem(
                        "Test 2", gradebookCategory, 90));
        section.addStudent(newStudent2);
        newStudent3
                .addGradebookItem(new GradebookItem(
                        "Test 1", gradebookCategory, 90));
        newStudent3
                .addGradebookItem(new GradebookItem(
                        "Test 2", gradebookCategory, 85));
        section.addStudent(newStudent3);
        double averageScore =
                section.calculateAverageScore(defaultGrading);
        assertEquals(
                78.33, averageScore, 0.00);
    }
}

/*
 * CS 2340 Final Project
 * Gradebook
 * By Alec Fenichel
 */
package gradebook.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * The Class StudentTest.
 *
 * @author Alec Fenichel
 */

@RunWith(JUnit4.class)
public class StudentTest {

    /** The student. */
    private Student student =
            new Student(
                    "Alec Fenichel");

    /** The student2. */
    private Student student2 =
            new Student(
                    "John Doe");

    /** The gradebook category. */
    private GradebookCategory gradebookCategory =
            new GradebookCategory(
                    "HW", 1);

    /** The gradebook categor2y. */
    private GradebookCategory gradebookCategory2 =
            new GradebookCategory(
                    "Quiz", 1);

    /** The gradebook item. */
    private GradebookItem gradebookItem =
            new GradebookItem(
                    "HW 1", gradebookCategory, 93);

    /** The gradebook item2. */
    private GradebookItem gradebookItem2 =
            new GradebookItem(
                    "HW 2", gradebookCategory, 86);

    /** The gradebook item3. */
    private GradebookItem gradebookItem3 =
            new GradebookItem(
                    "HW 2", gradebookCategory, 76);

    /** The gradebook item4. */
    private GradebookItem gradebookItem4 =
            new GradebookItem(
                    "HW 2", gradebookCategory, 66);

    /** The gradebook item5. */
    private GradebookItem gradebookItem5 =
            new GradebookItem(
                    "HW 2", gradebookCategory, 42);

    /**
     * Test create.
     */
    @Test
    public
            void testCreate() {
        assertNotNull(
                "Create student failed.", student);
        assertNotNull(
                "Create student 2 failed.", student2);
    }

    /**
     * Test get and set.
     */
    @Test
    public
            void testGetAndSet() {
        assertEquals(
                "Alec Fenichel", student.getName());
        student2.setName("Jane Doe");
        assertEquals(
                "Jane Doe", student2.getName());
    }

    /**
     * Test gradebook items.
     */
    @Test
    public
            void testGradebookItems() {
        assertNotNull(
                "add or getGradebookItems failed.", student.getGradebookItems());
        Student student =
                new Student(
                        "Alec Fenichel");
        ArrayList<GradebookItem> gradebookItems =
                new ArrayList<GradebookItem>();
        gradebookItems
                .add(gradebookItem);
        student.addGradebookItem(gradebookItem);
        assertEquals(
                gradebookItems, student.getGradebookItems());
        gradebookItem
                .setScore(91);
        assertEquals(
                91, gradebookItem.getScore(), 0.00);
    }

    /**
     * Test gradebook category.
     */
    @Test
    public
            void testGradebookCategory() {
        assertNotNull(
                "TestGradebookCategory failed.", student.getGradebookItems());
        Student student =
                new Student(
                        "Alec Fenichel");
        ArrayList<GradebookItem> gradebookItems =
                new ArrayList<GradebookItem>();
        gradebookItems
                .add(gradebookItem);
        student.addGradebookItem(gradebookItem);
        assertEquals(
                gradebookCategory, gradebookItem.getGradebookCategory());
        gradebookItem
                .setGradebookCategory(gradebookCategory2);
        assertEquals(
                gradebookCategory2, gradebookItem.getGradebookCategory());
    }

    /**
     * Test average calculations.
     */
    @Test
    public
            void testAverageCalculations() {
        student.addGradebookItem(gradebookItem);
        student.addGradebookItem(gradebookItem2);
        double studentScore =
                student.calculateScore(new DefaultGrading());
        assertEquals(
                89.5, studentScore, 0.00);
    }

    /**
     * Letter grade calculation.
     */
    @Test
    public
            void letterGradeCalculation() {
        student =
                new Student(
                        "Alec Fenichel");
        student.addGradebookItem(gradebookItem);
        assertEquals(
                "A", student.calculateLetterGrade(new DefaultGrading()));
        student =
                new Student(
                        "Alec Fenichel");
        student.addGradebookItem(gradebookItem2);
        assertEquals(
                "B", student.calculateLetterGrade(new DefaultGrading()));
        student =
                new Student(
                        "Alec Fenichel");
        student.addGradebookItem(gradebookItem3);
        assertEquals(
                "C", student.calculateLetterGrade(new DefaultGrading()));
        student =
                new Student(
                        "Alec Fenichel");
        student.addGradebookItem(gradebookItem4);
        assertEquals(
                "D", student.calculateLetterGrade(new DefaultGrading()));
        student =
                new Student(
                        "Alec Fenichel");
        student.addGradebookItem(gradebookItem5);
        assertEquals(
                "F", student.calculateLetterGrade(new DefaultGrading()));
    }
}

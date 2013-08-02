/*
 * CS 2340 Final Project
 * Gradebook
 * By Alec Fenichel
 */
package gradebook.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

    /** The gradebook item. */
    private GradebookItem gradebookItem =
            new GradebookItem(
                    "HW 1", gradebookCategory, 93);

    /** The gradebook item2. */
    private GradebookItem gradebookItem2 =
            new GradebookItem(
                    "HW 2", gradebookCategory, 86);

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
        student.addGradebookItem(gradebookItem);
        assertNotNull(
                "add or getGradebookItems failed.", student.getGradebookItems());
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
}

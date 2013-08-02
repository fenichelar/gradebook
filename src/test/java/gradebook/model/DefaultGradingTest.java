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
 * The Class DefaultGradingTest.
 *
 * @author Alec Fenichel
 */

@RunWith(JUnit4.class)
public class DefaultGradingTest {

    /** The student. */
    Student student =
            new Student(
                    "Alec Fenichel");

    /** The tests. */
    GradebookCategory tests =
            new GradebookCategory(
                    "Tests", .51);

    /** The quiz category. */
    GradebookCategory quizCategory =
            new GradebookCategory(
                    "Quizzes", .17);

    /** The final exam category. */
    GradebookCategory finalCategory =
            new GradebookCategory(
                    "Final", .32);

    /** The test1. */
    GradebookItem test1 =
            new GradebookItem(
                    "Test 1", tests, 86.2);

    /** The test2. */
    GradebookItem test2 =
            new GradebookItem(
                    "Test 2", tests, 72.23);

    /** The test3. */
    GradebookItem test3 =
            new GradebookItem(
                    "Test 3", tests, 88);

    /** The quizzes. */
    GradebookItem quizzes =
            new GradebookItem(
                    "Quizzes", quizCategory, 84.6);

    /** The final exam. */
    GradebookItem finalExam =
            new GradebookItem(
                    "Final", finalCategory, 70);

    /** The default grading. */
    DefaultGrading defaultGrading =
            new DefaultGrading();

    /** The gradebook items. */
    ArrayList<GradebookItem> gradebookItems =
            new ArrayList<GradebookItem>();

    /**
     * Test create.
     */
    @Test
    public
            void testCreate() {
        assertNotNull(
                "Grading creation failed.", defaultGrading);
    }

    /**
     * Test score calculation.
     */
    @Test
    public
            void testScoreCalculation() {
        gradebookItems
                .add(test1);
        gradebookItems
                .add(test2);
        gradebookItems
                .add(test3);
        gradebookItems
                .add(quizzes);
        gradebookItems
                .add(finalExam);
        defaultGrading
                .addGradebookItems(gradebookItems);
        double score =
                defaultGrading
                        .calculateScore();
        assertEquals(
                78.68, score, 0.00);
        assertEquals(
                "A", defaultGrading.calculateLetterGrade(92));
        assertEquals(
                "B", defaultGrading.calculateLetterGrade(83));
        assertEquals(
                "C", defaultGrading.calculateLetterGrade(75));
        assertEquals(
                "D", defaultGrading.calculateLetterGrade(64));
        assertEquals(
                "F", defaultGrading.calculateLetterGrade(35));
    }
}

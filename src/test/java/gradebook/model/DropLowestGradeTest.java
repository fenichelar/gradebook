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
 * The Class DropLowestGradeTest.
 *
 * @author Alec Fenichel
 */

@RunWith(JUnit4.class)
public class DropLowestGradeTest {

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
    GradebookCategory finalExamCategory =
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
                    "Final", finalExamCategory, 70);

    /** The drop lowest grade. */
    DropLowestGrade dropLowestGrade =
            new DropLowestGrade();

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
                "Grading creation failed.", dropLowestGrade);
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
        dropLowestGrade
                .addGradebookItems(gradebookItems);
        double score =
                dropLowestGrade
                        .calculateScore();
        assertEquals(
                81.2, score, 0.00);
    }

    /**
     * Test no score calculation.
     */
    @Test
    public
            void testNoScoreCalculation() {
        gradebookItems
                .clear();
        gradebookItems
                .add(test1);
        dropLowestGrade =
                new DropLowestGrade();
        dropLowestGrade
                .addGradebookItems(gradebookItems);
        double score =
                dropLowestGrade
                        .calculateScore();
        assertEquals(
                43.96, score, 0.00);
        score =
                dropLowestGrade
                        .calculateScore();
        assertEquals(
                43.96, score, 0.00);
    }
}

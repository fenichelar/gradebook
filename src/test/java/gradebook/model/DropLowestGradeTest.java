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

    /** The tests. */
    private GradebookCategory tests =
            new GradebookCategory(
                    "Tests", .51);

    /** The quiz category. */
    private GradebookCategory quizCategory =
            new GradebookCategory(
                    "Quizzes", .17);

    /** The final exam category. */
    private GradebookCategory finalExamCategory =
            new GradebookCategory(
                    "Final", .32);

    /** The test1. */
    private GradebookItem test1 =
            new GradebookItem(
                    "Test 1", tests, 86.2);

    /** The test2. */
    private GradebookItem test2 =
            new GradebookItem(
                    "Test 2", tests, 72.23);

    /** The test3. */
    private GradebookItem test3 =
            new GradebookItem(
                    "Test 3", tests, 88);

    /** The quizzes. */
    private GradebookItem quizzes =
            new GradebookItem(
                    "Quizzes", quizCategory, 84.6);

    /** The final exam. */
    private GradebookItem finalExam =
            new GradebookItem(
                    "Final", finalExamCategory, 70);

    /** The drop lowest grade. */
    private DropLowestGrade dropLowestGrade =
            new DropLowestGrade();

    /** The gradebook items. */
    private ArrayList<GradebookItem> gradebookItems =
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

    /**
     * Letter grade calculation.
     */
    @Test
    public
            void letterGradeCalculation() {
        assertEquals(
                "A", dropLowestGrade.calculateLetterGrade(92));
        assertEquals(
                "B", dropLowestGrade.calculateLetterGrade(83));
        assertEquals(
                "C", dropLowestGrade.calculateLetterGrade(75));
        assertEquals(
                "D", dropLowestGrade.calculateLetterGrade(64));
        assertEquals(
                "F", dropLowestGrade.calculateLetterGrade(35));
    }

    public
            GradebookCategory getTests() {
        return tests;
    }

    public
            void setTests(
                    GradebookCategory tests) {
        this.tests =
                tests;
    }

    public
            GradebookCategory getQuizCategory() {
        return quizCategory;
    }

    public
            void setQuizCategory(
                    GradebookCategory quizCategory) {
        this.quizCategory =
                quizCategory;
    }

    public
            GradebookCategory getFinalExamCategory() {
        return finalExamCategory;
    }

    public
            void setFinalExamCategory(
                    GradebookCategory finalExamCategory) {
        this.finalExamCategory =
                finalExamCategory;
    }

    public
            GradebookItem getTest1() {
        return test1;
    }

    public
            void setTest1(
                    GradebookItem test1) {
        this.test1 =
                test1;
    }

    public
            GradebookItem getTest2() {
        return test2;
    }

    public
            void setTest2(
                    GradebookItem test2) {
        this.test2 =
                test2;
    }

    public
            GradebookItem getTest3() {
        return test3;
    }

    public
            void setTest3(
                    GradebookItem test3) {
        this.test3 =
                test3;
    }

    public
            GradebookItem getQuizzes() {
        return quizzes;
    }

    public
            void setQuizzes(
                    GradebookItem quizzes) {
        this.quizzes =
                quizzes;
    }

    public
            GradebookItem getFinalExam() {
        return finalExam;
    }

    public
            void setFinalExam(
                    GradebookItem finalExam) {
        this.finalExam =
                finalExam;
    }

    public
            DropLowestGrade getDropLowestGrade() {
        return dropLowestGrade;
    }

    public
            void setDropLowestGrade(
                    DropLowestGrade dropLowestGrade) {
        this.dropLowestGrade =
                dropLowestGrade;
    }

    public
            ArrayList<GradebookItem> getGradebookItems() {
        return gradebookItems;
    }

    public
            void setGradebookItems(
                    ArrayList<GradebookItem> gradebookItems) {
        this.gradebookItems =
                gradebookItems;
    }
}

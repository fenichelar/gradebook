/*
 * CS 2340 Final Project
 * Gradebook
 * By Alec Fenichel
 */
package gradebook.model;

import java.util.ArrayList;

/**
 * The Class Student.
 *
 * @author Alec Fenichel
 */
public class Student {

    /** The name. */
    private String name;

    /** The gradebook items. */
    private ArrayList<GradebookItem> gradebookItems =
            new ArrayList<GradebookItem>();

    /** The score. */
    private double score;

    /** The letter grade. */
    private String letterGrade;

    /**
     * Instantiates a new student.
     *
     * @param aName the a name
     */
    public Student(
            String aName) {
        name =
                aName;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public
            String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public
            void setName(
                    String name) {
        this.name =
                name;
    }

    /**
     * Gets the gradebook items.
     *
     * @return the gradebook items
     */
    public
            ArrayList<GradebookItem> getGradebookItems() {
        return gradebookItems;
    }

    /**
     * Adds the gradebook item.
     *
     * @param gradebookItem the gradebook item
     */
    public
            void addGradebookItem(
                    GradebookItem gradebookItem) {
        gradebookItems
                .add(gradebookItem);
    }

    /**
     * Calculate score.
     *
     * @param gradingScheme the grading scheme
     * @return the double
     */
    public
            double calculateScore(
                    GradingScheme gradingScheme) {
        gradingScheme
                .addGradebookItems(gradebookItems);
        score =
                gradingScheme
                        .calculateScore();
        return score;
    }

    /**
     * Calculate letter grade.
     *
     * @param gradingScheme the grading scheme
     * @return the string
     */
    public
            String calculateLetterGrade(
                    GradingScheme gradingScheme) {
        score =
                calculateScore(gradingScheme);
        letterGrade =
                gradingScheme
                        .calculateLetterGrade(score);
        return letterGrade;
    }
}

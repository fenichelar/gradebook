/*
 * CS 2340 Final Project
 * Gradebook
 * By Alec Fenichel
 */
package gradebook.model;

import java.util.ArrayList;

/**
 * The Interface GradingScheme.
 *
 * @author Alec Fenichel
 */

public interface GradingScheme {

    /** The a cutoff. */
    double A_CUTOFF =
            90.0;

    /** The b cutoff. */
    double B_CUTOFF =
            80.0;

    /** The c cutoff. */
    double C_CUTOFF =
            70.0;

    /** The d cutoff. */
    double D_CUTOFF =
            60.0;

    /**
     * Adds the gradebook items.
     *
     * @param gradebookItems the gradebook items
     */
            void addGradebookItems(
                    ArrayList<GradebookItem> gradebookItems);

    /**
     * Calculate score.
     *
     * @return the double
     */
            double calculateScore();

    /**
     * Calculate letter grade.
     *
     * @param score the score
     * @return the string
     */
            String calculateLetterGrade(
                    double score);
}

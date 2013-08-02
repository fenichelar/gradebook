/*
 * CS 2340 Final Project
 * Gradebook
 * By Alec Fenichel
 */
package gradebook.model;

import java.util.ArrayList;

/**
 * The Class DropLowestGrade.
 *
 * @author Alec Fenichel
 */

public class DropLowestGrade
        extends DefaultGrading
        implements GradingScheme {

    /** The gradebook items. */
    private ArrayList<GradebookItem> gradebookItems;

    /** The final score. */
    private double finalScore;

    /** The letter grade. */
    private String letterGrade;

    /** The have not dropped. */
    private boolean haveNotDropped =
            true;

    /**
     * Adds the gradebook items.
     *
     * @param aGradebookItems the a gradebook items
     */
    @Override
    public
            void addGradebookItems(
                    ArrayList<GradebookItem> aGradebookItems) {
        gradebookItems =
                aGradebookItems;
    }

    /**
     * Drop lowest grade.
     */
    public
            void dropLowestGrade() {
        if (gradebookItems
                .size() > 1) {
            int lowestGradeIndex =
                    0;
            for (int i =
                    1; i < gradebookItems
                    .size(); i++) {
                GradebookCategory currentCategory =
                        gradebookItems
                                .get(i).getGradebookCategory();
                if (checkIfDropEligible(currentCategory)) {
                    if (gradebookItems
                            .get(i).getScore() < gradebookItems
                            .get(lowestGradeIndex).getScore()) {
                        lowestGradeIndex =
                                i;
                    }
                }
            }
            gradebookItems
                    .remove(lowestGradeIndex);
        }
    }

    /**
     * Calculate score.
     *
     * @return the double
     */
    @Override
    public
            double calculateScore() {
        if (haveNotDropped) {
            dropLowestGrade();
            haveNotDropped =
                    false;
        }
        super.addGradebookItems(gradebookItems);
        finalScore =
                super.calculateScore();
        return finalScore;
    }

    /**
     * Calculate letter grade.
     *
     * @param score the score
     * @return the string
     */
    @Override
    public
            String calculateLetterGrade(
                    double score) {
        if (score >= GradingScheme.A_CUTOFF) {
            letterGrade =
                    "A";
        } else if (score >= GradingScheme.B_CUTOFF) {
            letterGrade =
                    "B";
        } else if (score >= GradingScheme.C_CUTOFF) {
            letterGrade =
                    "C";
        } else if (score >= GradingScheme.D_CUTOFF) {
            letterGrade =
                    "D";
        } else {
            letterGrade =
                    "F";
        }
        return letterGrade;
    }

    /**
     * Check if drop eligible.
     *
     * @param gradebookCategory the gradebook category
     * @return true, if successful
     */
    public
            boolean checkIfDropEligible(
                    GradebookCategory gradebookCategory) {
        int counter =
                0;
        boolean result =
                false;
        for (int i =
                0; i < gradebookItems
                .size(); i++) {
            if (gradebookItems
                    .get(i).getGradebookCategory() == gradebookCategory) {
                counter++;
                if (counter > 1) {
                    result =
                            true;
                }
            }
        }
        return result;
    }
}

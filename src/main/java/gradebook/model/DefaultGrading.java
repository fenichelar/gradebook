/*
 * CS 2340 Final Project
 * Gradebook
 * By Alec Fenichel
 */
package gradebook.model;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * The Class DefaultGrading.
 *
 * @author Alec Fenichel
 */

public class DefaultGrading
        implements GradingScheme {

    /** The gradebook items. */
    private ArrayList<GradebookItem> gradebookItems;

    /** The final score. */
    private double finalScore;

    /** The letter grade. */
    private String letterGrade;

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
     * Calculate score.
     *
     * @return the double
     */
    @Override
    public
            double calculateScore() {
        ArrayList<GradebookCategory> categoriesCalculated =
                new ArrayList<GradebookCategory>();
        double score =
                0;
        double categoryScore;
        double categoryWeight;
        GradebookCategory currentCategory;
        GradebookItem currentItem;
        for (int i =
                0; i < gradebookItems
                .size(); i++) {
            currentItem =
                    gradebookItems
                            .get(i);
            currentCategory =
                    currentItem
                            .getGradebookCategory();
            if (!categoriesCalculated
                    .contains(currentCategory)) {
                categoryScore =
                        getCategoryAverage(currentCategory);
                categoryWeight =
                        currentCategory
                                .getPercentWeight();
                score +=
                        categoryScore
                                * categoryWeight;
                categoriesCalculated
                        .add(currentCategory);
            }
        }
        finalScore =
                Double.parseDouble(new DecimalFormat(
                        "#.##")
                        .format(score));
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
     * Gets the category average.
     *
     * @param category the category
     * @return the category average
     */
    public
            double getCategoryAverage(
                    GradebookCategory category) {
        GradebookItem currentItem;
        GradebookCategory currentCategory =
                category;
        double runningTotal =
                0;
        double counter =
                0;
        for (int i =
                0; i < gradebookItems
                .size(); i++) {
            currentItem =
                    gradebookItems
                            .get(i);
            if (currentItem
                    .getGradebookCategory() == currentCategory) {
                runningTotal +=
                        currentItem
                                .getScore();
                counter++;
            }
        }
        return runningTotal
                / counter;
    }
}

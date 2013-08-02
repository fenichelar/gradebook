/*
 * CS 2340 Final Project
 * Gradebook
 * By Alec Fenichel
 */
package gradebook.model;

/**
 * The Class GradebookItem.
 *
 * @author Alec Fenichel
 */

public class GradebookItem {

    /** The name. */
    private String name;

    /** The gradebook category. */
    private GradebookCategory gradebookCategory;

    /** The score. */
    private double score;

    /**
     * Instantiates a new gradebook item.
     *
     * @param name the name
     * @param gradebookCategory the gradebook category
     * @param score the score
     */
    public GradebookItem(
            String name, GradebookCategory gradebookCategory, double score) {
        this.name =
                name;
        this.gradebookCategory =
                gradebookCategory;
        this.score =
                score;
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
     * Gets the gradebook category.
     *
     * @return the gradebook category
     */
    public
            GradebookCategory getGradebookCategory() {
        return gradebookCategory;
    }

    /**
     * Sets the gradebook category.
     *
     * @param aGradebookCategory the new gradebook category
     */
    public
            void setGradebookCategory(
                    GradebookCategory aGradebookCategory) {
        gradebookCategory =
                aGradebookCategory;
    }

    /**
     * Gets the score.
     *
     * @return the score
     */
    public
            double getScore() {
        return score;
    }

    /**
     * Sets the score.
     *
     * @param score the new score
     */
    public
            void setScore(
                    double score) {
        this.score =
                score;
    }
}

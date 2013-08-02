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
     * @param aName the a name
     * @param aGradebookCategory the a gradebook category
     * @param aScore the a score
     */
    public GradebookItem(
            String aName, GradebookCategory aGradebookCategory, double aScore) {
        name =
                aName;
        gradebookCategory =
                aGradebookCategory;
        score =
                aScore;
    }

    /**
     * Instantiates a new gradebook item.
     *
     * @param aName the a name
     * @param aGradebookCategory the a gradebook category
     * @param aScore the a score
     */
    public GradebookItem(
            String aName, GradebookCategory aGradebookCategory, int aScore) {
        name =
                aName;
        gradebookCategory =
                aGradebookCategory;
        score =
                aScore;
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
     * @param aName the new name
     */
    public
            void setName(
                    String aName) {
        name =
                aName;
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
     * @param aScore the new score
     */
    public
            void setScore(
                    double aScore) {
        score =
                aScore;
    }
}

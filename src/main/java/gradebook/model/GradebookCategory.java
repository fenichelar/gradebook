/*
 * CS 2340 Final Project
 * Gradebook
 * By Alec Fenichel
 */
package gradebook.model;

/**
 * The Class GradebookCategory.
 *
 * @author Alec Fenichel
 */

public class GradebookCategory {

    /** The name. */
    private String name;

    /** The percent weight. */
    private double percentWeight;

    /**
     * Instantiates a new gradebook category.
     *
     * @param aName the a name
     * @param aPercentWeight the a percent weight
     */
    public GradebookCategory(
            String aName, double aPercentWeight) {
        name =
                aName;
        percentWeight =
                aPercentWeight;
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
     * Gets the percent weight.
     *
     * @return the percent weight
     */
    public
            double getPercentWeight() {
        return percentWeight;
    }

    /**
     * Sets the percent weight.
     *
     * @param aPercentWeight the new percent weight
     */
    public
            void setPercentWeight(
                    double aPercentWeight) {
        percentWeight =
                aPercentWeight;
    }
}

/*
 * CS 2340 Final Project
 * Gradebook
 * By Alec Fenichel
 */
package gradebook.model;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * The Class Class.
 *
 * @author Alec Fenichel
 */

public class Class
        extends Course {

    /** The semester. */
    private String semester;

    /** The course. */
    private final Course course;

    /** The sections. */
    private ArrayList<Section> sections =
            new ArrayList<Section>();

    /** The letter grade. */
    private String letterGrade;

    /** The average score. */
    private double averageScore;

    /**
     * Instantiates a new class.
     *
     * @param course the course
     * @param semester the semester
     */
    public Class(
            Course course, String semester) {
        super(
                course.getSubject(), course
                        .getCourseNumber(), course
                        .getCourseName(), course
                        .getPrerequisites());
        this.course =
                course;
        this.semester =
                semester;
    }

    /**
     * Gets the course.
     *
     * @return the course
     */
    public
            Course getCourse() {
        return course;
    }

    /**
     * Gets the semester.
     *
     * @return the semester
     */
    public
            String getSemester() {
        return semester;
    }

    /**
     * Sets the semester.
     *
     * @param semester the new semester
     */
    public
            void setSemester(
                    String semester) {
        this.semester =
                semester;
    }

    /**
     * Adds the section.
     *
     * @param section the section
     */
    public
            void addSection(
                    Section section) {
        sections.add(section);
    }

    /**
     * Gets the sections.
     *
     * @return the sections
     */
    public
            ArrayList<Section> getSections() {
        return sections;
    }

    /**
     * Calculate average score.
     *
     * @param gradingScheme the grading scheme
     * @return the double
     */
    @Override
    public
            double calculateAverageScore(
                    GradingScheme gradingScheme) {
        double sum =
                0;
        for (int i =
                0; i < sections
                .size(); i++) {
            sum +=
                    sections.get(
                            i).calculateAverageScore(
                            gradingScheme);
        }
        averageScore =
                sum
                        / sections
                                .size();
        averageScore =
                Double.parseDouble(new DecimalFormat(
                        "#.##")
                        .format(averageScore));
        return averageScore;
    }

    /**
     * Calculate letter grade.
     *
     * @param gradingScheme the grading scheme
     * @return the string
     */
    @Override
    public
            String calculateLetterGrade(
                    GradingScheme gradingScheme) {
        averageScore =
                calculateAverageScore(gradingScheme);
        letterGrade =
                gradingScheme
                        .calculateLetterGrade(averageScore);
        return letterGrade;
    }
}

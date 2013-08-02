/*
 * CS 2340 Final Project
 * Gradebook
 * By Alec Fenichel
 */
package gradebook.model;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * The Class Course.
 *
 * @author Alec Fenichel
 */

public class Course {

    /** The subject. */
    private String subject;

    /** The course number. */
    private int courseNumber;

    /** The course name. */
    private String courseName;

    /** The prerequisites. */
    private ArrayList<Course> prerequisites;

    /** The score calculated. */
    private boolean scoreCalculated =
            false;

    /** The letter grade. */
    private String letterGrade;

    /** The average score. */
    private double averageScore;

    /** The classes. */
    private ArrayList<Class> classes =
            new ArrayList<Class>();

    /**
     * Instantiates a new course.
     *
     * @param subject the subject
     * @param courseNumber the course number
     * @param courseName the course name
     */
    public Course(
            String subject, int courseNumber, String courseName) {
        this.subject =
                subject;
        this.courseNumber =
                courseNumber;
        this.courseName =
                courseName;
    }

    /**
     * Instantiates a new course.
     *
     * @param subject the subject
     * @param courseNumber the course number
     * @param courseName the course name
     * @param prerequisites the prerequisites
     */
    public Course(
            String subject, int courseNumber, String courseName,
            ArrayList<Course> prerequisites) {
        this.subject =
                subject;
        this.courseNumber =
                courseNumber;
        this.courseName =
                courseName;
        this.prerequisites =
                prerequisites;
    }

    /**
     * Gets the subject.
     *
     * @return the subject
     */
    public
            String getSubject() {
        return subject;
    }

    /**
     * Sets the subject.
     *
     * @param subject the new subject
     */
    public
            void setSubject(
                    String subject) {
        this.subject =
                subject;
    }

    /**
     * Gets the course number.
     *
     * @return the course number
     */
    public
            int getCourseNumber() {
        return courseNumber;
    }

    /**
     * Sets the course number.
     *
     * @param courseNumber the new course number
     */
    public
            void setCourseNumber(
                    int courseNumber) {
        this.courseNumber =
                courseNumber;
    }

    /**
     * Gets the course name.
     *
     * @return the course name
     */
    public
            String getCourseName() {
        return courseName;
    }

    /**
     * Sets the course name.
     *
     * @param courseName the new course name
     */
    public
            void setCourseName(
                    String courseName) {
        this.courseName =
                courseName;
    }

    /**
     * Gets the prerequisites.
     *
     * @return the prerequisites
     */
    public
            ArrayList<Course> getPrerequisites() {
        return prerequisites;
    }

    /**
     * Sets the prerequisites.
     *
     * @param prerequisites the new prerequisites
     */
    public
            void setPrerequisites(
                    ArrayList<Course> prerequisites) {
        this.prerequisites =
                prerequisites;
    }

    /**
     * Adds the class.
     *
     * @param newClass the new class
     */
    public
            void addClass(
                    Class newClass) {
        classes.add(newClass);
    }

    /**
     * Gets the classes.
     *
     * @return the classes
     */
    public
            ArrayList<Class> getClasses() {
        return classes;
    }

    /**
     * Calculate average score.
     *
     * @param gradingScheme the grading scheme
     * @return the double
     */
    public
            double calculateAverageScore(
                    GradingScheme gradingScheme) {
        double sum =
                0;
        for (int i =
                0; i < classes
                .size(); i++) {
            sum +=
                    classes.get(
                            i).calculateAverageScore(
                            gradingScheme);
        }
        averageScore =
                sum
                        / classes
                                .size();
        averageScore =
                Double.parseDouble(new DecimalFormat(
                        "#.##")
                        .format(averageScore));
        scoreCalculated =
                true;
        return averageScore;
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
        if (scoreCalculated) {
            letterGrade =
                    gradingScheme
                            .calculateLetterGrade(averageScore);
        } else {
            averageScore =
                    calculateAverageScore(gradingScheme);
            letterGrade =
                    gradingScheme
                            .calculateLetterGrade(averageScore);
        }
        return letterGrade;
    }
}

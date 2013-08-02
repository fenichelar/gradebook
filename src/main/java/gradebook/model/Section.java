/*
 * CS 2340 Final Project
 * Gradebook
 * By Alec Fenichel
 */
package gradebook.model;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * The Class Section.
 *
 * @author Alec Fenichel
 */

public class Section
        extends Class {

    /** The section name. */
    private String sectionName;

    /** The parent class. */
    private Class parentClass;

    /** The students. */
    private ArrayList<Student> students =
            new ArrayList<Student>();

    /** The average score. */
    private double averageScore;

    /**
     * Instantiates a new section.
     *
     * @param sectionName the section name
     * @param parentClass the parent class
     */
    public Section(
            String sectionName, Class parentClass) {
        super(
                parentClass
                        .getCourse(), parentClass
                        .getSemester());
        this.sectionName =
                sectionName;
        this.parentClass =
                parentClass;
    }

    /**
     * Gets the section name.
     *
     * @return the section name
     */
    public
            String getSectionName() {
        return sectionName;
    }

    /**
     * Sets the section name.
     *
     * @param sectionName the new section name
     */
    public
            void setSectionName(
                    String sectionName) {
        this.sectionName =
                sectionName;
    }

    /**
     * Gets the parent class.
     *
     * @return the parent class
     */
    public
            Class getParentClass() {
        return parentClass;
    }

    /**
     * Sets the parent class.
     *
     * @param parentClass the new parent class
     */
    public
            void setParentClass(
                    Class parentClass) {
        this.parentClass =
                parentClass;
    }

    /**
     * Gets the students.
     *
     * @return the students
     */
    public
            ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Adds the student.
     *
     * @param newStudent the new student
     */
    public
            void addStudent(
                    Student newStudent) {
        students.add(newStudent);
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
                0; i < students
                .size(); i++) {
            sum +=
                    students.get(
                            i).calculateScore(
                            gradingScheme);
        }
        averageScore =
                sum
                        / students
                                .size();
        return Double
                .parseDouble(new DecimalFormat(
                        "#.##")
                        .format(averageScore));
    }

}

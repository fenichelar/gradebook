/*
 * CS 2340 Final Project
 * Gradebook
 * By Alec Fenichel
 */
package gradebook.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * The Class CourseTest.
 *
 * @author Alec Fenichel
 */

@RunWith(JUnit4.class)
public class CourseTest {

    /** The prerequisites. */
    private ArrayList<Course> prerequisites =
            new ArrayList<Course>();

    /** The course. */
    private Course course =
            new Course(
                    "CS", 2340, "Objects and Design", prerequisites);

    /** The class one. */
    private Class classOne =
            new Class(
                    course, "Summer 2013");

    /** The class two. */
    private Class classTwo =
            new Class(
                    course, "Summer 2013");

    /** The gradebook category. */
    private GradebookCategory gradebookCategory =
            new GradebookCategory(
                    "Test", 1);

    /** The new student. */
    private Student newStudent =
            new Student(
                    "Alec Fenichel");

    /** The new student2. */
    private Student newStudent2 =
            new Student(
                    "John Doe");

    /** The new student3. */
    private Student newStudent3 =
            new Student(
                    "Jane Doe");

    /** The new student4. */
    private Student newStudent4 =
            new Student(
                    "Jack Doe");

    /** The new student5. */
    private Student newStudent5 =
            new Student(
                    "Jessica Doe");

    /** The section. */
    private Section section =
            new Section(
                    "A", classOne);

    /** The section2. */
    private Section section2 =
            new Section(
                    "B", classTwo);

    /**
     * Test averages.
     */
    @Test
    public
            void testAverages() {
        newStudent
                .addGradebookItem(new GradebookItem(
                        "Test 1", gradebookCategory, 100));
        newStudent
                .addGradebookItem(new GradebookItem(
                        "Test 2", gradebookCategory, 20));
        newStudent2
                .addGradebookItem(new GradebookItem(
                        "Test 1", gradebookCategory, 85));
        newStudent2
                .addGradebookItem(new GradebookItem(
                        "Test 2", gradebookCategory, 90));
        newStudent3
                .addGradebookItem(new GradebookItem(
                        "Test 1", gradebookCategory, 90));
        newStudent3
                .addGradebookItem(new GradebookItem(
                        "Test 2", gradebookCategory, 85));
        newStudent4
                .addGradebookItem(new GradebookItem(
                        "Test 1", gradebookCategory, 85));
        newStudent4
                .addGradebookItem(new GradebookItem(
                        "Test 2", gradebookCategory, 85));
        newStudent5
                .addGradebookItem(new GradebookItem(
                        "Test 1", gradebookCategory, 85));
        newStudent5
                .addGradebookItem(new GradebookItem(
                        "Test 2", gradebookCategory, 75));
        section.addStudent(newStudent);
        section.addStudent(newStudent2);
        section.addStudent(newStudent3);
        section2.addStudent(newStudent4);
        section2.addStudent(newStudent5);
        classOne.addSection(section);
        classTwo.addSection(section2);
        course.addClass(classOne);
        course.addClass(classTwo);
        ArrayList<Course> classes =
                new ArrayList<Course>();
        classes.add(classOne);
        classes.add(classTwo);
        assertEquals(
                classes, course.getClasses());
        GradingScheme defaultGrading =
                new DefaultGrading();
        String letterGrade =
                course.calculateLetterGrade(defaultGrading);
        assertEquals(
                "LetterGrade calculation failed.", "B", letterGrade);
        double averageScore =
                course.calculateAverageScore(defaultGrading);
        assertEquals(
                80.41, averageScore, 0.00);
    }

    /**
     * Test get and create.
     */
    @Test
    public
            void testGetAndCreate() {
        assertNotNull(
                "Course creation test failed.", course);
        String subject =
                course.getSubject();
        int courseNumber =
                course.getCourseNumber();
        String courseName =
                course.getCourseName();
        ArrayList<Course> retreievedPrereqs =
                course.getPrerequisites();
        assertEquals(
                "CS", subject);
        assertEquals(
                2340, courseNumber);
        assertEquals(
                "Objects and Design", courseName);
        assertSame(
                prerequisites, retreievedPrereqs);
    }

    /**
     * Test setters.
     */
    @Test
    public
            void testSetters() {
        course.setSubject("ECE");
        course.setCourseNumber(3710);
        course.setCourseName("Linear Circuits");
        prerequisites
                .add(new Course(
                        "MATH", 1501, "Calculus I"));
        course.setPrerequisites(prerequisites);
        String subject =
                course.getSubject();
        int courseNumber =
                course.getCourseNumber();
        String courseName =
                course.getCourseName();
        ArrayList<Course> retreievedPrereqs =
                course.getPrerequisites();
        assertEquals(
                "setSubject test failed.", "ECE", subject);
        assertEquals(
                "setCourseNumber test failed.", 3710, courseNumber);
        assertEquals(
                "setCouseName test failed.", "Linear Circuits", courseName);
        assertSame(
                "setPrerequisites test failed.", prerequisites,
                retreievedPrereqs);
    }

    public
            ArrayList<Course> getPrerequisites() {
        return prerequisites;
    }

    public
            void setPrerequisites(
                    ArrayList<Course> prerequisites) {
        this.prerequisites =
                prerequisites;
    }

    public
            Course getCourse() {
        return course;
    }

    public
            void setCourse(
                    Course course) {
        this.course =
                course;
    }

    public
            Class getClassOne() {
        return classOne;
    }

    public
            void setClassOne(
                    Class classOne) {
        this.classOne =
                classOne;
    }

    public
            Class getClassTwo() {
        return classTwo;
    }

    public
            void setClassTwo(
                    Class classTwo) {
        this.classTwo =
                classTwo;
    }

    public
            GradebookCategory getGradebookCategory() {
        return gradebookCategory;
    }

    public
            void setGradebookCategory(
                    GradebookCategory gradebookCategory) {
        this.gradebookCategory =
                gradebookCategory;
    }

    public
            Student getNewStudent() {
        return newStudent;
    }

    public
            void setNewStudent(
                    Student newStudent) {
        this.newStudent =
                newStudent;
    }

    public
            Student getNewStudent2() {
        return newStudent2;
    }

    public
            void setNewStudent2(
                    Student newStudent2) {
        this.newStudent2 =
                newStudent2;
    }

    public
            Student getNewStudent3() {
        return newStudent3;
    }

    public
            void setNewStudent3(
                    Student newStudent3) {
        this.newStudent3 =
                newStudent3;
    }

    public
            Student getNewStudent4() {
        return newStudent4;
    }

    public
            void setNewStudent4(
                    Student newStudent4) {
        this.newStudent4 =
                newStudent4;
    }

    public
            Student getNewStudent5() {
        return newStudent5;
    }

    public
            void setNewStudent5(
                    Student newStudent5) {
        this.newStudent5 =
                newStudent5;
    }

    public
            Section getSection() {
        return section;
    }

    public
            void setSection(
                    Section section) {
        this.section =
                section;
    }

    public
            Section getSection2() {
        return section2;
    }

    public
            void setSection2(
                    Section section2) {
        this.section2 =
                section2;
    }
}

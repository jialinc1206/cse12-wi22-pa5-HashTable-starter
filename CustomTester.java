/**
 * Name: Jialin Chen
 * Email: jic053@ucsd.edu
 * Sources used: None
 * 
 * Custom test cases for Student Class, Course Class,
 * and Sanctuary Class
 */

import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * include Custom test cases that are not included in the
 * PublicTester.java
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {

    // ----------------Student class----------------
    /**
     * Test the equals method when two student objects are not the same
     */
    @Test
    public void testEquals() {
        Student st1 = new Student(new String("Test"), 
            new String("Student"), new String("A12345678"));
        Student st2 = new Student(new String("Test"), 
            new String("Student"), new String("A87654321"));
        Student st3 = new Student(new String("Test"), 
            new String("Student1"), new String("A12345678"));
        Student st4 = new Student(new String("Test1"), 
            new String("Student"), new String("A12345678"));
        assertFalse(st1.equals(st2));
        assertFalse(st1.equals(st3));
        assertFalse(st1.equals(st4));
    }

    /**
     * Test the compareTo method when student objects are the same
     */
    @Test
    public void testCompareTo() {
        Student st1 = new Student(new String("Test"), 
            new String("Student"), new String("A12345678"));
        Student st2 = new Student(new String("Test"), 
            new String("Student"), new String("A12345678"));
        assertEquals(0, st1.compareTo(st2));
    }

    // ----------------Course class----------------
    /**
     * Test the enroll method when student is null
     */
    @Test
    public void testEnroll() {
        Student st1 = null;
        Course course = new Course("life", "001", "hi", 1);
        try {
            course.enroll(st1);
        } catch (Exception e) {
            System.out.println("exception thrown @ testEnroll");
        }
    }

    /**
     * Test the unenroll method when student is null
     */
    @Test
    public void testUnenroll() {
        Student st1 = null;
        Course course = new Course("life", "001", "hi", 1);
        try {
            course.unenroll(st1);
        } catch (Exception e) {
            System.out.println("exception thrown @ testUnenroll");
        }
    }

    /**
     * Test the getRoster method when enrolled has 
     * two non-null students
     */
    @Test
    public void testGetRoster() {
        Student st1 = new Student(new String("Test"), 
            new String("Student"), new String("A12345678"));
        Student st2 = new Student(new String("Test"), 
            new String("Student"), new String("A87654321"));
        
        Course course = new Course("life", "001", "hi", 5);
        course.enroll(st1);
        course.enroll(st2);

        ArrayList<Student> arr = new ArrayList<Student>();
        arr.add(st2);
        arr.add(st1);

        assertEquals(arr, course.getRoster());
    }

    // ----------------Sanctuary class----------------
    /**
     * Test the constructor when argument isn't valid
     */
    @Test
    public void testSanctuaryConstructor() {
        try {
            Sanctuary san = new Sanctuary(-1, -1);
        } catch (Exception e) {
            System.out.println("exception thrown @ testSanctuaryConstructor");
        }
    }

    /**
     * Test the rescue method when adding a new species of animals
     * to a full sanctuary
     */
    @Test
    public void testRescueTestOne(){
        Sanctuary san = new Sanctuary(0, 0);
        assertEquals(10, san.rescue("human", 10));
    }

    /**
     * Test the rescue method when adding a new species of animals
     * that would overload animal sanctuary
     */
    @Test
    public void testRescueTestTwo(){
        Sanctuary san = new Sanctuary(5, 2);
        assertEquals(5, san.rescue("human", 10));
    }

    /**
     * Test the release method when species doesn't exist
     */
    @Test
    public void testReleaseTestOne(){
        Sanctuary san = new Sanctuary(5, 2);
        try {
            san.release("human", 1);
        } catch (Exception e) {
            System.out.println("exception thrown @ testReleaseTestOne");
        }
    }

    /**
     * Test the release method when one species is completely released.
     */
    @Test
    public void testReleaseTestTwo(){
        Sanctuary san = new Sanctuary(5, 2);
        san.rescue("human", 3);
        san.release("human", 3);
        assertFalse(san.sanctuary.containsKey("human"));
    }
}


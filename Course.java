/**
 * Name: Jialin Chen
 * Email: jic053@ucsd.edu
 * Sources used: None
 * 
 * This file implements the course class used to
 * store different variable for a class.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Our Course class will help us store the students registered 
 * for this particular course in the form of a HashSet.
 */
public class Course {
    HashSet<Student> enrolled;
    private final int capacity;
    private final String department;
    private final String number;
    private final String description;

    /**
     * Initialize the course’s information 
     * with an initial enrollment of 0 students.
     * @param department This course falls under this department.
     * @param number This course falls under this department.
     * @param description This is the description of the course.
     * @param capacity This is the maximum number of students 
     * that can be enrolled in this course.
     */
    public Course(String department, String number, String description, 
        int capacity){
            if(department == null || number == null || description == null)
                throw new IllegalArgumentException();
            if(capacity <= 0)
                throw new IllegalArgumentException();

            this.department = department;
            this.number = number;
            this.description = description;
            this.capacity = capacity;
            enrolled = new HashSet<Student>();
        }

    /**
     * Return the department name
     * @return the department name
     */
    public String getDepartment(){
        return department;
    }

    /**
     * Return the course number
     * @return the course number
     */
    public String getNumber(){
        return number;
    }

    /**
     * Return the description of the course.
     * @return the description of the course.
     */
    public String getDescription(){
        return description;
    }

    /**
     * Return the capacity of the course.
     * @return the capacity of the course.
     */
    public int getCapacity(){
        return capacity;
    }

    /**
     * add the student to the course
     * @param student student to be enrolled.
     * @return true for a successful enrollment and false otherwise.
     */
    public boolean enroll(Student student) {
        if(student == null)
            throw new IllegalArgumentException();
        
        // check if here is room in this course and 
        // the student is not currently enrolled first
        if(enrolled.size() < capacity)
            if(!enrolled.contains(student)) {
                enrolled.add(student);
                return true;
            }
        return false;
    }

    /**
     * remove student from the course
     * @param student student to be remove
     * @return true for a successful unenrollment and false otherwise. 
     */
    public boolean unenroll(Student student) {
        if(student == null)
            throw new IllegalArgumentException();

        return enrolled.remove(student);
    }

    /**
     * Remove all the students from the course.
     */
    public void cancel() {
        enrolled.clear();
    }

    /**
     * If the course is at its capacity, return true. 
     * Otherwise, return false.
     * @return whether course is at its capacity
     */
    public boolean isFull() {
        return enrolled.size() >= capacity;
    }

    /**
     * Return the current number of enrolled students.
     * @return the current number of enrolled students.
     */
    public int getEnrolledCount() {
        return enrolled.size();
    }

    /**
     * Return the number of students that can 
     * enroll in the course
     * @return the number of students that can still 
     * enroll in the course
     */
    public int getAvailableSeats() {
        return capacity - enrolled.size();
    }

    /**
     * Return a shallow copy of all the students 
     * enrolled in this course.
     * @return a shallow copy of all the students 
     * enrolled in this course.
     */
    public HashSet<Student> getStudents() {
        HashSet<Student> copy = new HashSet<Student>(enrolled);
        return copy;
    }

    /**
     * Turn the collection of enrolled students 
     * into an ArrayList collection
     * @return the final ArrayList
     */
    public ArrayList<Student> getRoster() {
        ArrayList<Student> arr = new ArrayList<Student>();

        // iterate through each student in the course
        // and add it's number together
        for(Student student : enrolled)
            arr.add(student);
        return arr;
    }

    /**
     * Return a string representation for a Course object.
     */
    public String toString() {
        return department + " " + number + " [" + capacity + 
        "]\n" + description;
    }
}


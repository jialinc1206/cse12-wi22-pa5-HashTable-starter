import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Course {
    HashSet<Student> enrolled;
    private final int capacity;
    private final String department;
    private final String number;
    private final String description;

    public Course(String department, String number, String description, int capacity){}

    public String getDepartment(){
        return null;
    }

    public String getNumber(){
        return null;
    }

    public String getDescription(){
        return null;
    }

    public int getCapacity(){
        return 0;
    }

    public boolean enroll(Student student) {
        return false;
    }

    public boolean unenroll(Student student) {
        return false;
    }

    public void cancel() {}

    public boolean isFull() {
        return false;
    }

    public int getEnrolledCount() {
        return 0;
    }

    public int getAvailableSeats() {
        return 0;
    }

    public HashSet<Student> getStudents() {
        return null;
    }

    public ArrayList<Student> getRoster() {
        return null;
    }

    public String toString() {
        return null;
    }
}


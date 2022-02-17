/**
 * Name: Jialin Chen
 * Email: jic053@ucsd.edu
 * Sources used: None
 * 
 * The student file instantiate student objects.
 * Student objects will be stored in Course objects.
 */
import java.util.Objects;

/**
 * The student class implement various methods
 * such getter methods to store and manipulate
 * various variables.
 */
public class Student implements Comparable<Student> {
    private final String firstName;
    private final String lastName;
    private final String PID;

    /**
     * Initialize the student’s information
     * @param firstName A string representing the first name of the student.
     * @param lastName A string representing the last name of the student.
     * @param PID A string representing the PID of the student. 
     */
    public Student(String firstName, String lastName, String PID) {
        if(firstName == null || lastName == null || PID == null)
            throw new IllegalArgumentException();

        this.firstName = firstName;
        this.lastName = lastName;
        this.PID = PID;
    }

    /**
     * Return the student’s last name
     * @return the student’s last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Return the student’s first name
     * @return the student’s first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Return the student’s PID
     * @return the student’s PID
     */
    public String getPID() {
        return PID;
    }

    /**
     * Returns true if o is also a non-null Student and 
     * all the instance variables of o equal the instance variable 
     * of the current Student object.
     * @param o object being compared
     * @return whether both student are equal
     */
    @Override
    public boolean equals(Object o) {
        return ((Student)o).getFirstName().equals(firstName) &&
        ((Student)o).getLastName().equals(lastName) &&
        ((Student)o).getPID().equals(PID);
    }

    /**
     * @return the hash value generated by Object’s hash function.
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, PID);
    }

    /**
     * Returns 0 if all the instance variables are equivalent. 
     * Returns a negative value if the current object lexicographically 
     * comes before Student o. 
     * Returns a positive value if the current object lexicographically 
     * comes after Student o.
     * @param o object being compared
     * @return compare result
     */
    @Override
    public int compareTo(Student o) {
        if(lastName.compareTo(o.getLastName()) != 0)
            return lastName.compareTo(o.getLastName());
        if(firstName.compareTo(o.getFirstName()) != 0)
            return firstName.compareTo(o.getFirstName());
        return PID.compareTo(o.getPID());
    }
}

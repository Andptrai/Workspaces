
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Enrolling {
    private List<CL> classes; // List of classes
    Scanner input = new Scanner(System.in);

    public Enrolling() {
        this.classes = new ArrayList<>(); // Initialize the list of classes
    }

    public List<CL> getClasses() {
        return classes;
    }

    public void setClasses(List<CL> classes) {
        this.classes = classes;
    }

    public void enroll(Students student, CL cl) {
        cl.addToClass(student);
    }

    public void printEnrollments() {
        for (CL cl : classes) {
            System.out.println(cl.toString());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class CL {
    private int classID;
    private String course;
    private List<Students> students; // 

    public CL(int classID, String course) {
        this.classID = classID;
        this.course = course;
        this.students = new ArrayList<>(); // 
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public int getClassID() {
        return classID;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }
    
    public void addToClass(Students student) {
        students.add(student);
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Class ID: ").append(classID).append("\nCourse: ").append(course).append("\nStudents:\n");
        for (Students student : students) {
            stringBuilder.append(student.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}

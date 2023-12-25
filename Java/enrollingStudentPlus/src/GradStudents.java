
public class GradStudents extends Students {
    private String speciality;

    public GradStudents(int studentID, String firstName, String lastName, String promotion, String department, String speciality) {
        super(studentID, firstName, lastName, promotion, department);
        this.speciality = speciality;
        updateFullName();
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "ID: " + getStudentID() + "\nFullName: "
                + getFullName() + "\nPromotion: " + getPromotion()
                + "\nDepartment: " + getDepartment() + "\nMajor: " + speciality;
    }
}

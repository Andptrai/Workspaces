
public class UnderGradStudents extends Students {
	private String major;
	
	public UnderGradStudents(int studentID, String firstName, String lastName,
			String promotion, String department, String major) {
	    super(studentID, firstName, lastName, promotion, department);
	    this.setMajor(major);
	    updateFullName();
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public String toString () {
		return "ID: " + getStudentID() +"\nFullName: " 
	+ getFullName() + "\nPromotion: " + getPromotion() 
	+ "\nDepartment: " + getDepartment() + "\nMajor: " + major; 
	}
}

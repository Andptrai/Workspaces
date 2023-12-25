
public class Students {
	private int studentID;
	private String firstName;
	private String lastName;
	private String fullName;
	private String promotion; // khóa học
	private String department; // khoa
	
	public Students (int studentID,String firstName,String lastName,String promotion,String department){
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.promotion = promotion;
		this.department = department;
		this.fullName = "";
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getLastName() {
		return lastName;
		
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
		updateFullName();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		updateFullName();
	}
	public String getFullName() {
		return fullName;
	}

	  // Phương thức cập nhật fullName
    public void updateFullName() {
        this.fullName = firstName + " " + lastName;
    }
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}

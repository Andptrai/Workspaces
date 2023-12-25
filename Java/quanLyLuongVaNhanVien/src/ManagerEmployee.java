// Tạo một lớp ManagerEmployee kế thừa từ FullTimeEmployee và cài đặt interface Manager.
// Lớp này đại diện cho một nhân viên full-time có vai trò người quản lý với các thuộc tính:
public class ManagerEmployee extends FullTimeEmployee implements Manager {
  // Bộ phận quản lý.
  private String department;

  // Tạo một constructor với các tham số tương ứng.
  public ManagerEmployee(String name, String id, double baseSalary, int workingDays, String department) {
    // Gọi constructor của lớp cha FullTimeEmployee.
    super(name, id, baseSalary, workingDays);
    this.department = department;
  }

  // Cài đặt phương thức của interface Manager.
  @Override
  public String getDepartment() {
    return department;
  }

  // Tạo một phương thức toString để in ra thông tin của người quản lý.
  @Override
  public String toString() {
    return "ManagerEmployee{" +
        "name='" + getEmployeeName() + '\'' +
        ", id='" + getEmployeeID() + '\'' +
        ", baseSalary=" + calculateSalary() / getWorkingDays() +
        ", workingDays=" + getWorkingDays() +
        ", actualSalary=" + calculateSalary() +
        ", department='" + department + '\'' +
        '}';
  }
}

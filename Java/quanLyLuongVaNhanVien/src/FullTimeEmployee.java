// Tạo một lớp FullTimeEmployee để cài đặt interface Employee.
// Lớp này đại diện cho nhân viên làm việc full-time với các thuộc tính sau:
public class FullTimeEmployee implements Employee {
  // Tên nhân viên.
  private String name;

  // Mã nhân viên (duy nhất cho mỗi nhân viên).
  private String id;

  // Hệ số lương cơ bản.
  private double baseSalary;

  // Số ngày làm việc trong tháng.
  private int workingDays;

  // Lương thực tế (tính dựa trên số ngày làm việc và hệ số lương cơ bản).
  private double actualSalary;

  // Tạo một constructor với các tham số tương ứng.
  public FullTimeEmployee(String name, String id, double baseSalary, int workingDays) {
    this.name = name;
    this.id = id;
    this.baseSalary = baseSalary;
    this.workingDays = workingDays;
    this.actualSalary = calculateSalary();
  }

  // Cài đặt các phương thức của interface Employee.
  @Override
  public String getEmployeeID() {
    return id;
  }

  @Override
  public String getEmployeeName() {
    return name;
  }

  @Override
  public double calculateSalary() {
    // Lương thực tế bằng hệ số lương cơ bản nhân với số ngày làm việc.
    return baseSalary * workingDays;
  }

  // Tạo một phương thức toString để in ra thông tin của nhân viên.
  @Override
  public String toString() {
    return "FullTimeEmployee{" +
        "name='" + name + '\'' +
        ", id='" + id + '\'' +
        ", baseSalary=" + baseSalary +
        ", workingDays=" + workingDays +
        ", actualSalary=" + actualSalary +
        '}';
  }
}

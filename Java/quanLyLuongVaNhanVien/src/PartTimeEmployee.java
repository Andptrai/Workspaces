// Tạo một lớp PartTimeEmployee cài đặt interface Employee.
// Lớp này đại diện cho nhân viên làm việc part-time với các thuộc tính sau:
public class PartTimeEmployee implements Employee {
  // Tên nhân viên.
  private String name;

  // Mã nhân viên (unique cho mỗi nhân viên).
  private String id;

  // Hệ số lương cơ bản.
  private double baseSalary;

  // Số giờ làm việc trong tháng.
  private int workingHours;

  // Lương thực tế (tính dựa trên số giờ làm việc và hệ số lương cơ bản).
  private double actualSalary;

  // Tạo một constructor với các tham số tương ứng.
  public PartTimeEmployee(String name, String id, double baseSalary, int workingHours) {
    this.name = name;
    this.id = id;
    this.baseSalary = baseSalary;
    this.workingHours = workingHours;
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
    // Lương thực tế bằng hệ số lương cơ bản nhân với số giờ làm việc.
    return baseSalary * workingHours;
  }

  // Tạo một phương thức toString để in ra thông tin của nhân viên.
  @Override
  public String toString() {
    return "PartTimeEmployee{" +
        "name='" + name + '\'' +
        ", id='" + id + '\'' +
        ", baseSalary=" + baseSalary +
        ", workingHours=" + workingHours +
        ", actualSalary=" + actualSalary +
        '}';
  }
}

// Tạo một lớp Company để quản lý danh sách các nhân viên trong công ty.
// Cài đặt interface Employee cho lớp Company để cho phép nhiều lớp cùng cài đặt một interface.
// Sử dụng nested class để quản lý danh sách nhân viên.
public class Company implements Employee {
  // Tạo một nested class Node để lưu trữ thông tin của một nhân viên và con trỏ đến nhân viên tiếp theo.
  private static class Node {
    // Thông tin của một nhân viên.
    private Employee employee;

    // Con trỏ đến nhân viên tiếp theo.
    private Node next;

    // Tạo một constructor với tham số là một nhân viên.
    public Node(Employee employee) {
      this.employee = employee;
      this.next = null;
    }
  }

  // Tạo một biến để lưu trữ đầu của danh sách nhân viên.
  private Node head;

  // Tạo một biến để lưu trữ số lượng nhân viên trong công ty.
  private int size;

  // Tạo một constructor không tham số để khởi tạo danh sách nhân viên rỗng.
  public Company() {
    this.head = null;
    this.size = 0;
  }

  // Cài đặt các phương thức của interface Employee.
  // Do lớp Company không phải là một nhân viên,
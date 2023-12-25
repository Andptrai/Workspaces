import java.util.ArrayList;
import java.util.List;

public class Company implements Employee {
    private List<Employee> employees;

    public Company() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void printEmployeeInfo(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                System.out.println("Employee ID: " + employee.getEmployeeId());
                System.out.println("Employee Name: " + employee.getEmployeeName());
                System.out.println("Salary: " + employee.calculateSalary());
                if (employee instanceof Manager) {
                    System.out.println("Department: " + ((Manager) employee).getDepartment());
                }
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public double calculateTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.calculateSalary();
        }
        return totalSalary;
    }

    @Override
    public int getEmployeeId() {
        // This method is required by the Employee interface but may not be meaningful for Company.
        return 0;
    }

    @Override
    public String getEmployeeName() {
        // This method is required by the Employee interface but may not be meaningful for Company.
        return null;
    }

    @Override
    public double calculateSalary() {
        // This method is required by the Employee interface but may not be meaningful for Company.
        return 0;
    }

    // Nested class to manage employees
    static class EmployeeManagement {
        public static void removeEmployeeById(List<Employee> employees, int employeeId) {
            employees.removeIf(employee -> employee.getEmployeeId() == employeeId);
        }

        public static void printAllEmployeeInfo(List<Employee> employees) {
            for (Employee employee : employees) {
                System.out.println("Employee ID: " + employee.getEmployeeId());
                System.out.println("Employee Name: " + employee.getEmployeeName());
                System.out.println("Salary: " + employee.calculateSalary());
                if (employee instanceof Manager) {
                    System.out.println("Department: " + ((Manager) employee).getDepartment());
                }
                System.out.println();
            }
        }    }
}

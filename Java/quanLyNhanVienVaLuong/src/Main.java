public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        // Add employees to the company
        company.addEmployee(new FullTimeEmployee(1, "Dat Nguyen", 1500.0, 30));
        company.addEmployee(new PartTimeEmployee(2, "Minh Le", 500.0, 80));
        company.addEmployee(new ManagerEmployee(3, "An Phan", 20000.0, 20, "HR"));

        // Print employee info based on employee ID
        company.printEmployeeInfo(1);
        company.printEmployeeInfo(2);
        company.printEmployeeInfo(3);

        // Calculate and print total salary of all employees
        System.out.println("Total Salary: " + company.calculateTotalSalary());
    }
}

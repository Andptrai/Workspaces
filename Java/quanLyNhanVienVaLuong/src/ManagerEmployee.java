public class ManagerEmployee extends FullTimeEmployee implements Manager {
    private String department;

    public ManagerEmployee(int employeeId, String employeeName, double baseSalaryCoefficient, int daysWorked, String department) {
        super(employeeId, employeeName, baseSalaryCoefficient, daysWorked);
        this.department = department;
    }

    @Override
    public String getDepartment() {
        return department;
    }
}

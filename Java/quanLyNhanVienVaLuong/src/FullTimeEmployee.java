public class FullTimeEmployee implements Employee {
    private int employeeId;
    private String employeeName;
    private double baseSalaryCoefficient;
    private int daysWorked;

    public FullTimeEmployee(int employeeId, String employeeName, double baseSalaryCoefficient, int daysWorked) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.baseSalaryCoefficient = baseSalaryCoefficient;
        this.daysWorked = daysWorked;
    }

    @Override
    public int getEmployeeId() {
        return employeeId;
    }

    @Override
    public String getEmployeeName() {
        return employeeName;
    }

    @Override
    public double calculateSalary() {
        return baseSalaryCoefficient * (daysWorked/30.0);
    }
}

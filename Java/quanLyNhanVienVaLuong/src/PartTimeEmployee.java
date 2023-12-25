    public class PartTimeEmployee implements Employee {
        private int employeeId;
        private String employeeName;
        private double baseSalaryCoefficient;
        private int hoursWorked;

        public PartTimeEmployee(int employeeId, String employeeName, double baseSalaryCoefficient, int hoursWorked) {
            this.employeeId = employeeId;
            this.employeeName = employeeName;
            this.baseSalaryCoefficient = baseSalaryCoefficient;
            this.hoursWorked = hoursWorked;
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
            return baseSalaryCoefficient * hoursWorked;
        }
    }

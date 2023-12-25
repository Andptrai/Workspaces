

public class Main {
    public static void main(String[] args) {
    	UnderGradStudents s1 = new UnderGradStudents(1, "Nguyen", "Dat", "2022", "CNTT", "CNTT");
        GradStudents s2 = new GradStudents(2, "An", "Phan", "2010", "CNTT", "Software Engineer");
        GradStudents s3 = new GradStudents(2, "Ngoc", "Nguyen", "2022", "CNTT", "DEv");
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());
        CL c1 = new CL(1, "Programming");
        CL c2 = new CL(2, "Database");
        CL c3 = new CL(3, "Advanced Artificial Intelligence");

        Enrolling enrolling = new Enrolling();
        enrolling.getClasses().add(c1);
        enrolling.getClasses().add(c2);
        enrolling.getClasses().add(c3);

        enrolling.enroll(s1, c1);
        enrolling.enroll(s2, c1);
        enrolling.enroll(s3, c2);

        enrolling.printEnrollments();
    }
}

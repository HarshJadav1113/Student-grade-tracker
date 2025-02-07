package services;

public class StudentGradeTrackerService {
    private StudentDAO studentDAO;
    private GradeDAO gradeDAO;

    public StudentGradeTrackerService() {
        this.studentDAO = new StudentDAO();
        this.gradeDAO = new GradeDAO();
    }

    public void addStudentWithGrades(Student student, List<Grade> grades) {
        try {
            studentDAO.addStudent(student);
            for (Grade grade : grades) {
                gradeDAO.addGrade(grade);
            }
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    public void generatePerformanceReport(int studentId) {
        try {
            double average = gradeDAO.calculateAverage(studentId);
            Student student = studentDAO.getStudent(studentId);
            System.out.println("Performance Report for " + student.getFirstName() + " " + student.getLastName());
            System.out.println("Average Score: " + average);
            // Add more analysis here
        } catch (SQLException e) {
            System.out.println("Error generating report: " + e.getMessage());
        }
    }
}

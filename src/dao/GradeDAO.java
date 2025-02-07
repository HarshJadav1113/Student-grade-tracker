package dao;

public class GradeDAO {
    private Connection connection;

    public GradeDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public void addGrade(Grade grade) throws SQLException {
        String sql = "INSERT INTO grades (student_id, subject, score) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, grade.getStudentId());
            statement.setString(2, grade.getSubject());
            statement.setDouble(3, grade.getScore());
            statement.executeUpdate();
        }
    }

    public double calculateAverage(int studentId) throws SQLException {
        String sql = "SELECT AVG(score) FROM grades WHERE student_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, studentId);
            ResultSet rs = statement.executeQuery();
            return rs.next() ? rs.getDouble(1) : 0.0;
        }
    }
}
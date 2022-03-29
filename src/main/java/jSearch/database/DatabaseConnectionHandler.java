package jSearch.database;

import jSearch.models.Applicant;
import jSearch.models.JobPositionBelongsTo;
import jSearch.models.JobPositionCompensation;
import jSearch.models.SpecializationInfo;
import javafx.util.Pair;
import jdk.nashorn.internal.runtime.Specialization;

import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

public class DatabaseConnectionHandler {

    private static final String POSTGRESQL_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String POSTGRESQL_USER = "postgres";
    private static final String POSTGRESQL_PASSWORD = "password";

    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";

    private Connection conn = null;

    /**
     * Create database connection using try-with-resource pattern.
     */
    public DatabaseConnectionHandler() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                    POSTGRESQL_URL, POSTGRESQL_USER, POSTGRESQL_PASSWORD);
            conn.setAutoCommit(false);

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    // SELECTION QUERY
    public JobPositionCompensation[] getPositionsWithSalary(int minSalary) {
        ArrayList<JobPositionCompensation> result = new ArrayList<>();

        try {
            String query = "SELECT company_id, position_title, salary FROM job_position_compensation WHERE salary > ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, minSalary);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                JobPositionCompensation model = new JobPositionCompensation(rs.getObject("company_id", java.util.UUID.class),
                    rs.getString("position_title"),
                    rs.getInt("salary"));
                result.add(model);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new JobPositionCompensation[result.size()]);
    }
    public SpecializationInfo[] getSpecializationFromApplicant(String applicant_email) {
        ArrayList<SpecializationInfo> result = new ArrayList<>();

        try {
            String query = "SELECT major, minor, is_honours, degree_type FROM specialization_info, applicant " +
                    "WHERE applicant.applicant_email = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, applicant_email);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SpecializationInfo model = new SpecializationInfo(rs.getString("major"),
                    rs.getString("minor"),
                    rs.getBoolean("is_honours"),
                    rs.getString("degree_type"));
                result.add(model);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new SpecializationInfo[result.size()]);
    }

    public Pair[] getNumberApplicantsPerJobPosition() {
        ArrayList<Pair> result = new ArrayList<>();

        try {
            String query = "SELECT position_id, count(applicant_id) FROM application_made GROUP BY position_id";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pair model = new Pair<String, Integer>(rs.getString("position_id"),
                        rs.getInt("count"));
                result.add(model);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new Pair[result.size()]);
    }

    private void rollbackConnection() {
        try {
            conn.rollback();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }
}

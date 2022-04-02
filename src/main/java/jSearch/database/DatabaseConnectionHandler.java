package jSearch.database;

import jSearch.models.Applicant;
import jSearch.models.JobPositionBelongsTo;
import jSearch.models.JobPositionCompensation;
import jSearch.models.SpecializationInfo;
import javafx.util.Pair;
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
                JobPositionCompensation model = new JobPositionCompensation((java.util.UUID) rs.getObject("company_id"),
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


    // PROJECTION QUERY
    public Object[] getFieldFromApplicant(String columnName) {
        Object[] result;

        switch (columnName) {
            case "applicant_id":
                result = getApplicantIDFromApplicant();
                break;
            case "applicant_name":
                result = getApplicantNameFromApplicant();
                break;
            case "applicant_phone":
                result = getApplicantPhoneFromApplicant();
                break;
            case "applicant_email":
                result = getApplicantEmailFromApplicant();
                break;
            case "spec_id":
                result = getSpecIDFromApplicant();
                break;
            case "supervisor_id":
                result = getSupervisorIDFromApplicant();
                break;
            case "university_name":
                result = getUniversityNameFromApplicant();
                break;
            default:
                result = new Object[]{columnName + " is an invalid column name."};
                break;
        }

        return result;
    }

    public UUID[] getApplicantIDFromApplicant() {
        ArrayList<UUID> result = new ArrayList<>();
        try {
            String query = "SELECT applicant_id FROM applicant";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UUID applicant_id = (java.util.UUID) rs.getObject("applicant_id");
                result.add(applicant_id);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return result.toArray(new UUID[result.size()]);
    }

    public String[] getApplicantNameFromApplicant() {
        ArrayList<String> result = new ArrayList<>();
        try {
            String query = "SELECT applicant_name FROM applicant";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String applicant_name = rs.getString("applicant_name");
                result.add(applicant_name);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return result.toArray(new String[result.size()]);
    }

    public String[] getApplicantPhoneFromApplicant() {
        ArrayList<String> result = new ArrayList<>();
        try {
            String query = "SELECT applicant_phone FROM applicant";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String applicant_phone = rs.getString("applicant_phone");
                result.add(applicant_phone);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return result.toArray(new String[result.size()]);
    }

    public String[] getApplicantEmailFromApplicant() {
        ArrayList<String> result = new ArrayList<>();
        try {
            String query = "SELECT applicant_email FROM applicant";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String applicant_email = rs.getString("applicant_email");
                result.add(applicant_email);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return result.toArray(new String[result.size()]);
    }

    public UUID[] getSpecIDFromApplicant() {
        ArrayList<UUID> result = new ArrayList<>();
        try {
            String query = "SELECT spec_id FROM applicant";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UUID spec_id = (java.util.UUID) rs.getObject("spec_id");
                result.add(spec_id);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return result.toArray(new UUID[result.size()]);
    }

    public UUID[] getSupervisorIDFromApplicant() {
        ArrayList<UUID> result = new ArrayList<>();
        try {
            String query = "SELECT supervisor_id FROM applicant";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UUID supervisor_id = (java.util.UUID) rs.getObject("supervisor_id");
                result.add(supervisor_id);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return result.toArray(new UUID[result.size()]);
    }

    public String[] getUniversityNameFromApplicant() {
        ArrayList<String> result = new ArrayList<>();
        try {
            String query = "SELECT university_name FROM applicant";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String university_name = rs.getString("university_name");
                result.add(university_name);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return result.toArray(new String[result.size()]);
    }


    // JOIN QUERY
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


    // AGGREGATION QUERY
    public Pair[] getNumberApplicantsPerUniversity() {
        ArrayList<Pair> result = new ArrayList<>();

        try {
            String query = "SELECT university_name, COUNT(*) FROM attends GROUP BY university_name";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pair model = new Pair<String, Integer>(rs.getString("university_name"),
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


    // NESTED AGGREGATION WITH GROUP BY QUERY
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


    // DIVISION QUERY
    public String[] getJobPositionsAllApplicantsAppliedTo() {
        ArrayList<String> result = new ArrayList<>();
        try {
            String query = "SELECT position_title FROM job_position_belongs_to J WHERE NOT EXISTS ((SELECT A.applicant_id FROM Applicant A) EXCEPT (SELECT AM.applicant_id FROM Application_MADE AM WHERE AM.position_id = J.position_id))";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String position_title = rs.getString("position_title");
                result.add(position_title);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return result.toArray(new String[result.size()]);
    }



    // CRUD OPERATIONS
    // public void insertApplicationMade() {
        // TODO
    // }

    private void rollbackConnection() {
        try {
            conn.rollback();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }
}

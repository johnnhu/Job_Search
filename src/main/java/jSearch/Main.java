package jSearch;

import com.google.gson.Gson;
import jSearch.database.DatabaseConnectionHandler;
import jSearch.models.Applicant;
import jSearch.models.ApplicationMade;
import spark.Request;
import spark.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.patch;
import static spark.Spark.delete;

public class Main {
    private static DatabaseConnectionHandler dbConn;

    public static void main(String[] args) {
        dbConn = new DatabaseConnectionHandler();
        get("/hello/:name", (request, response) -> {
            return "Hello: " + request.params(":name");
        });

        get("/test", (req, res) -> testDb());

        get("/hello", "application/json", (request, response) -> {
            return "Hello World";
        }, new JsonTransformer());

        // endpoints for queries:
        get("/selection/:salary", (req, res) -> dbSelection(req, res), new JsonTransformer());
        get("/projection/:column", (req, res) -> dbProjection(req, res), new JsonTransformer());
        get("/join", (req, res) -> dbJoin(req, res), new JsonTransformer());
        get("/aggregation", (req, res) -> dbAggregation(req, res), new JsonTransformer());
        get("/nestedAggregation", (req, res) -> dbNAggregation(req, res), new JsonTransformer());
        get("/division", (req, res) -> dbDivision(req, res), new JsonTransformer());

        // endpoints for CRUD operations
        post("/applicants", (req, res) -> dbInsert(req, res), new JsonTransformer());
        get("/applicants", (req, res) -> dbApplicants(req, res), new JsonTransformer());

    }

    private static Object dbSelection(Request req, Response res) {
        return dbConn.getPositionsWithSalary(Integer.parseInt(req.params("salary")));
    }

    private static Object dbApplicants(Request req, Response res) {
        return dbConn.getAllApplicants();
    }

    private static Object dbProjection(Request req, Response res) {
        return dbConn.getFieldFromApplicant(req.params("column"));
    }

    private static Object dbJoin(Request req, Response res) {
        return dbConn.getSpecializationFromApplicant(req.body());
    }

    private static Object dbAggregation(Request req, Response res) {
        return dbConn.getNumberApplicantsPerUniversity();
    }

    private static Object dbNAggregation(Request req, Response res) {
        return dbConn.getNumberApplicantsPerJobPosition();
    }

    private static Object dbDivision(Request req, Response res) {
        return dbConn.getJobPositionsAllApplicantsAppliedTo();
    }

    private static String dbInsert(Request req, Response res) {
        Gson gson = new Gson();
        Applicant app = gson.fromJson(req.body(), Applicant.class);

//        System.out.println("application id: (" + app.application_id.getClass().getName() + ") " + app.application_id);
//        System.out.println("status: (" + app.status.getClass().getName() + ") " + app.status);
//        System.out.println("applicant id: (" + app.applicant_id.getClass().getName() + ") " + app.applicant_id);
//        System.out.println("position id: (" + app.position_id.getClass().getName() + ") " + app.position_id);

//        String status = req.body().
//        String status = req.params("status_description");
//        int resume_version = Integer.parseInt(req.params("resume_version"));
//        int cover_letter_version = Integer.parseInt(req.params("cover_letter_version"));
//        UUID applicant_id = UUID.fromString(req.params("applicant_id"));
//        UUID position_id = UUID.fromString(req.params("position_id"));

//        try {
//            Date date_of_application = parseDate(req.params("date_of_application"));
//            app = new ApplicationMade(status, resume_version, cover_letter_version, date_of_application, applicant_id, position_id);
//        } catch (ParseException e) {
//            app = new ApplicationMade(status, resume_version, cover_letter_version, applicant_id, position_id);
//        }
        return dbConn.insertApplicant(app);
    }


    private static int testDb() {
        dbConn.close();
        return 0;
    }

    // note: str should be passed in the form YYYY-MM-DD
    private static Date parseDate(String str) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        Date date = formatter.parse(str);
        return date;
    }

}

package jSearch;

import com.google.gson.Gson;
import jSearch.database.DatabaseConnectionHandler;
import jSearch.models.Applicant;
import jSearch.models.Message;
import spark.Request;
import spark.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static spark.Spark.*;

public class Main {
    private static DatabaseConnectionHandler dbConn;

    public static void main(String[] args) {
        dbConn = new DatabaseConnectionHandler();

        enableCORS("*", "*", "*");

        exception(Exception.class, (e, req, res) -> e.printStackTrace()); // print all exceptions

        get("/", "application/json", (request, response) -> {
            return new Message("Hello World");
        }, new JsonTransformer());

        get("/hello/:name", (request, response) -> {
            return "Hello: " + request.params(":name");
        });
        get("/test", (req, res) -> testDb());

        get("/hello", "application/json", (request, response) -> new Message("Hello World"), new JsonTransformer());

        // endpoints for queries:
        get("/selection/:salary", (req, res) -> dbSelection(req, res), new JsonTransformer());
        get("/projection/:column", (req, res) -> dbProjection(req, res), new JsonTransformer());
        get("/join/:email", (req, res) -> dbJoin(req, res), new JsonTransformer());
        get("/aggregation", (req, res) -> dbAggregation(req, res), new JsonTransformer());
        get("/nestedAggregation", (req, res) -> dbNAggregation(req, res), new JsonTransformer());
        get("/division", (req, res) -> dbDivision(req, res), new JsonTransformer());

        get("/applicants", (req, res) -> dbGetApplicants(req, res), new JsonTransformer());
        delete("/applicant/:id", (req, res) -> dbDeleteApplicant(req, res), new JsonTransformer());

        // endpoints for CRUD operations
        post("/applicant", (req, res) -> dbInsert(req, res), new JsonTransformer());
        put("/applicant", (req, res) -> dbUpdateApplicant(req, res), new JsonTransformer());
    }

    private static void enableCORS(final String origin, final String methods, final String headers) {
        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", origin);
            response.header("Access-Control-Request-Method", methods);
            response.header("Access-Control-Allow-Headers", headers);
            // Note: this may or may not be necessary in your particular application
            response.type("application/json");
        });
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
        return dbConn.getSpecializationFromApplicant(req.params("email"));
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

    private static Object dbInsert(Request req, Response res) {
        Gson gson = new Gson();
        System.out.println(req.body());
        Applicant app = gson.fromJson(req.body(), Applicant.class);
        return dbConn.insertApplicant(app);
    }

    private static Object dbUpdateApplicant(Request req, Response res) {
        Gson gson = new Gson();
        Applicant app = gson.fromJson(req.body(), Applicant.class);
        return dbConn.updateApplicant(app);
    }

    public static Object dbGetApplicants(Request req, Response res) {
        return dbConn.getApplicants();
    }

    public static Object dbDeleteApplicant(Request req, Response res) {
        String id = req.params("id");
        dbConn.deleteApplicant(id);

        return new Message("OK");
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

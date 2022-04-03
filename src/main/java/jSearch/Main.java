package jSearch;

import jSearch.database.DatabaseConnectionHandler;
import jSearch.models.Message;
import jSearch.utils.CorsFilter;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class Main {
    private static DatabaseConnectionHandler dbConn;

    public static void main(String[] args) {
//        ipAddress("0.0.0.0");
//        port(9999);

        CorsFilter.apply();

        dbConn = new DatabaseConnectionHandler();
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

        // endpoints for CRUD operations
        // TODO: in progress
        // post("/insertApplicationMade", (req, res) -> dbInsert(req, res), new JsonTransformer());

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

    // TODO: in progress
    // private static Object dbInsert(Request req, Response res) {
    //     return dbConn.insertApplicationMade();
    // }

    private static int testDb() {
        dbConn.close();
        return 0;
    }

}

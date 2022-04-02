package jSearch;

import jSearch.database.DatabaseConnectionHandler;
import spark.Request;
import spark.Response;

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

        get("/projection/:columnName", (req, res) -> dbProjection(req, res), new JsonTransformer());

        get("/aggregation", (req, res) -> dbAggregation(req, res), new JsonTransformer());

        get("/division", (req, res) -> dbDivision(req, res), new JsonTransformer());


        // endpoints for CRUD operations
        // TODO: in progress
        // post("/insertApplicationMade", (req, res) -> dbInsert(req, res), new JsonTransformer());

    }

    private static Object dbSelection(Request req, Response res) {
        return dbConn.getPositionsWithSalary(Integer.parseInt(req.params(":salary")));
    }

    private static Object dbProjection(Request req, Response res) {
        return dbConn.getFieldFromApplicant(req.params(":columnName"));
    }

    private static Object dbAggregation(Request req, Response res) {
        return dbConn.getNumberApplicantsPerUniversity();
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

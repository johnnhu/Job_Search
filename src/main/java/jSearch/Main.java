package jSearch;

import jSearch.database.DatabaseConnectionHandler;
import spark.Request;
import spark.Response;

import static spark.Spark.get;

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

        get("/selection/:salary", (req, res) -> dbSelection(req, res), new JsonTransformer());

        get("/projection/:column", (req, res) -> dbProjection(req, res), new JsonTransformer());

        get("/join", (req, res) -> dbJoin(req, res), new JsonTransformer());

        get("/nestedAggregation", (req, res) -> dbNAggregation(req, res), new JsonTransformer());
    }

    private static Object dbNAggregation(Request req, Response res) {
        return dbConn.getNumberApplicantsPerJobPosition();
    }

    private static Object dbJoin(Request req, Response res) {
        return dbConn.getSpecializationFromApplicant(req.body());
    }

    private static Object dbSelection(Request req, Response res) {
        return dbConn.getPositionsWithSalary(Integer.parseInt(req.params("salary")));
    }

    private static Object dbProjection(Request req, Response res) {
        return dbConn.getFieldFromApplicant(req.params("column"));
    }

    private static int testDb() {
        dbConn.close();
        return 0;
    }

}

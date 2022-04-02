package jSearch;

import jSearch.database.DatabaseConnectionHandler;
import jSearch.models.Message;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class Main {
    private static DatabaseConnectionHandler dbConn;

    public static void main(String[] args) {
        dbConn = new DatabaseConnectionHandler();
        // enableCORS("*", "GET,PUT,POST,DELETE,OPTIONS", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");

        options("*",
            (request, response) -> {
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
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        get("/hello/:name", (request, response) -> {
            return "Hello: " + request.params(":name");
        });
        get("/test", (req, res) -> testDb());

        get("/hello", "application/json", (request, response) -> new Message("Hello World"), new JsonTransformer());

        get("/selection/:salary", (req, res) -> dbSelection(req, res), new JsonTransformer());

    }

    private static Object dbSelection(Request req, Response res) {
        return dbConn.getPositionsWithSalary(Integer.parseInt(req.params(":salary")));
    }

    private static int testDb() {
        dbConn.close();
        return 0;
    }

}

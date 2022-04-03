package jSearch;

import com.google.gson.Gson;
import jSearch.database.DatabaseConnectionHandler;
import jSearch.models.ApplicationMade;
import jSearch.models.Status;
import spark.Request;
import spark.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.patch;
import static spark.Spark.delete;

public class Main {
    private static DatabaseConnectionHandler dbConn;

    public static void main(String[] args) {
        dbConn = new DatabaseConnectionHandler();
//        get("/hello/:name", (request, response) -> {
//            return "Hello: " + request.params(":name");
//        });

//        get("/test", (req, res) -> testDb());

//        get("/hello", "application/json", (request, response) -> {
//            return "Hello World";
//        }, new JsonTransformer());

        // endpoints for queries:
        get("/selection/:salary", (req, res) -> dbSelection(req, res), new JsonTransformer());
        get("/projection/:column", (req, res) -> dbProjection(req, res), new JsonTransformer());
        get("/join", (req, res) -> dbJoin(req, res), new JsonTransformer());
        get("/aggregation", (req, res) -> dbAggregation(req, res), new JsonTransformer());
        get("/nestedAggregation", (req, res) -> dbNAggregation(req, res), new JsonTransformer());
        get("/division", (req, res) -> dbDivision(req, res), new JsonTransformer());

        // endpoints for CRUD operations
        // TODO: in progress
        post("/insertApplicationMade/:status/:resume/:cover/:date/:applicant/:position", (request, response) -> dbInsert(request, response), new JsonTransformer());
        delete("/deleteApplicantCascadeAddress/:universityName", (req, res) -> dbDelete(req, res), new JsonTransformer());
        get("/viewAll/:table", (req, res) -> dbSelectAll(req, res), new JsonTransformer());
    }

    private static Object dbSelectAll(Request req, Response res) {
        return dbConn.selectAll(req.params("table"));
    }

    private static Object dbDelete(Request req, Response res) {
        return dbConn.deleteApplicantAndAddress(req.params("universityName"));
    }

    private static Object dbSelection(Request req, Response res) {
        return dbConn.getPositionsWithSalary(Integer.parseInt(req.params("salary")));
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

    private static Object dbInsert(Request req, Response res) throws Exception {
        Map<String, String> params = req.params();
        SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(params.get(":date"));

        String replaced = params.get(":status").replace("%20", " ");
        Status e = null;
        if (replaced.equals("Not Started")) {
            e = Status.NS;
        } else if (replaced.equals("Submitted")) {
            e = Status.S;
        } else if (replaced.equals("In Progress")) {
            e = Status.IP;
        } else if (replaced.equals("Offered Interview")) {
            e = Status.OI;
        } else if (replaced.equals("Under Review")) {
            e = Status.UR;
        } else if (replaced.equals("Offered Position")) {
            e = Status.OP;
        } else if (replaced.equals("Rejected")) {
            e = Status.R;
        } else {
            throw new Exception("Status not included");
        }

        ApplicationMade am = new ApplicationMade(e, Integer.parseInt(params.get(":resume")), Integer.parseInt(params.get(":cover")),
                date, UUID.fromString(params.get(":applicant")), UUID.fromString(params.get(":position")));
        return dbConn.insertApplicationMade(am);

    }


    private static int testDb() {
        dbConn.close();
        return 0;
    }

}

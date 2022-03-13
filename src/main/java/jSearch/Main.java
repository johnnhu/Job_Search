package jSearch;

import jSearch.database.DatabaseConnectionHandler;

import static spark.Spark.get;

public class Main {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");

        get("/test", (req, res) -> testDb());
    }

    private static int testDb() {
        DatabaseConnectionHandler db = new DatabaseConnectionHandler();
        db.deleteBranch(1);
        db.close();

        return 0;
    }
}

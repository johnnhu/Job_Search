package jSearch;

import jSearch.database.DatabaseConnectionHandler;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        DatabaseConnectionHandler db = new DatabaseConnectionHandler();

        db.deleteBranch(1);

        db.close();
    }
}

import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.sql2o.*;

import static org.junit.Assert.assertTrue;

public class DatabaseRule extends ExternalResource {

    //setup dbconnection before each testt
    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "postgres", null);
    }

    @Override
    protected void after() {
        //open db connection
        try(Connection con = DB.sql2o.open()) {
            //delete data within table after each test
            String deleteAnimalsQuery = "DELETE FROM animals *;";
            con.createQuery(deleteAnimalsQuery).executeUpdate();

            //delete data within table after each test
            String deleteRangersQuery = "DELETE FROM rangers";
            con.createQuery(deleteRangersQuery).executeUpdate();

            //delete data within table after each test
            String deleteSightingsQuery = "TRUNCATE TABLE sightings *";
            con.createQuery(deleteSightingsQuery).executeUpdate();

        }
    }



}
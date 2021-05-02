import org.sql2o.*;
public class DB {
    //    run db locally replacing user with db username and pass with db password
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker","postgres",null);
    //    run db on heroku replacing user with db username and pass with db password

}

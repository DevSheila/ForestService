import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import java.util.Objects;

public class Sighting implements DbManagement {
    private int id;
    private String animal_name;
    private String location_id;
    private int ranger_id;

    private String sight_time;
    Date now = new Date();
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");


    public Sighting(String animal_name, String location_id, int ranger_id) {
        this.animal_name = animal_name;
        this.location_id = location_id;
        this.ranger_id = ranger_id;
        this.sight_time = dateFormat.format(new Timestamp(now.getTime()));
    }

    @Override
    public void save() {

    }

    @Override
    public void update() {

    }
}
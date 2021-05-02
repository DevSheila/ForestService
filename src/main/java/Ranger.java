import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Ranger implements DbManagement {
    private int id;
    private String name;
    private String badge_number;
    private String phone_number;
    private String email;

    public Ranger(String name, String badge_number, String phone_number, String email) {
        this.name = name;
        this.badge_number = badge_number;
        this.phone_number = phone_number;
        this.email = email;
    }
}

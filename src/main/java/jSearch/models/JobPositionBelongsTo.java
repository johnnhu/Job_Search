package jSearch.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class JobPositionBelongsTo {
    public UUID position_id;
    public String position_title;
    public boolean is_filled;
    public UUID company_id;

    public JobPositionBelongsTo(UUID position_id, String position_title, boolean is_filled, UUID company_id) {
        this.position_id = position_id;
        this.position_title = position_title;
        this.is_filled = is_filled;
        this.company_id = company_id;
    }
}

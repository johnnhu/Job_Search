package jSearch.models;

import java.util.UUID;

public class JobPositionBelongsTo {
    UUID position_id;
    UUID company_id;
    String position_title;
    boolean is_filled;

    public JobPositionBelongsTo(UUID position_id, UUID company_id, String position_title, boolean is_filled) {
        this.position_id = position_id;
        this.company_id = company_id;
        this.position_title = position_title;
        this.is_filled = is_filled;
    }
}

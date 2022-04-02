package jSearch.models;

/*
    Source used for enum reference: https://www.baeldung.com/java-enum-values
 */

public enum Status {
    NS("Not Started"),
    IP("In Progress"),
    S("Submitted"),
    OI("Offered Interview"),
    UR("Under Review"),
    OP("Offered Position"),
    R("Rejected");

    public final String description;

    Status(String description) {
        this.description = description;
    }
}

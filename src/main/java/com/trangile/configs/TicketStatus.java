package com.trangile.configs;

public enum TicketStatus {
    NEW(0), 
    ASSIGNED(5), 
    RESOLVED(8), 
    CLOSED(9);

    private final int code;

    // Constructor to set the code for each enum value
    TicketStatus(int code) {
        this.code = code;
    }

    // Getter for the code
    public int getCode() {
        return this.code;
    }

    // Optionally, you can add a method to get an enum from a code
    public static TicketStatus fromCode(int code) {
        for (TicketStatus status : TicketStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown status code: " + code);
    }
}

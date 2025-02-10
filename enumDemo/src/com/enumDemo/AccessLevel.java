package com.enumDemo;

public enum AccessLevel {

	ADMIN,   // Full access rights
    USER,    // Limited access rights
    GUEST;   // Very restricted access rights

    // Method to get a description of the access level
    public String getDescription() {
        switch (this) {
            case ADMIN:
                return "Administrator: Full access to all features.";
            case USER:
                return "User: Access to standard features.";
            case GUEST:
                return "Guest: Very limited access.";
            default:
                return "Unknown access level.";
        }
    }
    // Method to get the ordinal (position) of the enum constant
    public int getOrdinal() {
        return this.ordinal();
    }

    // Method to check if the current level is higher than another level by ordinal the zero index being considered highest ie: in this case ADMIN has the ordinal 0
    public boolean isHigherThan(AccessLevel other) {
        return this.ordinal() < other.ordinal();
    } 
}
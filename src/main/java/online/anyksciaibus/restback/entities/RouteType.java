package online.anyksciaibus.restback.entities;

public enum RouteType {
    CITY_BUS("City Bus"),
    REGIONAL_BUS("Regional Bus"),
    NATIONAL_BUS("Nationial Bus");

    private final String description;

    RouteType(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }


    // Static method to retrieve enum constant by description
    public static RouteType getByDescription(String description) {
        for (RouteType type : values()) {
            if (type.description.equals(description)) {
                return type;
            }
        }
        return null; // Or throw IllegalArgumentException("Invalid description: " + description);
    }
}

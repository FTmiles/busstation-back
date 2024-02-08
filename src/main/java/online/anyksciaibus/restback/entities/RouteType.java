package online.anyksciaibus.restback.entities;

public enum RouteType {
    CITY_BUS, REGIONAL_BUS, NATIONAL_BUS;


    public String getDescription() {
        switch (this) {
            case CITY_BUS:
                return "City Bus";
            case REGIONAL_BUS:
                return "Regional Bus";
            case NATIONAL_BUS:
                return "National Bus";
            default:
                return ""; // Handle unknown type gracefully
        }
    }
}

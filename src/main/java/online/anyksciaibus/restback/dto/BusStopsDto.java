package online.anyksciaibus.restback.dto;

public class BusStopsDto {
    //actually it's ID
    Long value;

    String label;







    //==================


    public BusStopsDto() {
    }

    public BusStopsDto(Long value, String label) {

        this.value = value;
        this.label = label;
    }



    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

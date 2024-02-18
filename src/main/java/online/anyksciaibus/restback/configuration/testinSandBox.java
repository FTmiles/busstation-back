package online.anyksciaibus.restback.configuration;

import online.anyksciaibus.restback.dto.LinePreviewDto;
import online.anyksciaibus.restback.entities.RouteType;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

public class testinSandBox {
    private Map<Integer, LocalDate> easterDateMap = new HashMap<>();


    public static void main(String[] args) {


        RouteType myType = RouteType.getByDescription("Regional Bus");
        System.out.println(myType);

    }
}

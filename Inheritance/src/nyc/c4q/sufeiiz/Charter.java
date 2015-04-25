package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 4/25/15.
 */

public class Charter extends Flight{
    // fields
    private String departureDateTime;

    // constructor
    public Charter(int flightNumber, String departureCity, String arrivalCity, String departureDateTime) {
        super(flightNumber, departureCity, arrivalCity);
        setDepartureDateTime(departureDateTime);
    }

    // getters and setters
    public String getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    @Override
    public String toString() {
        return "Flight :" + this.getFlightNumber() + " " + this.getDepartureCity() + " - " + this.getArrivalCity() +
                " departing " + this.getDepartureDateTime();
    }
}

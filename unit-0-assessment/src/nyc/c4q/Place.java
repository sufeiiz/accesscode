package nyc.c4q;

/**
 * Created by ben on 4/8/15.
 */
public class Place {
    private String name;
    private Double latitude;
    private Double longitude;

    public Place() {}

    public Place(String name) {
        this.name = name;
        // Default lon,lat in New York City
        this.longitude = 40.74;
        this.latitude = -74.0;
    }

    public Place(String name, Double latitude, Double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return latitude;
    }
    public Double getLon() {
        return longitude;
    }

    public void setLat(Double latitude) {
        this.latitude = latitude;
    }
    public void setLon(Double longitude) {
        this.longitude = longitude;
    }
}
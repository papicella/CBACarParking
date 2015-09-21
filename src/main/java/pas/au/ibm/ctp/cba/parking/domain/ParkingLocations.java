package pas.au.ibm.ctp.cba.parking.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ParkingLocations
{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String locationName;
    private String parkingLOcation;
    private int availableCarParks;
    private String parkingMapsUrl;

    public ParkingLocations() {
    }

    public ParkingLocations(int availableCarParks, String locationName, String parkingLOcation, String parkingMapsUrl) {
        this.availableCarParks = availableCarParks;
        this.locationName = locationName;
        this.parkingLOcation = parkingLOcation;
        this.parkingMapsUrl = parkingMapsUrl;
    }

    public int getAvailableCarParks() {
        return availableCarParks;
    }

    public void setAvailableCarParks(int availableCarParks) {
        this.availableCarParks = availableCarParks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getParkingLOcation() {
        return parkingLOcation;
    }

    public void setParkingLOcation(String parkingLOcation) {
        this.parkingLOcation = parkingLOcation;
    }

    public String getParkingMapsUrl() {
        return parkingMapsUrl;
    }

    public void setParkingMapsUrl(String parkingMapsUrl) {
        this.parkingMapsUrl = parkingMapsUrl;
    }

    @Override
    public String toString() {
        return "ParkingLocations{" +
                "availableCarParks=" + availableCarParks +
                ", id=" + id +
                ", locationName='" + locationName + '\'' +
                ", parkingLOcation='" + parkingLOcation + '\'' +
                ", parkingMapsUrl='" + parkingMapsUrl + '\'' +
                '}';
    }
}

package Model;

public class Location {
    
    private Double longitude;
    private Double latitude;
    private String district;
    private String cityBlock;
    private String arrestLocation;

    public Location() {
    }

    public Location(Double longitude, Double latitude, String district, String cityBlock, String arrestLocation) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.district = district;
        this.cityBlock = cityBlock;
        this.arrestLocation = arrestLocation;
    }

    public Location(String district, String cityBlock, String arrestLocation) {
        this.district = district;
        this.cityBlock = cityBlock;
        this.arrestLocation = arrestLocation;
    }
    
    

    public String getLongitude() {
        if(longitude==null){
            return "No Data Available";
        }else
        return longitude.toString();
    }

    public String getLatitude() {
        if(latitude==null){
            return "No Data Available";
        }else
        return latitude.toString();
    }

    public String getDistrict() {
        if(district==null){
            return "No Data Available";
        }else
        return district;
    }

    public String getCityBlock() {
        if(cityBlock==null){
            return "No Data Available";
        }else
        return cityBlock;
    }

    public String getArrestLocation() {
        if(arrestLocation==null){
            return "No Data Available";
        }else
        return arrestLocation;
    }
}
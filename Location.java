public class Location {
    private String streetAddress;
    private double latitude;
    private double longitude;

    //Object Creation
    public Location(){
        streetAddress = "";
        latitude = 0;
        longitude = 0;
    }

    public Location (double lat, double lon){
        latitude = lat;
        longitude = lon;
        streetAddress = translateCoords();
    }

    public Location(String a){
        streetAddress = a;
        
        double[] locs = translateAddy();
        latitude = locs[0];
        longitude = locs[1];
    }

    //Privates
    private double[] translateAddy(){
        double[] toReturn = new double[2];

        return toReturn;
    }

    private String translateCoords(){

        return "";
    }

    //Setters
    public boolean setAddress(String addy){

        return false;
    }

    public boolean setAddress(double lat, double lon){

        return false;
    }

    //Getters
    public double[] getCoords(){
        double[] toReturn = {latitude, longitude};
        return toReturn;
    }

    public String getAddy(){
        return streetAddress;
    }
}

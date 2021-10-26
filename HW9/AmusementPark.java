import java.util.ArrayList;

public class AmusementPark implements Park {
    private double admissionCost;
    private boolean arcade;
    private boolean bowling;
    private boolean indoor;
    private double land;
    private String name;
    private boolean outdoor;
    private ArrayList<Ride> rides;
    private boolean[] seasons;
    public AmusementPark(String name, double admissionCost, double land, ArrayList<Ride> rides,
        boolean indoor, boolean outdoor, boolean arcade, boolean bowling, boolean[] seasons) {
        this.name = name;
        this.admissionCost = admissionCost;
        this.land = land;
        this.rides = rides;
        this.indoor = indoor;
        this.outdoor = outdoor;
        this.arcade = arcade;
        this.bowling = bowling;
        this.seasons = seasons;
    }
    public boolean isArcade() {
        return arcade;

    }
    public void setArcade(boolean arcade) {
        this.arcade = arcade;
    }
    public boolean isBowling() {
        return bowling;
    }
    public void setBowling(boolean bowling) {
        this.bowling = bowling;
    }
    public double getAdmissionCost() {
        return admissionCost;
    }
    public void setAdmissionCost(double admissionCost) {
        this.admissionCost = admissionCost;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getLand() {
        return land;
    }
    public void addRide(Ride ride) throws WrongRideException {
        if (ride instanceof Rollercoaster)
            rides.add(ride);
        else
            throw new WrongRideException("An amusement park can only have rollercoaster rides!");
    }
    public void removeRide(Ride ride) {
        for (int i = 0; i < rides.size(); i++) {
            if (rides.get(i).equals(ride))
                rides.remove(i);
        }
    }
    public ArrayList<Ride> getRides() {
        return rides;
    }
    public boolean isIndoor() {
        return indoor;
    }
    public boolean isOutdoor() {
        return outdoor;
    }
    public void setSeasons(boolean[] seasons) {
        this.seasons = seasons;
    }
    public boolean[] getSeasons() {
        return seasons;
    }
    public void enlarge(double addedLand, double maxLand, boolean addedIndoor, 
        boolean addedOutdoor) throws SpaceFullException {
        if (this.land + addedLand > maxLand)
            throw new SpaceFullException("There is no more land to use for this park!");
        else {
            this.land += addedLand;
            if (addedIndoor)
                this.indoor = true;
            if (addedOutdoor)
                this.outdoor = true;
        }
    }
    public void modifyRide(Ride ride, String newName, String newColor, int newMinHeight, int newMaxRiders, boolean newSimulated) {
        for (int i = 0; i < rides.size(); i++) {
            if (rides.get(i).equals(ride)) {
                Ride r = new Rollercoaster(newName, newColor, newMinHeight, newMaxRiders, newSimulated);
                rides.set(i, r);
            }
        }
    }
    public void close() {
        this.name = "";
        this.admissionCost = 0;
        this.land = 0;
        this.rides = null;
        this.seasons = null;
        this.indoor = false;
        this.outdoor = false;
        this.bowling = false;
        this.arcade = false;
    }
}
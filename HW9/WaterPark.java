import java.util.ArrayList;

public class WaterPark implements Park {
    private double admissionCost;
    private boolean indoor;
    private double land;
    private boolean lazyRiver;
    private String name;
    private boolean outdoor;
    private ArrayList<Ride> rides;
    private boolean[] seasons;
    private boolean wavePool;

    public WaterPark(String name, double admissionCost, double land, ArrayList<Ride> rides,
        boolean indoor, boolean outdoor, boolean lazyRiver, boolean wavePool, boolean[] seasons) {
        this.name = name;
        this.admissionCost = admissionCost;
        this.land = land;
        this.rides = rides;
        this.indoor = indoor;
        this.outdoor = outdoor;
        this.lazyRiver = lazyRiver;
        this.wavePool = wavePool;
        this.seasons = seasons;
    }
    public boolean isLazyRiver() {
        return lazyRiver;
    }
    public void setLazyRiver(boolean lazyRiver) {
        this.lazyRiver = lazyRiver;
    }
    public boolean isWavePool() {
        return wavePool;
    }
    public void setWavePool(boolean wavePool) {
        this.wavePool = wavePool;
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
        if (ride instanceof Waterslide)
            rides.add(ride);
        else
            throw new WrongRideException("A waterpark can only have waterslide rides!");
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
    public void modifyRide(Ride ride, String newName, String newColor, int newMinHeight, int newMaxRiders, double newSplashDepth) {
        for (int i = 0; i < rides.size(); i++) {
            if (rides.get(i).equals(ride)) {
                Ride r = new Waterslide(newName, newColor, newMinHeight, newMaxRiders, newSplashDepth);
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
        this.lazyRiver = false;
        this.wavePool = false;
    }
}

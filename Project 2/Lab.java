public class Lab {
    private Session morning;
    private Session afternoon;
    private int capacity;
    private String location;

    public Lab(Session morning, Session afternoon, int capacity, String location) {
        this.morning = morning;
        this.afternoon = afternoon;
        this.capacity = capacity;
        this.location = location;
    }
    public Lab(int capacity, String location) {
        this.capacity = capacity;
        this.location = location;
        this.morning = new Session();
        this.afternoon = new Session();
    }
    public Session getMorning() {
        return morning;
    }
    public Session getAfternoon() {
        return afternoon;
    }
    public int getCapacity() {
        return capacity;
    }
    public String getLocation() {
        return location;
    }
    public void setMorning(Session morning) {
        this.morning = morning;
    }
    public void setAfternoon(Session afternoon) {
        this.afternoon = afternoon;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String listAvailabilities() {
        String availability = "";
        if(morning.getEnrollment() == 0)
            availability += "Morning: Available\n";
        if(afternoon.getEnrollment() == 0)
            availability += "Afternoon: Available\n";
        if(morning.getEnrollment() != 0 && afternoon.getEnrollment() != 0)
            availability = "No Availabilities";
        return availability;
    }
    public String listReservations() {
        String reservation = "";
        if(morning.getEnrollment() != 0)
            reservation += "Morning: Reserved\n";
        if(afternoon.getEnrollment() != 0)
            reservation += "Afternoon: Reserved\n";
        if(morning.getEnrollment() == 0 && afternoon.getEnrollment() == 0)
            reservation = "No Reservations";
        return reservation;
    }
    public String toString() {
        String lab = "Lab{Capacity - " + capacity + ", Location - " + location + ", Morning: ";
        if(morning.getEnrollment() != 0)
            lab += morning.toString();
        else
            lab += "Available";
        if(afternoon.getEnrollment() != 0)
            lab += ", Afternoon: " + afternoon.toString();
        else
            lab += ", Afternoon: Available";
        lab += "}"; 
        return lab;
    }
}

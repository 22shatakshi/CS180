public class Ride {
    private String name;
    private String color;
    private int minHeight;
    private int maxRiders;
    public Ride() {
        name = "";
        color = "";
        minHeight = 0;
        maxRiders = 0;
    }
    public Ride(String name, String color, int minHeight, int maxRiders) {
        this.name = name;
        this.color = color;
        this.minHeight = minHeight;
        this.maxRiders = maxRiders;
    }
    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public int getMinHeight() {
        return minHeight;
    }
    public int getMaxRiders() {
        return maxRiders;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }
    public void setMaxRiders(int maxRiders) {
        this.maxRiders = maxRiders;
    }
    public boolean equals(Object o) {
        if(o instanceof Ride) {
            Ride obj = (Ride) o;
            if (obj.getName().equals(name) && obj.getColor().equals(color) && 
                obj.getMinHeight() == minHeight && obj.getMaxRiders() == maxRiders)
                return true;
        }
        return false;
    }
    public String toString() {
        String ride = "Name: " + name + "\nColor: " + color + "\nMinHeight: " + minHeight +
            " inches\nMaxRiders: " + maxRiders;
        return ride;
    }


}

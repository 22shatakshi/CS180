public class Rollercoaster extends Ride {
    private boolean simulated;
    public Rollercoaster(String name, String color, int minHeight, int maxRiders, boolean simulated) {
        super(name, color, minHeight, maxRiders);
        this.simulated = simulated;
    }
    public boolean isSimulated() {
        return simulated;
    }
    public void setSimulated(boolean simulated) {
        this.simulated = simulated;
    }
    @Override
    public boolean equals(Object o) {
        if(o instanceof Rollercoaster) {
           // if (obj.getName().equals(this.getName()) && obj.getColor().equals(this.getColor()) && 
            //    obj.getMinHeight() == this.getMinHeight() && obj.getMaxRiders() == this.getMinHeight())
            if (super.equals(o)) {
                Rollercoaster obj = (Rollercoaster) o;
                if(obj.isSimulated() == this.isSimulated())
                    return true;
            }       
        }
        return false;
    }
    @Override
    public String toString() {
        String rollarcoaster = super.toString() + "\nSimulated: " + simulated;
        return rollarcoaster;
    }
}

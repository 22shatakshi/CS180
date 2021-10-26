public class Waterslide extends Ride {
    private double splashDepth;
    public Waterslide(String name, String color, int minHeight, int maxRiders, double splashDepth) {
        super(name, color, minHeight, maxRiders);
        this.splashDepth = splashDepth;
    }
    public double getSplashDepth() {
        return splashDepth;
    }
    public void setSplashDepth(double splashDepth) {
        this.splashDepth = splashDepth;
    }
    @Override
    public boolean equals(Object o) {
        if(o instanceof Waterslide) {
            // if (obj.getName().equals(this.getName()) && obj.getColor().equals(this.getColor()) && 
             //    obj.getMinHeight() == this.getMinHeight() && obj.getMaxRiders() == this.getMinHeight())
             if (super.equals(o)) {
                 Waterslide obj = (Waterslide) o;
                 if(obj.getSplashDepth() == this.getSplashDepth())
                    return true;
             }       
         }
         return false;
    }
    @Override
    public String toString() {
        String waterslide = super.toString() + "\nSplashDepth: " + 
            String.format("%.1f", splashDepth) + " feet";
        return waterslide;
    }
    
}

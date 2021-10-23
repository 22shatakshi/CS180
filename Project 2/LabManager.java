public class LabManager {
    private Lab labOne;
    private Lab labTwo;
    private Lab labThree;

    public LabManager(Lab labOne, Lab labTwo, Lab labThree) {
        this.labOne = labOne;
        this.labTwo = labTwo;
        this.labThree = labThree;
    }
    public Lab getLabOne() {
        return labOne;
    }
    public Lab getLabTwo() {
        return labTwo;
    }
    public Lab getLabThree() {
        return labThree;
    }
    public void setLabOne(Lab labOne) {
        this.labOne = labOne;
    }
    public void setLabTwo(Lab labTwo) {
        this.labTwo = labTwo;
    }
    public void setLabThree(Lab labThree) {
        this.labThree = labThree;
    }
    public int calculateTotalCapacity() {
        int capacity = 2 * (labOne.getCapacity() + labTwo.getCapacity() + labThree.getCapacity());
        return capacity;
    }
    public double calculateTotalUtilization() {
        double util = (double)(labOne.getMorning().getEnrollment() + labOne.getAfternoon().getEnrollment()
            + labTwo.getMorning().getEnrollment() + labTwo.getAfternoon().getEnrollment() +
            labThree.getMorning().getEnrollment() 
            + labThree.getAfternoon().getEnrollment()) / (double)calculateTotalCapacity();
        return util;
    }
    public int calculateAvailableSeats() {
        int available = 0;
        available += (labOne.getCapacity() * 2) - labOne.getMorning().getEnrollment() 
            - labOne.getAfternoon().getEnrollment();
        available += (labTwo.getCapacity() * 2) - labTwo.getMorning().getEnrollment() 
            - labTwo.getAfternoon().getEnrollment();
        available += (labThree.getCapacity() * 2) - labThree.getMorning().getEnrollment() 
            - labThree.getAfternoon().getEnrollment();
        return available;
    }
    public String listReservedLabs() {
        String reservedLabs = "Lab One\n" + labOne.listReservations() + "\n\nLab Two\n" +
            labTwo.listReservations() + "\n\nLab Three\n" + labThree.listReservations();
        return reservedLabs;
    }
    public String listAvailableLabs() {
        String availableLabs = "Lab One\n" + labOne.listAvailabilities() + "\n\nLab Two\n" +
            labTwo.listAvailabilities() + "\n\nLab Three\n" + labThree.listAvailabilities();
        return availableLabs;
    }

    public String addReservation(String location, String time, String name, int enrollment) {
        if (!time.equalsIgnoreCase("morning") && !time.equalsIgnoreCase("afternoon"))
            return "Error. Invalid time.";
        if (!location.equals(labOne.getLocation()) && !location.equals(labTwo.getLocation()) 
            && !location.equals(labThree.getLocation())) 
            return "Error. Invalid location.";
        if (location.equals(labOne.getLocation())) {
            if(enrollment > labOne.getCapacity())
                return "Error. Capacity exceeded";
            else if (time.equalsIgnoreCase("morning") && labOne.getMorning().getEnrollment() != 0)
                return "Error. Invalid time.";
            else if (time.equalsIgnoreCase("afternoon") && labOne.getAfternoon().getEnrollment() != 0)
                return "Error. Invalid time.";
            else {
                Session add = new Session(name, enrollment);
                if (time.equalsIgnoreCase("morning")) 
                    labOne.setMorning(add);
                else
                    labOne.setAfternoon(add); 
                return "Reservation added!";
            }
        }
        if (location.equals(labTwo.getLocation())) {
            if(enrollment > labTwo.getCapacity())
                return "Error. Capacity exceeded";
            else if (time.equalsIgnoreCase("morning") && labTwo.getMorning().getEnrollment() != 0)
                return "Error. Invalid time.";
            else if (time.equalsIgnoreCase("afternoon") && labTwo.getAfternoon().getEnrollment() != 0)
                return "Error. Invalid time.";
            else {
                Session add = new Session(name, enrollment);
                if (time.equalsIgnoreCase("morning")) 
                    labTwo.setMorning(add);
                else
                    labTwo.setAfternoon(add); 
                return "Reservation added!";
            }
        }
        if (location.equals(labThree.getLocation())) {
            if(enrollment > labThree.getCapacity())
                return "Error. Capacity exceeded";
            else if (time.equalsIgnoreCase("morning") && labThree.getMorning().getEnrollment() != 0)
                return "Error. Invalid time.";
            else if (time.equalsIgnoreCase("afternoon") && labThree.getAfternoon().getEnrollment() != 0)
                return "Error. Invalid time.";
            else {
                Session add = new Session(name, enrollment);
                if (time.equalsIgnoreCase("morning")) 
                    labThree.setMorning(add);
                else
                    labThree.setAfternoon(add); 
                return "Reservation added!";
            }
        }
        return null;
    }
    public String removeReservation(String location, String time) {
        if (!time.equalsIgnoreCase("morning") && !time.equalsIgnoreCase("afternoon"))
            return "Error. Invalid time.";
        if (!location.equals(labOne.getLocation()) && !location.equals(labTwo.getLocation()) 
            && !location.equals(labThree.getLocation())) 
            return "Error. Invalid location.";
        if (location.equals(labOne.getLocation())) {
            if (time.equalsIgnoreCase("morning") && labOne.getMorning().getEnrollment() == 0)
                return "Error. Invalid time.";
            else if (time.equalsIgnoreCase("afternoon") && labOne.getAfternoon().getEnrollment() == 0)
                return "Error. Invalid time.";
            else {
                if (time.equalsIgnoreCase("morning")) {
                    labOne.getMorning().setName("");
                    labOne.getMorning().setEnrollment(0);
                }
                else {
                    labOne.getAfternoon().setName("");
                    labOne.getAfternoon().setEnrollment(0);
                } 
                return "Reservation removed!";
            }
        }
        if (location.equals(labTwo.getLocation())) {
            if (time.equalsIgnoreCase("morning") && labTwo.getMorning().getEnrollment() == 0)
                return "Error. Invalid time.";
            else if (time.equalsIgnoreCase("afternoon") && labTwo.getAfternoon().getEnrollment() == 0)
                return "Error. Invalid time.";
            else {
                if (time.equalsIgnoreCase("morning")) {
                    labTwo.getMorning().setName("");
                    labTwo.getMorning().setEnrollment(0);
                }
                else {
                    labTwo.getAfternoon().setName("");
                    labTwo.getAfternoon().setEnrollment(0);
                } 
                return "Reservation removed!";
            }
        }
        if (location.equals(labThree.getLocation())) {
            if (time.equalsIgnoreCase("morning") && labThree.getMorning().getEnrollment() == 0)
                return "Error. Invalid time.";
            else if (time.equalsIgnoreCase("afternoon") && labThree.getAfternoon().getEnrollment() == 0)
                return "Error. Invalid time.";
            else {
                if (time.equalsIgnoreCase("morning")) {
                    labThree.getMorning().setName("");
                    labThree.getMorning().setEnrollment(0);
                }
                else {
                    labThree.getAfternoon().setName("");
                    labThree.getAfternoon().setEnrollment(0);
                } 
                return "Reservation removed!";
            }
        }
        return null;
    }
    public String modifyReservation(String location, String time, String name, int enrollment) {
        if (!time.equalsIgnoreCase("morning") && !time.equalsIgnoreCase("afternoon"))
            return "Error. Invalid time.";
        if (!location.equals(labOne.getLocation()) && !location.equals(labTwo.getLocation()) 
            && !location.equals(labThree.getLocation())) 
            return "Error. Invalid location.";
        if (location.equals(labOne.getLocation())) {
            if(enrollment > labOne.getCapacity())
                return "Error. Capacity exceeded";
            else if (time.equalsIgnoreCase("morning") && labOne.getMorning().getEnrollment() == 0)
                return "Error. Invalid time.";
            else if (time.equalsIgnoreCase("afternoon") && labOne.getAfternoon().getEnrollment() == 0)
                return "Error. Invalid time.";
            else {
                if (time.equalsIgnoreCase("morning")) {
                    labOne.getMorning().setName(name);
                    labOne.getMorning().setEnrollment(enrollment);
                }
                else {
                    labOne.getAfternoon().setName(name);
                    labOne.getAfternoon().setEnrollment(enrollment);
                }
                return "Reservation modified!";
            }
        }
        if (location.equals(labTwo.getLocation())) {
            if(enrollment > labTwo.getCapacity())
                return "Error. Capacity exceeded";
            else if (time.equalsIgnoreCase("morning") && labTwo.getMorning().getEnrollment() == 0)
                return "Error. Invalid time.";
            else if (time.equalsIgnoreCase("afternoon") && labTwo.getAfternoon().getEnrollment() == 0)
                return "Error. Invalid time.";
            else {
                if (time.equalsIgnoreCase("morning")) {
                    labTwo.getMorning().setName(name);
                    labTwo.getMorning().setEnrollment(enrollment);
                }
                else {
                    labTwo.getAfternoon().setName(name);
                    labTwo.getAfternoon().setEnrollment(enrollment);
                } 
                return "Reservation modified!";
            }
        }
        if (location.equals(labThree.getLocation())) {
            if(enrollment > labThree.getCapacity())
                return "Error. Capacity exceeded";
            else if (time.equalsIgnoreCase("morning") && labThree.getMorning().getEnrollment() == 0)
                return "Error. Invalid time.";
            else if (time.equalsIgnoreCase("afternoon") && labThree.getAfternoon().getEnrollment() == 0)
                return "Error. Invalid time.";
            else {
                if (time.equalsIgnoreCase("morning")) {
                    labThree.getMorning().setName(name);
                    labThree.getMorning().setEnrollment(enrollment);
                }
                else {
                    labThree.getAfternoon().setName(name);
                    labThree.getAfternoon().setEnrollment(enrollment);
                } 
                return "Reservation modified!";
            }
        }
        return null;
    }
    public String toString() {
        String str = "LabManager{" + labOne.toString() + ", " + labTwo.toString() + ", " +
            labThree.toString() + "}";
        return str;
    }
}

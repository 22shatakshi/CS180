public class Session {
    private String name;
    private int enrollment;
    
    public Session(String name, int enrollment) {
        this.name = name;
        this.enrollment = enrollment;
    }
    public Session() {
        this.name = "";
        this.enrollment = 0;
    }
    public String getName() {
        return name;
    }
    public int getEnrollment() {
        return enrollment;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }
    public String toString() {
        String session = "Session{Name - " + name + ", Enrollment - " + enrollment + "}";
        return session;
    } 
}

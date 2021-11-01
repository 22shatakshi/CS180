public class Employee extends Person {
    private final int hourlyRate;

    public Employee(String name, int age, int hourlyRate) {
        super(name, age);
        if (hourlyRate < 0)
            throw new IllegalArgumentException();
        this.hourlyRate = hourlyRate;
    }
    public Employee(Employee employee) {
        super(employee);
        this.hourlyRate = employee.hourlyRate;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }
    public int calculateIncome(int hours) {
        if(hours < 0)
            throw new IllegalArgumentException();
        return hours*hourlyRate;
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) 
            return true;
        if (!(object instanceof Employee))
            return false;
        if (!super.equals(object))
            return false;
        Employee employee = (Employee) object;
        return super.equals(object) && getHourlyRate() == employee.getHourlyRate();
    }

    @Override
    public String toString() {
        return "Employee<name=" + getName() +
                ", age=" + getAge() +
                ", hourlyRate=" + hourlyRate +
                ">";
    }
}
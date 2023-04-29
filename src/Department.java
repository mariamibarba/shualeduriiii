public class Department {
    private String name;
    private String location;
    private int employeeCount;

    public Department(String name, String location, int employeeCount) {
        this.name = name;
        this.location = location;
        this.employeeCount = employeeCount;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    @Override
    public String toString() {
        return "Department{name='" + name + "', location='" + location + "', employeeCount=" + employeeCount + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Department)) {
            return false;
        }
        Department other = (Department) obj;
        return name.equals(other.name) && location.equals(other.location) && employeeCount == other.employeeCount;
    }
}


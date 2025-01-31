package domain;

import java.util.Comparator;

public class Employee {

    public static class EmployeeComparator<T extends Employee>
            implements Comparator<Employee> {

        private String sortType;

        public EmployeeComparator() {
        }

        public EmployeeComparator(String sortType) {
            this.sortType = sortType;
        }

        @Override
        public int compare(Employee o1, Employee o2) {

            if (sortType.equalsIgnoreCase("yearStarted")) {
                return o1.yearStarted - o2.yearStarted;
            }

            return o1.name.compareTo(o2.name);
        }
    }

    private int employeeID;
    private String name;
    private int salary;
    private int yearStarted;

    public Employee() {
    }

    public Employee(int employeeID, String name, int salary, int yearStarted) {
        this.employeeID = employeeID;
        this.name = name;
        this.salary = salary;
        this.yearStarted = yearStarted;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getYearStarted() {
        return yearStarted;
    }

    public void setYearStarted(int yearStarted) {
        this.yearStarted = yearStarted;
    }

    @Override
    public String toString() {
        return "%d %-8s %d %d".formatted(employeeID, name, salary, yearStarted);
    }
}

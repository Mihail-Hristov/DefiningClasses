package company.roster;

import company.roster.Employee;

import java.util.List;

public class Department {

    private String name;
    private List<Employee> employees;

    public Department(String name, List<Employee> employers) {
        this.name = name;
        this.employees = employers;

    }

    public List<Employee> getEmployers() {
        return this.employees;
    }

    public double gerAverageSalary() {
        return this.employees
                .stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }

    public String getName() {
        return this.name;
    }

}

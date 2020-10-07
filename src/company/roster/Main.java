package company.roster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());

        Map<String, Department> departments = new HashMap<>();

        for (int i = 0; i < numberOfLines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];


            if (tokens.length < 5){
                Employee person = new Employee(name, salary, position, department);
                addToDepartment(departments, department, person);
            }else if (tokens.length == 5) {
                if (tokens[4].contains("@")){
                    String email = tokens[4];
                    Employee person = new Employee(name, salary, position, department, email);
                    addToDepartment(departments, department, person);
                }else {
                    int age = Integer.parseInt(tokens[4]);
                    Employee person = new Employee(name, salary, position, department, age);
                    addToDepartment(departments, department, person);
                }
            }else if ( tokens.length == 6){
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                Employee person = new Employee(name, salary, position, department, email, age);
                addToDepartment(departments, department, person);
            }
        }


        Department bestDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(d -> d.getValue().gerAverageSalary()))
                .get()
                .getValue();


        System.out.println(String.format("Highest Average Salary: %s", bestDepartment.getName()));
        bestDepartment.getEmployers()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(e -> System.out.println(String.format("%s %.2f %s %d", e.getName(),e.getSalary(), e.getEmail(), e.getAge())));



    }

    public static void addToDepartment(Map<String, Department> departments, String department, Employee person) {
        departments.putIfAbsent(department, new Department(department, new ArrayList<>()));
        Department currentDepartment = departments.get(department);
        currentDepartment.getEmployers().add(person);
        departments.put(department, currentDepartment);
    }
}

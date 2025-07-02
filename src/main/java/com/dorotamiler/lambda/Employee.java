package com.dorotamiler.lambda;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee {

    private final String name;
    private final int age;
    private final String department;
    private final double salary;

    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s (age %d) – %s: $%.2f", name, age, department, salary);
    }

    /**
     * Main method to demonstrate the use of Stream API to process a list of employees.
     *
     * @param args command line arguments (not used)
     */

    public static void main(String[] args) {

        // Creation of a sample list of employees
        List<Employee> employees = List.of(
                new Employee("Alice", 28, "Engineering", 85_000),
                new Employee("Bob", 34, "Marketing", 70_000),
                new Employee("Carol", 41, "Engineering", 105_000),
                new Employee("David", 25, "HR", 50_000),
                new Employee("Eve", 30, "Engineering", 95_000),
                new Employee("Frank", 38, "Marketing", 82_000),
                new Employee("Grace", 29, "HR", 55_000),
                new Employee("Hank", 45, "Engineering", 120_000),
                new Employee("Ivy", 32, "Marketing", 68_000),
                new Employee("Jack", 50, "HR", 60_000)
        );

        // Task 1: Get names of employees older than 30
        List<String> namesOverThirty = employees.stream().
                filter(employee -> employee.getAge() > 30).
                map(employee -> employee.getName()).
                collect(Collectors.toList());
//        namesOverThirty.forEach(System.out::println);

        // Task 2: Sort employees by salary (descending)
        List<Employee> sortedBySalary = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());
//        sortedBySalary.forEach(System.out::println);

        // Task 3: Extract a list of all employee names
        List<String> namesOfEmployees = employees.stream()
                .map(employee -> employee.getName())
                .collect(Collectors.toList());
//        namesOfEmployees.forEach(System.out::println);

        // Task 4: Find the highest salary
        double highestSalary = employees.stream()
                .mapToDouble(employee -> employee.getSalary())
                .max()
                .orElseThrow(() -> new RuntimeException("No employees found"));
//        .orElse(0.0);
//        System.out.println(highestSalary);

        // Task 5: Group employees by department
        Map<String, List<Employee>> groupedEmployees = employees.stream()
                .collect(Collectors.groupingBy
                        (Employee::getDepartment, Collectors.toList()));
//        groupedEmployees.entrySet()
//                .forEach(System.out::println);
//        or

        // Example output of grouped employees
        groupedEmployees.forEach((department, employeeList)
                -> System.out.println(department + ":" + employeeList));

        // Task 6: Calculate average age of employees in each department
        Map<String, Double> averageAgeByDepartment = employees.stream()
                .collect(Collectors.groupingBy
                        (Employee::getDepartment,
                                Collectors.averagingInt(Employee::getAge)));

        // Task 7: Get names of Engineering employees with salary > $90k, sorted alphabetically
        List<String> namesList = employees.stream()
                .filter(e -> e.getDepartment().equals("Engineering") && e.getSalary() > 90_000)
                .map(Employee::getName)
                .sorted()
                .collect(Collectors.toList());
//        namesList.forEach(System.out::println);

        // Additional example: Sum of squares of odd numbers from 1 to 10
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer sumOfSquaresOfOdds = numbers.stream()
                .filter(number -> number % 2 != 0)
                .mapToInt(number -> number * number)
                .sum();

        // Optional debug version:
        /*
        int debugSum = IntStream.rangeClosed(1, 10)
                .filter(n -> n % 2 != 0)
                .peek(n -> System.out.println("Filtered: " + n))
                .map(n -> n * n)
                .peek(n -> System.out.println("Squared: " + n))
                .sum();
        System.out.println("Sum: " + debugSum);
        */

    }
}
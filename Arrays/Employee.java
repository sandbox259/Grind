package Arrays;

import java.util.Arrays;

class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private int salary;

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int compareTo(Employee employee) {
        if (age == employee.age) {
            return (salary - employee.salary);
        }
        return age - employee.age;
    }

    public String toString() {
        return String.format("Name: %s , Salary: %d, Age:%d", name, salary, age);
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[4];
        employees[0] = new Employee("Suresh", 45, 5000);
        employees[1] = new Employee("Ramesh", 62, 10000);
        employees[2] = new Employee("Lokesh", 23, 4000);
        employees[3] = new Employee("Bhavesh", 40, 10000);
        Arrays.sort(employees);

        System.out.println("After sorting employees: " + Arrays.toString(employees));

    }

}

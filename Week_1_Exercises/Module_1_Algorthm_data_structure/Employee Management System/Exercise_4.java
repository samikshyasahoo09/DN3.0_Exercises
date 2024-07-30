import java.util.Arrays;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }
}

class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add employee
    void addEmployee(Employee employee) {
        if (size >= employees.length) {
            employees = Arrays.copyOf(employees, size * 2);
        }
        employees[size++] = employee;
    }

    // Search employee
    Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse employees
    void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete employee
    void deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                employees[i] = employees[size - 1];
                employees[size - 1] = null;
                size--;
                return;
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(2);
        
        ems.addEmployee(new Employee(1, "Ram", "Developer", 70000));
        ems.addEmployee(new Employee(2, "Vikash", "Designer", 65000));
        
        System.out.println("All employees:");
        ems.traverseEmployees();
        
        System.out.println("\nSearching for employee with ID 1:");
        System.out.println(ems.searchEmployee(1));
        
        ems.deleteEmployee(1);
        
        System.out.println("\nAll employees after deletion:");
        ems.traverseEmployees();
    }
}

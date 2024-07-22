package Day_7_OOPS_2.EmployeeManagementSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// Employee class to represent each employee
class Employee {
    private int id;
    private String name;
    private String department;
    private Employee manager;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", manager=" + (manager != null ? manager.getName() : "None") +
                '}';
    }
}

// Employee Record Management System class
public class EmployeeRecordSystem {
    private List<Employee> employees;

    public EmployeeRecordSystem() {
        employees = new ArrayList<>();
    }

    // Add an employee to the system
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Update an employee's details
    public void updateEmployee(Employee employee) {
        Employee existingEmployee = findEmployeeById(employee.getId());
        if (existingEmployee != null) {
            existingEmployee.setName(employee.getName());
            existingEmployee.setDepartment(employee.getDepartment());
            existingEmployee.setManager(employee.getManager());
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found with ID: " + employee.getId());
        }
    }

    // Delete an employee from the system
    public void deleteEmployee(int employeeId) {
        Employee employee = findEmployeeById(employeeId);
        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found with ID: " + employeeId);
        }
    }

    // Search employees by name
    public List<Employee> searchEmployeesByName(String name) {
        return employees.stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    // Search employees by department
    public List<Employee> searchEmployeesByDepartment(String department) {
        return employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }

    // Find an employee by ID
    private Employee findEmployeeById(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                return employee;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        EmployeeRecordSystem system = new EmployeeRecordSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Record Management System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Search Employees by Name");
            System.out.println("5. Search Employees by Dept");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter employee department: ");
                    String department = scanner.nextLine();

                    Employee newEmployee = new Employee(id, name, department);
                    system.addEmployee(newEmployee);
                    System.out.println("Employee added successfully.");
                    break;

                case 2:
                    System.out.print("Enter employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    Employee existingEmployee = system.findEmployeeById(updateId);
                    if (existingEmployee != null) {
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        existingEmployee.setName(newName);

                        System.out.print("Enter new department: ");
                        String newDepartment = scanner.nextLine();
                        existingEmployee.setDepartment(newDepartment);

                        System.out.println("Employee details updated successfully.");
                    } else {
                        System.out.println("Employee not found with ID: " + updateId);
                    }
                    break;

                case 3:
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    system.deleteEmployee(deleteId);
                    break;

                case 4:
                    System.out.print("Enter employee name to search: ");
                    String searchName = scanner.nextLine();

                    List<Employee> searchResults = system.searchEmployeesByName(searchName);
                    if (!searchResults.isEmpty()) {
                        System.out.println("Search results for name '" + searchName + "': ");
                        for (Employee result : searchResults) {
                            System.out.println(result);
                        }
                    } else {
                        System.out.println("No employees found with name '" + searchName + "'.");
                    }
                    break;

                case 5:
                    // Search by department logic
                    System.out.print("Enter department to search: ");
                    String searchDepartment = scanner.nextLine();

                    List<Employee> searchResultsByDept = system.searchEmployeesByDepartment(searchDepartment);
                    if (!searchResultsByDept.isEmpty()) {
                        System.out.println("Search results for department '" + searchDepartment + "': ");
                        for (Employee result : searchResultsByDept) {
                            System.out.println(result);
                        }
                    } else {
                        System.out.println("No employees found in department '" + searchDepartment + "'.");
                    }
                    break;
                    
                case 6:
                    System.out.println("Exiting Employee Record Management System.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
        }
    }
}

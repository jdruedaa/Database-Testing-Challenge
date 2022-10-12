package utils.crud;

import entities.Employee;
import queries.EmployeeQuery;

import java.sql.Date;
import java.util.List;

public class EmployeeCrud {

    EmployeeQuery employeeQuery = new EmployeeQuery();
    List<Employee> employeeList;
    Employee employee;

    //Execute queries and print the results

    public void getAllEmployees(){
        employeeList = employeeQuery.getAllEmployees();

        if(employeeList.size() != 0){
            for (Employee com:
                    employeeList) {
                printEmployeeInfo(com);
                System.out.println("");
            }
        }else{
            System.out.println("No employees were found");
        }
    }

    public void getEmployeeById(int id){
        employee = employeeQuery.getEmployeeById(id);

        if(employee != null){
            printEmployeeInfo(employee);
        }else {
            System.out.println("The employee with id '" + id + "' wasn't found");
        }
    }

    public void getEmployeeByLastName(String lastName){
        employeeList = employeeQuery.getEmployeeByLastNameCreateQuery(lastName);

        if(employeeList.size() != 0){
            for (Employee com:
                    employeeList) {
                printEmployeeInfo(com);
                System.out.println("");
            }
        }else {
            System.out.println("The employee with name '" + lastName + "' wasn't found");
        }
    }

    public void insertNewEmployee(int id,String firstName,String lastName,Double salary, String email, String address
            , Date birthDate, String phoneNumber, int idCompany){

        employee = new Employee();
        employee.setId(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setSalary(salary);
        employee.setEmail(email);
        employee.setAddress(address);
        employee.setBirthDate(birthDate);
        employee.setIdCompany(idCompany);
        employee.setPhoneNumber(phoneNumber);

        int employeeId = employeeQuery.insertEmployee(employee);

        if(employeeId != -1){
            System.out.println("A new employee with id " + employeeId + " was created");
        }else {
            System.out.println("No employee was created");
        }
    }

    public void updateEmployee(int id, String firstName, String lastName, Double salary, String email, String address
            , Date birthDate, String phoneNumber, int idCompany){

        int employeeId = employeeQuery.updateEmployee(id,firstName,lastName,salary,email,address, birthDate,
                idCompany, phoneNumber);

        if(employeeId != -1){
            System.out.println("The employee with id " + id + " was updated");
        }else {
            System.out.println("No employee was updated");
        }

    }

    public void deleteEmployee(int id){

        int employeeId = employeeQuery.deleteEmployee(id);

        if(employeeId != -1){
            System.out.println("The employee with id " + id + " was deleted");
        }else {
            System.out.println("No employee was deleted");
        }

    }

    //print the employee information
    public void printEmployeeInfo(Employee employee){
        System.out.println("Employee Id: "+employee.getId());
        System.out.println("Employee firstName: " + employee.getFirstName());
        System.out.println("Employee lastName: " + employee.getLastName());
        System.out.println("Employee email: " + employee.getEmail());
        System.out.println("Employee salary: " + employee.getSalary());
        System.out.println("Employee address: " + employee.getAddress());
        System.out.println("Employee birthDate" + employee.getBirthDate());
    }


}

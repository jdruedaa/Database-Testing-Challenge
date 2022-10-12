import org.testng.annotations.Test;
import utils.crud.EmployeeCrud;
import utils.parsers.DateParser;

import java.sql.Date;

public class EmployeeTest {

    EmployeeCrud employeeCrud = new EmployeeCrud();
    DateParser dateParser = new DateParser();

    @Test
    public void getAllEmployees(){
        employeeCrud.getAllEmployees();
    }

    @Test
    public void getEmployeeByLastName(){
        String lastName = "Kameja";
        employeeCrud.getEmployeeByLastName(lastName);
    }

    @Test
    public void getEmployeeById(){
        int id = 83;
        employeeCrud.getEmployeeById(id);
    }

    @Test
    public void insertNewEmployee(){
        int id = 6;
        String firstName = "Danny";
        String lastName = "Ocean";
        double salary = 1500;
        String email = "dOcean@gmail.com";
        String address = "Cll 3 #4-78";
        Date birthDate = dateParser.parseDate("1983-4-4");
        int idCompany = 1;
        String phoneNumber = "12398737";

        employeeCrud.insertNewEmployee(id,firstName,lastName,salary,email,address,birthDate,phoneNumber,idCompany);
        employeeCrud.getEmployeeById(id);
    }

    @Test
    public void updateEmployee(){
        int id = 6;
        String firstName = "Danny";
        String lastName = "Ocean";
        double salary = 1700;
        String email = "dOcean@gmail.com";
        String address = "Cll 3 #4-78";
        Date birthDate = dateParser.parseDate("1983-4-4");
        int idCompany = 1;
        String phoneNumber = "12398737";

        employeeCrud.getEmployeeById(id);
        employeeCrud.updateEmployee(id,firstName,lastName,salary,email,address,birthDate,phoneNumber,idCompany);
        employeeCrud.getEmployeeById(id);
    }

    @Test
    public void deleteEmployee(){
        int id = 6;
        employeeCrud.getEmployeeById(id);
        employeeCrud.deleteEmployee(id);
        employeeCrud.getEmployeeById(id);
    }

}

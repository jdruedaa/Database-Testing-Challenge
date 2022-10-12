package queries;

import entities.Company;
import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import utils.JpaManager;

import java.sql.Date;
import java.util.List;

public class EmployeeQuery {

    private final EntityManager manager;
    private Employee employee;
    private List<Employee> listEmployee;
    private final EntityTransaction transaction;


    public EmployeeQuery(){
        //Create new entity manager and transaction
        JpaManager jpaManager = new JpaManager();
        manager = jpaManager.getManager();
        transaction = manager.getTransaction();
    }

    public List<Employee> getAllEmployees() {
        //Get all employees using 'createQuery' operation
        listEmployee =  manager.createQuery("FROM employee").getResultList();
        return listEmployee;
    }

    public Employee getEmployeeById(int id) {

        //Get employee by id using 'find' operation
        employee = manager.find(Employee.class,id);
        return employee;
    }

    public Employee getEmployeeByLastNameFindOperation(String lastName) {
        //Get employee by last name using 'find' operation
        employee = manager.find(Employee.class,lastName);
        return employee;
    }

    public List<Employee> getEmployeeByLastNameCreateQuery(String lastName) {
        //Get employees by name using 'createQuery' operation
        listEmployee = manager.createQuery("SELECT e FROM employee e WHERE e.lastName = :lastName")
                .setParameter("lastName",lastName)
                .getResultList();
        return listEmployee;
    }

    public int insertEmployee(Employee employee){
        //Begin transaction
        transaction.begin();
        //Create a new employee using 'persist' operation
        manager.persist(employee);
        try{
            //Commit transaction
            transaction.commit();
            return employee.getId();
        }catch(Exception e){
            //Rollback transaction
            transaction.rollback();
            System.out.println("Database wasn't updated");
            return -1;
        }
    }

    public int updateEmployee(int id,String firstName,String lastName,Double salary, String email, String address
            , Date birthDate, int idCompany, String phoneNumber){
        int transactionResult = -1;
        employee = getEmployeeById(id);
        if(employee != null){
            //Update employee attributes
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setSalary(salary);
            employee.setEmail(email);
            employee.setAddress(address);
            employee.setBirthDate(birthDate);
            employee.setPhoneNumber(phoneNumber);
            employee.setIdCompany(idCompany);

            //Begin transaction
            transaction.begin();
            //Update employee using 'merge' operation
            manager.merge(employee);

            try{
                //Commit transaction
                transaction.commit();
                transactionResult = employee.getId();
            }catch(Exception e) {
                //Rollback transaction
                transaction.rollback();
                System.out.println("Database wasn't updated");
            }
        }else{
            System.out.println("Employee wasn't found");
        }
        return transactionResult;
    }

    public int deleteEmployee(int id){
        int transactionResult = -1;
        employee = getEmployeeById(id);

        if(employee != null){

            //Begin transaction
            transaction.begin();
            //Delete employee using 'remove' operation
            manager.remove(employee);

            try{
                //Commit transaction
                transaction.commit();
                transactionResult = employee.getId();

            }catch(Exception e) {
                //Rollback transaction
                transaction.rollback();
                System.out.println("Database wasn't updated");
            }

        }else{
            System.out.println("Employee wasn't found");
        }
        return transactionResult;
    }



}

package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

//Define entity and table name
@Entity(name="employee")
@Table(name="employee")
public class Employee {

    //Define columns
    @Id
    @Column(name = "idEmployee",nullable = false)
    private int id;

    @Column(name = "firstName", nullable = false,length = 45)
    private String firstName;

    @Column(name = "lastName",nullable = false,length = 45)
    private String lastName;

    @Column(name = "email",nullable = false,length = 45)
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "address",length = 45)
    private String address;

    @Column(name = "salary")
    private double salary;

    @Column(name = "birthDate")
    private Date birthDate;

    @Column(name = "idCompany")
    private int idCompany;

    //empty constructor
    public Employee() {
    }

    //constructor

    public Employee(int id, String firstName, String lastName, String email, String phoneNumber, String address
            , double salary, Date birthDate, int idCompany) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
        this.birthDate = birthDate;
        this.idCompany = idCompany;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}

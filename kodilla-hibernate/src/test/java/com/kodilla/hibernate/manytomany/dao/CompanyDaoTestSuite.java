package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @AfterEach
    void cleanUp() {
        companyDao.deleteAll();
    }

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);
    }

    @Test
    void testFindCompaniesWhoseNameBeginsWithTheFirstThreeLetters() {
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");
        Company softwareMatter = new Company("Software Matter");
        Company softwareMaesters = new Company("Software Maesters");

        //When
        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);
        companyDao.save(softwareMatter);
        companyDao.save(softwareMaesters);

        List<Company> companiesWhoseNameBeginsWithTheFirstThreeLetters = companyDao.findCompaniesWhoseNameBeginsWithTheFirstThreeLetters("Sof");

        //Then
        assertEquals(3, companiesWhoseNameBeginsWithTheFirstThreeLetters.size());
    }

    @Test
    void testFindEmployeesByLastName() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee michaelClarckson = new Employee("Michael", "Clarckson");
        Employee johnClarckson = new Employee("John", "Clarckson");
        Employee peterClarckson = new Employee("Peter", "Clarckson");
        Employee markClarckson = new Employee("Mark", "Clarckson");
        Employee lindaCleve = new Employee("Linda", "Cleve");

        Company softwareMachine = new Company("Software Machine");

        softwareMachine.getEmployees().add(johnSmith);
        softwareMachine.getEmployees().add(stephanieClarckson);
        softwareMachine.getEmployees().add(michaelClarckson);
        softwareMachine.getEmployees().add(johnClarckson);
        softwareMachine.getEmployees().add(peterClarckson);
        softwareMachine.getEmployees().add(markClarckson);
        softwareMachine.getEmployees().add(lindaCleve);

        johnSmith.getCompanies().add(softwareMachine);
        stephanieClarckson.getCompanies().add(softwareMachine);
        michaelClarckson.getCompanies().add(softwareMachine);
        johnClarckson.getCompanies().add(softwareMachine);
        peterClarckson.getCompanies().add(softwareMachine);
        markClarckson.getCompanies().add(softwareMachine);
        lindaCleve.getCompanies().add(softwareMachine);

        //When
        companyDao.save(softwareMachine);
        List<Employee> employeesByLastName = employeeDao.findEmployeesByLastName("Clarckson");

        //Then
        assertEquals(5, employeesByLastName.size());
    }
}
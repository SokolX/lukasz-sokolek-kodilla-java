package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFacade.class);

    private CompanyDao companyDao;

    private EmployeeDao employeeDao;

    @Autowired
    public CompanyFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> findCompanies(String company) throws CompanyException {
        LOGGER.info("Starting findCompanies by " + company);
        try {
            List<Company> companiesByName = companyDao.findCompaniesByPhraseOfName(company);
            if (companiesByName.isEmpty()) {
                LOGGER.error(CompanyException.ERR_NO_SUCH_COMPANY);
                throw new CompanyException(CompanyException.ERR_NO_SUCH_COMPANY);
            }
            return companiesByName;
        } finally {
            LOGGER.info("Finished findCompanies");
        }
    }

    public List<Employee> findEmployees(String employee) throws CompanyException {
        LOGGER.info("Starting findEmployees by  " + employee);
        try {
            List<Employee> employeesByName = employeeDao.findEmployeesByPhraseOfLastname(employee);
            if (employeesByName.size() == 0) {
                LOGGER.error(CompanyException.ERR_NO_SUCH_EMPLOYEE);
                throw new CompanyException(CompanyException.ERR_NO_SUCH_EMPLOYEE);
            }
            return employeesByName;
        } finally {
            LOGGER.info("Finished findEmployees");
        }
    }
}

package com.jaroso.hibernate;

import com.jaroso.hibernate.entities.Address;
import com.jaroso.hibernate.entities.Company;
import com.jaroso.hibernate.entities.Employee;
import com.jaroso.hibernate.repositories.AddressRepository;
import com.jaroso.hibernate.repositories.CompanyRepository;
import com.jaroso.hibernate.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class HibernateApplication  implements CommandLineRunner {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CompanyRepository companyRepository;

	public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
		System.out.println("APP SPRING BOOT HIBERNATE");
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		Address ad1 = new Address(null, "Mi casa", "Vera", "España", "04720");
		Address ad2 = new Address(null, "Mi otra casa", "Garrucha", "España", "04720");

		addressRepository.save(ad1);
		addressRepository.save(ad2);

		Company c1 = new Company(null, "Google",
				"Calle Google", new HashSet<>());

		companyRepository.save(c1);

		var emp1 = new Employee(null, "Juan", 30, ad1, c1);
		var emp2 = new Employee(null, "Ana", 30, ad2, c1);

		employeeRepository.save(emp1);
		employeeRepository.save(emp2);

		employeeRepository.findAll().forEach(System.out::println);
		companyRepository.findById(1L).ifPresent(System.out::println);
		addressRepository.findAddressByCity("Vera").forEach(System.out::println);

	}
}

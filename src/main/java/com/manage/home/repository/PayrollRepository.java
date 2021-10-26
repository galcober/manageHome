package com.manage.home.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.manage.home.model.Payroll;

public interface PayrollRepository extends CrudRepository<Payroll, String> {

	@Query(value="select pdf from payroll p where p.month = :month and p.year = :year", nativeQuery=true)
	public String findByMonthAndYear(@Param("month") int month, @Param("year") int year);

}

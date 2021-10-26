package com.manage.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manage.home.model.Payroll;
import com.manage.home.repository.PayrollRepository;

@Controller
@RequestMapping(path="/payroll")
public class PayrollController {
	
	@Autowired
	private PayrollRepository payrollRepository;
	
	@PostMapping(path="/add")
	public @ResponseBody String add (
			@RequestParam int month, int year, String pdf) {
		
		Payroll payroll = new Payroll();
		payroll.setYear(year);
		payroll.setMonth(month);
		payroll.setPdf(pdf);
		payrollRepository.save(payroll);
		
		return "Added";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Payroll> getAll() {
		return payrollRepository.findAll();
	}
	
	@GetMapping(path="/pdf/{month}/{year}")
	public @ResponseBody String getPdfByMonthAndYear(@PathVariable int month, @PathVariable int year) {
		String pdfBase64 = payrollRepository.findByMonthAndYear(month, year);
//		return pdfBase64;
//		return "<embed src=\"data:application/pdf;base64,"+pdfBase64+" \" type=\"application/pdf\" width=\"100%\" height=\"600px\"/>";
		return "<iframe src=\"data:application/pdf;base64,"+pdfBase64+" \" height=\"100%\" width=\"100%\"></iframe>";
	}

}

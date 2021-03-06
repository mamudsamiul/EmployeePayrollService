package com.capgemini.payrolltest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.capgemini.employeepayrollservice.EmployeePayrollData;
import com.capgemini.employeepayrollservice.EmployeePayrollService;
import com.capgemini.employeepayrollservice.EmployeePayrollService.IOService;

public class EmployeePayrollServiceTest {
	@Test
	public void given3EmployeeEntries_ShouldMatchTheEmployeeEntries_WhenWrittenToTheFile() {
		EmployeePayrollData[] empArray = { new EmployeePayrollData(200456, "Warren Buffet", 500000.0),
				new EmployeePayrollData(200457, "Amanico Ortega", 200000.0),
				new EmployeePayrollData(200551, "Larry Ellison", 800000.0) };
		EmployeePayrollService employeePayrollService;
		employeePayrollService = new EmployeePayrollService(Arrays.asList(empArray));
		employeePayrollService.writeData(IOService.FILE_IO);
		long entries = employeePayrollService.countEntries(IOService.FILE_IO);
		assertEquals(3, entries);
	}

	@Test
	public void given3EmployeeEntries_ShouldMatchTheEmployeeEntries_WhenWrittenToTheFile_AndPrintTheSame() {
		EmployeePayrollData[] empArray = { new EmployeePayrollData(200456, "Warren Buffet", 500000.0),
				new EmployeePayrollData(200457, "Amanico Ortega", 200000.0),
				new EmployeePayrollData(200551, "Larry Ellison", 800000.0) };
		EmployeePayrollService employeePayrollService;
		employeePayrollService = new EmployeePayrollService(Arrays.asList(empArray));
		employeePayrollService.writeData(IOService.FILE_IO);
		long entries = employeePayrollService.countEntries(IOService.FILE_IO);
		employeePayrollService.printData(IOService.FILE_IO); // print method called
		assertEquals(3, entries);
	}

	@Test
	public void given3EmployeeEntries_ShouldMatchTheEmployeeEntries_WhenWrittenToTheFile_AndReadTheEmployeePayrollFile() {
		EmployeePayrollData[] empArray = { new EmployeePayrollData(200456, "Warren Buffet", 500000.0),
				new EmployeePayrollData(200457, "Amanico Ortega", 200000.0),
				new EmployeePayrollData(200551, "Larry Ellison", 800000.0) };
		EmployeePayrollService employeePayrollService;
		employeePayrollService = new EmployeePayrollService(Arrays.asList(empArray));
		employeePayrollService.writeData(IOService.FILE_IO);
		long entries = employeePayrollService.countEntries(IOService.FILE_IO);
		employeePayrollService.printData(IOService.FILE_IO);
		List<EmployeePayrollData> employeeList = employeePayrollService.readData(IOService.FILE_IO);
		System.out.println(employeeList);
		assertEquals(3, entries);
	}
}

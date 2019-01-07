package com.cg.payroll.tests;
import  com.cg.payroll.beans.*;


import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.junit.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;
import com.cg.payroll.util.PayrollUnit;
public class PayrollServicesTest {
	private static PayrollServices payrollservices;
 @BeforeClass
 public static void setUpTestEnv() {
	 payrollservices=new PayrollServicesImpl(); 
 }
 @Before
 public  void setUpTestData() {
	 Associate associate1=new Associate(101,6000, "Tharani", "Bose", "IT", "analyst", "FHA612GF", "thara@gmail.com", new Salary(6000, 1500, 1200), new BankDetails(121324325, "HDFC", "hdfc26564g"));	 
	 Associate associate2=new Associate(102,2000, "Karthiyayini", "P", "IT", "Data Analyst", "AF60154KL", "karthi@gmail.com", new Salary(5000, 1500, 1200), new BankDetails(13001212, "HDFC", "hdfc30458g"));
	 PayrollUnit.associates.put(associate1.getAssociateID(), associate1);
	 PayrollUnit.associates.put(associate2.getAssociateID(), associate2);
	 PayrollUnit.ASSOCIATE_ID_COUNTER=102;
 }
	@Test
	public  void testAcceptAssociateDetailsForValidData() {
		 int expectedAssociateId=103;
		 int actualAssociateId=payrollservices.acceptAssociateDetails(2000, "Rakesh", "K", "MECH", "Mainatance Engineer", "HYFD478N", "rakesh@gmail.com'", new Salary(9000, 1500, 1200), new BankDetails(239897120, "ICICI", "icici2454s'"));
		Assert.assertEquals(expectedAssociateId, actualAssociateId); 
	}
	@Test(expected=AssociateDetailsNotFoundException.class)
	public void testGetDetailsForInValidAssociateId() throws AssociateDetailsNotFoundException{
		Associate associate=payrollservices.getAssociateDetails(222);
	}
	@Test
	public void testGetDetailsForValidAssociateId() throws AssociateDetailsNotFoundException {
		Associate expectedAssociateId=new Associate(101,6000, "Tharani", "Bose", "IT", "analyst", "FHA612GF", "thara@gmail.com", new Salary(6000, 1500, 1200), new BankDetails(121324325, "HDFC", "hdfc26564g"));
		Associate actualAssociateId=payrollservices.getAssociateDetails(101);
		Assert.assertEquals(expectedAssociateId, actualAssociateId);
	}
	@Test(expected=AssociateDetailsNotFoundException.class)
	public void testCalculateNetSalaryForInvalidAssociate() throws AssociateDetailsNotFoundException {
		int actualNetSalary=payrollservices.calculateNetSalary(122);
			}
	@Test
	public void testCalculateNetSalaryForValidAssociate() throws AssociateDetailsNotFoundException {
		int expectedNetSalary=12600;
		int actualNetSalary=payrollservices.calculateNetSalary(101);
		Assert.assertEquals(expectedNetSalary, actualNetSalary);	
	}
	@Test
	public void testGetAllDetailsForValidAssociate() {
		ArrayList<Associate> expectedAllDetails=new ArrayList<>();
		expectedAllDetails.add(new Associate(101,6000, "Tharani", "Bose", "IT", "analyst", "FHA612GF", "thara@gmail.com", new Salary(6000, 1500, 1200), new BankDetails(121324325, "HDFC", "hdfc26564g")));
		expectedAllDetails.add(new Associate(102,2000, "Karthiyayini", "P", "IT", "Data Analyst", "AF60154KL", "karthi@gmail.com", new Salary(5000, 1500, 1200), new BankDetails(13001212, "HDFC", "hdfc30458g")));
		ArrayList<Associate>actualAllDetails=(ArrayList<Associate>) payrollservices.getAllAssociatesDetails();
		Assert.assertEquals(expectedAllDetails, actualAllDetails);
	}
@After
public  void tearDownTestData() {
	PayrollUnit.ASSOCIATE_ID_COUNTER=100;
	PayrollUnit.associates.clear();
}
@AfterClass
public static void tearDownTestEnv() {
	payrollservices=null;
}
}
	
	



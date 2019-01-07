package com.cg.payroll.tests;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.AssociateDAO;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;
public class PayrollServicesTestEasyMock {
private static PayrollServices payrollServices;
private static AssociateDAO mockAssociateDAO;
@BeforeClass
public static void setUpTestEnv() {
	mockAssociateDAO=EasyMock.mock(AssociateDAO.class);
	payrollServices=new PayrollServicesImpl();
}
@Before
public void setUpTestData() {
	 Associate associate1=new Associate(101,6000, "Tharani", "Bose", "IT", "analyst", "FHA612GF", "thara@gmail.com", new Salary(6000, 1500, 1200), new BankDetails(121324325, "HDFC", "hdfc26564g")); 
	 Associate associate2=new Associate(102,2000, "Karthiyayini", "P", "IT", "Data Analyst", "AF60154KL", "karthi@gmail.com", new Salary(5000, 1500, 1200), new BankDetails(13001212, "HDFC", "hdfc30458g"));
	Associate associate3=new Associate(12000, "Rakesh", "Perumal", "Statics and Economics", "Data Analyst", "GSFD5454CG", "karthi@gmail.com", new Salary(10000, 1200, 1300), new BankDetails(146342, "TMB BANK", "TMB5446BG"));
	 ArrayList<Associate> associatesList=new ArrayList<>();
	 associatesList.add(associate1);
	 associatesList.add(associate2);
	 EasyMock.expect(mockAssociateDAO.save(associate3)).andReturn(associate3);
	 
	 EasyMock.expect(mockAssociateDAO.update(associate2)).andReturn(true);
	 
	 EasyMock.expect(mockAssociateDAO.findOne(101)).andReturn(associate1);
	 EasyMock.expect(mockAssociateDAO.findOne(102)).andReturn(associate2);
	 //EasyMock.expect(mockAssociateDAO.findOne(103)).andReturn(associate3);
	 EasyMock.expect(mockAssociateDAO.findOne(122)).andReturn(null);	 
	//EasyMock.expect(mockAssociateDAO.findAll()).andReturn(associatesList);
	
	EasyMock.replay(mockAssociateDAO);
	
}
@Test
public void testAcceptAssociateDetails() {
	int expectedAssociateId=103;
	Associate associate3=new Associate(12000, "Rakesh", "Perumal", "Statics and Economics", "Data Analyst", "GSFD5454CG", "karthi@gmail.com", new Salary(10000, 1200, 1300), new BankDetails(146342, "TMB BANK", "TMB5446BG"));
int actualAssociateId=payrollServices.acceptAssociateDetails(12000,"Rakesh", "Perumal", "Statics and Economics", "Data Analyst", "GSFD5454CG", "karthi@gmail.com", new Salary(10000, 1200, 1300), new BankDetails(146342, "TMB BANK", "TMB5446BG"));
//EasyMock.reset(mockAssociateDAO);
EasyMock.verify(mockAssociateDAO.save(associate3) );
assertEquals(expectedAssociateId, actualAssociateId);

}
@Test
public void testGetAssociateDetailsForValidDetails() throws AssociateDetailsNotFoundException {
	Associate actualAssociateDetail=payrollServices.getAssociateDetails(102);
	Associate expectedAssociateDetail=new Associate(102,2000, "Karthiyayini", "P", "IT", "Data Analyst", "AF60154KL", "karthi@gmail.com", new Salary(5000, 1500, 1200), new BankDetails(13001212, "HDFC", "hdfc30458g"));
	//EasyMock.reset(mockAssociateDAO);
	EasyMock.verify(mockAssociateDAO.findOne(102));
	assertEquals(expectedAssociateDetail, actualAssociateDetail);
}
@Test(expected=AssociateDetailsNotFoundException.class)
public void testGetAssociateDetailsForInValidDetails() throws AssociateDetailsNotFoundException {
	payrollServices.getAssociateDetails(1025);
	//EasyMock.reset(mockAssociateDAO);
	EasyMock.verify(mockAssociateDAO.findOne(1025));
}
/*@Test
public void testGetAssociateAllDetails() {
	List<Associate> actuallistOfAllAssociateDetails=new ArrayList<>();
	actuallistOfAllAssociateDetails=payrollServices.getAllAssociatesDetails();
	ArrayList<Associate>expectedlistOfAllAssociateDetails=new ArrayList<>();
	expectedlistOfAllAssociateDetails.add(new Associate(101,6000, "Tharani", "Bose", "IT", "analyst", "FHA612GF", "thara@gmail.com", new Salary(6000, 1500, 1200), new BankDetails(121324325, "HDFC", "hdfc26564g")));
	expectedlistOfAllAssociateDetails.add(new Associate(102,2000, "Karthiyayini", "P", "IT", "Data Analyst", "AF60154KL", "karthi@gmail.com", new Salary(5000, 1500, 1200), new BankDetails(13001212, "HDFC", "hdfc30458g")));
	EasyMock.verify(mockAssociateDAO.findAll());
	assertEquals(expectedlistOfAllAssociateDetails, actuallistOfAllAssociateDetails);
}*/
@Test
public void testAssociateSalaryValidData() throws AssociateDetailsNotFoundException {
	int expectedSalary=10500;
	int actualSalary=payrollServices.calculateNetSalary(102);
	Associate associate = new Associate(102,2000, "Karthiyayini", "P", "IT", "Data Analyst", "AF60154KL", "karthi@gmail.com", new Salary(5000, 1500, 1200), new BankDetails(13001212, "HDFC", "hdfc30458g"));
	//EasyMock.reset(mockAssociateDAO);
	EasyMock.verify(mockAssociateDAO.findOne(102));
	EasyMock.verify(mockAssociateDAO.update(associate));
	assertEquals(expectedSalary, actualSalary);
}
@Test(expected=AssociateDetailsNotFoundException.class)
public void testAssociateSalaryInValidData()throws AssociateDetailsNotFoundException
{
	int actualSalary=payrollServices.calculateNetSalary(122);
	Associate associate = new Associate(101,6000, "Tharani", "Bose", "IT", "analyst", "FHA612GF", "tharanibose1@gmail.com", new Salary(6000, 1500, 1200), new BankDetails(121324325, "HDFC", "hdfc26564g"));
	//EasyMock.reset(mockAssociateDAO);
		EasyMock.verify(mockAssociateDAO.findOne(122));
	  EasyMock.verify(mockAssociateDAO.update(associate));	
}
@After
public void tearTestData() {
	EasyMock.resetToDefault(mockAssociateDAO);
	
}
@AfterClass
public static void tearDownTestEnv() {
	payrollServices=null;
	mockAssociateDAO=null;
}
}

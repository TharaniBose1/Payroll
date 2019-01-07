package com.cg.payroll.client;
import java.util.ArrayList;
import java.util.List;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;
import com.cg.payroll.util.PayrollUnit;
public class MainClass {
	public static void main(String[] args) throws AssociateDetailsNotFoundException {
		PayrollServices payrollServices=new PayrollServicesImpl();
		/*
		for (Associate associate : associates) {
			if(associate.getAssociateID()==111)
				System.out.println(associate.getFirstName()+"  "+associate.getLastName());		
		}
		 */
		/*Associate []associates =new Associate[5];
associates[0]=new Associate(111, 520000, "Thara", "Bose","IT","A4","HKF7347Q", "tharani@gmail.com",new Salary(16000, 500, 1200),new BankDetails(476757, "ICICFI", "icici62742"));
associates[1]=new Associate(112, 169100, "Raja", "Rakesh","IT","A4","HKF7347Q", "tharani@gmail.com",new Salary(26000, 500, 1200),new BankDetails(476757, "HDFC", "hdfc14352"));
associates[2]=new Associate(113, 118200, "Rani", "Kanni","IT","A4","HKF7347Q", "tharani@gmail.com",new Salary(86000, 500, 1200),new BankDetails(476757, "HDFC", "hdfc62742"));
associates[3]=new Associate(114, 720000, "Karthi", "Sanithiya","IT","A4","HKF7347Q", "tharani@gmail.com",new Salary(96000, 500, 1200),new BankDetails(476757, "SBI", "sbin62742"));
associates[4]=new Associate(115, 50000, "Ambikai", "Elizil","IT","A4","HKF7347Q", "tharani@gmail.com",new Salary(56000, 500, 1200),new BankDetails(476757, "SBI", "sbin62742"));	
for (Associate associate : associates) {
	System.out.println(associate.getAssociateID()+" "+associate.getFirstName()+" "+associate.getLastName());;
	if((associate.getSalary().getBasicSalary()>=20000) && (associate.getBankDetails().getBankName()=="HDFC")) 
		 */	
		try {
			int accociateId1=payrollServices.acceptAssociateDetails(6000, "Tharani", "Bose", "IT", "analyst", "FHA612GF", "thara@gmail.com", new Salary(6000, 1500, 1200), new BankDetails(121324325, "HDFC", "hdfc26564g"));
			System.out.println("GENETRRATED ID IS"+accociateId1);
			int accociateId2=payrollServices.acceptAssociateDetails(2000, "Karthiyayini", "P", "IT", "Data Analyst", "AF60154KL", "karthi@gmail.com", new Salary(5000, 1500, 1200), new BankDetails(13001212, "HDFC", "hdfc30458g"));
			System.out.println("GENETRRATED ID IS"+accociateId2);
			//int accociateId3=payrollServices.acceptAssociateDetails(1000, "Rakesh", "P", "MECH", "Mainatance Engineer", "HYFD478N", "rakesh@gmail.com'", new Salary(9000, 1500, 1200), new BankDetails(239897120, "ICICI", "icici2454s'"), 0);
		//	System.out.println("GENETRRATED ID IS"+accociateId3);
			int calculatedNetSalary1=payrollServices.calculateNetSalary(101);
			System.out.println("Calculate Salary:"+calculatedNetSalary1);
			int calculatedNetSalary2=payrollServices.calculateNetSalary(102);
			System.out.println("Calculate Salary:"+calculatedNetSalary2);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Associate associate2=payrollServices.getAssociateDetails(101);
		System.out.println("Associate id:"+associate2.getAssociateID()+"And their first name is"+associate2.getFirstName());
		List< Associate> arrayList;
		arrayList=payrollServices.getAllAssociatesDetails();
		for (Associate associate : arrayList) {
			System.out.println(associate.getAssociateID());
			
			
		}
	}
}





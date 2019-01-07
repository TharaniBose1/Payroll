package com.cg.payroll.services;
import java.util.List;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.AssociateDAO;
import com.cg.payroll.daoservices.AssociateDAOImpl;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.util.PayrollUnit;
public class PayrollServicesImpl  implements PayrollServices {
	private AssociateDAO  associateDAO;
	public PayrollServicesImpl() {
		associateDAO=new AssociateDAOImpl();
	}
	public PayrollServicesImpl(AssociateDAO associateDAO) {
		super();
		this.associateDAO = associateDAO;
	}
	@Override
	public int acceptAssociateDetails(int yearlyInvestmentUnder80C, String firstName, String lastName,
			String department, String designation, String pancard, String emailId, Salary salary,
			BankDetails bankDetails) {
		Associate associate=new Associate(yearlyInvestmentUnder80C,firstName,  lastName, department, designation, pancard, emailId, salary, bankDetails);
		associate=associateDAO.save(associate);
		return associate.getAssociateID();
	}
	@Override
	public int calculateNetSalary(int associateID) throws AssociateDetailsNotFoundException {
		Associate associate =(Associate) this.getAssociateDetails(associateID);
		//Associate associate = this.getAssociateDetails(associateID);
		associateDAO.update(associate);
		// associateDAO.update(associate);
		associate.getSalary().setHra(associate.getSalary().getBasicSalary()*40/100);
		associate.getSalary().setConveyenceAllowance(associate.getSalary().getBasicSalary()*30/100);
		associate.getSalary().setOtherAllowance(associate.getSalary().getBasicSalary()*20/100);
		associate.getSalary().setPersonalAllowance(associate.getSalary().getBasicSalary()*20/100);	
		associate.getSalary().setMonthlygrossSalary(associate.getSalary().getBasicSalary()+associate.getSalary().getEpf()+associate.getSalary().getCompanyPf()+associate.getSalary().getHra()+associate.getSalary().getConveyenceAllowance()+associate.getSalary().getOtherAllowance()+associate.getSalary().getPersonalAllowance());
		associate.getSalary().setAnnualGrossSalary(associate.getSalary().getMonthlygrossSalary()*12);   
		if(associate.getSalary().getAnnualGrossSalary()<=250000){
			associate.getSalary().setYearlyTax(0);
			associate.getSalary().setNetSalary(associate.getSalary().getMonthlygrossSalary()-associate.getSalary().getCompanyPf()-associate.getSalary().getEpf());
			return associate.getSalary().getNetSalary();
		}
		else if(associate.getSalary().getAnnualGrossSalary()>250000 && associate.getSalary().getAnnualGrossSalary()<=500000){
			associate.getSalary().setYearlyTax(associate.getSalary().getTaxableAmount()/10);
			associate.getSalary().setNetSalary(associate.getSalary().getMonthlygrossSalary()-associate.getSalary().getCompanyPf()-associate.getSalary().getEpf()-associate.getSalary().getCompanyPf()-associate.getSalary().getYearlyTax()/12);
			return associate.getSalary().getNetSalary();
		}
		else if(associate.getSalary().getAnnualGrossSalary()>=500000 && associate.getSalary().getAnnualGrossSalary()<=1000000)
		{
			associate.getSalary().setYearlyTax((associate.getSalary().getTaxableAmount()/5)+25000);
			associate.getSalary().setNetSalary(associate.getSalary().getMonthlygrossSalary()-associate.getSalary().getCompanyPf()-associate.getSalary().getEpf()-associate.getSalary().getCompanyPf()-associate.getSalary().getYearlyTax()/12);
			return associate.getSalary().getNetSalary(); 
		}
		else  {
			associate.getSalary().setYearlyTax((associate.getSalary().getTaxableAmount()*3/5)+100000);
			associate.getSalary().setNetSalary(associate.getSalary().getMonthlygrossSalary()-associate.getSalary().getCompanyPf()-associate.getSalary().getEpf()-associate.getSalary().getCompanyPf()-associate.getSalary().getYearlyTax()/12);
			return associate.getSalary().getNetSalary();
		}		
		//return associate.getSalary().getNetSalary();
	}
	/*
	@Override
	public List<Associate> getAssociateDetails(int associateID) throws AssociateDetailsNotFoundException {
		Associate associate=associateDAO.findOne(associateID);
		if(associate==null)throw new AssociateDetailsNotFoundException("AssociateID details not found!"+associateID);
		return associate;
	}
	@Override
	public Associate List getAllAssociatesDetails() {
		return PayrollUnit.associates;
	}
	 */
	/*
	List<String> keyList = new ArrayList<String>(companyDetails.keySet());
	System.out.println("\n==> Size of Key list: " + keyList.size());

	for (String temp : keyList) {
		System.out.println(temp);
	}

	// Converting HashMap Values into ArrayList
	List<Integer> valueList = new ArrayList<Integer>(companyDetails.values());
	System.out.println("\n==> Size of Value list: " + valueList.size());
	for (Integer temp : valueList) {
		System.out.println(temp);
	}
	List<Entry> entryList = new ArrayList<Entry>(companyDetails.entrySet());
	System.out.println("\n==> Size of Entry list: " + entryList.size());
	for (Entry temp : entryList) {
		System.out.println(temp);
	 */
	@Override
	public Associate getAssociateDetails(int associateID) throws AssociateDetailsNotFoundException {
		Associate associate=associateDAO.findOne(associateID);
		if(associate==null)throw new AssociateDetailsNotFoundException("AssociateID details not found!"+associateID);
		return associate;
	}
	@Override
	public List<Associate> getAllAssociatesDetails() {
		List<Associate> listOfassociates=associateDAO.findAll();   
		return listOfassociates;
		//return (List<Associate>) PayrollUnit.associates.values();
	}
}

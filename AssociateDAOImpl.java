package com.cg.payroll.daoservices;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.util.PayrollUnit;
public class AssociateDAOImpl implements AssociateDAO {
	@Override
	public Associate save(Associate associate) {	  
		associate.setAssociateID(PayrollUnit.getASSOCIATE_ID_COUNTER());
		PayrollUnit.associates.put(associate.getAssociateID(), associate);
		return associate;
	}
	@Override
	public boolean update(Associate associate) {
		PayrollUnit.associates.put(associate.getAssociateID(), associate);
		return true;
	}
	/*
	 * 
	public boolean update(Associate associate) { 
		
		
		for (Associate associatei : PayrollUnit.associates) {
			if(associate.getAssociateID()== associatei.getAssociateID()) {
				associate.getSalary().setHra(associate.getSalary().getBasicSalary()*40/100);
				associate.getSalary().setConveyenceAllowance(associate.getSalary().getBasicSalary()*30/100);
				associate.getSalary().setOtherAllowance(associate.getSalary().getBasicSalary()*20/100);
				associate.getSalary().setPersonalAllowance(associate.getSalary().getBasicSalary()*20/100);	
				associate.getSalary().setMonthlygrossSalary(associate.getSalary().getBasicSalary()+associate.getSalary().getEpf()+associate.getSalary().getCompanyPf()+associate.getSalary().getHra()+associate.getSalary().getConveyenceAllowance()+associate.getSalary().getOtherAllowance()+associate.getSalary().getPersonalAllowance());
				associate.getSalary().setAnnualGrossSalary(associate.getSalary().getMonthlygrossSalary()*12);
				associate.getSalary().setMonthlygrossSalary(associate.getSalary().getAnnualGrossSalary()/12);
				associate.getSalary().setTaxableAmount(associate.getSalary().getAnnualGrossSalary()- associate.getSalary().getCompanyPf()*12+associate.getSalary().getEpf()*12-associate.getYearlyInvestmentUnder80C());
				associate.getSalary().setMonthlyTax(associate.getSalary().getYearlyTax()/12);
				associate.getSalary().setNetSalary(associate.getSalary().getMonthlygrossSalary()-associate.getSalary().getCompanyPf()+associate.getSalary().getEpf()-associate.getSalary().getMonthlyTax());
				return true;	
		  }	
		}
		return false;
	}
	*/
/*
	@Override
	public Associate findOne(int associateId) {
		for (Associate associate : PayrollUnit.associates) {
			if(associate!=null && associate.getAssociateID()==associateId)
				return associate;	
		}
		return null;
	}@Override
	public Associate List findAll() {

		return PayrollUnit.associates;
	}
*/

	@Override
	public Associate findOne(int associateId) {
		return PayrollUnit.associates.get(associateId); 
	}

	@Override
	public java.util.List<Associate> findAll() {
	//	ArrayList<Associate> ass=new ArrayList<>(PayrollUnit.associates.values());
		//return ass;
		return new ArrayList<>(PayrollUnit.associates.values());
		//List<Associate> associateList=new ArrayList<>();
	//	Set<Integer> keySet=new PayrollUnit().associates.keySet();
	//	for (Integer key : keySet) {
		//	associateList.add(PayrollUnit.associates.get(key));
		//}
 //return associateList=(ArrayList<Associate>)PayrollUnit.associates.values();
	}
	
	
	
}

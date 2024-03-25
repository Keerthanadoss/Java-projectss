package com.service;

import java.sql.SQLException;
import java.util.List;
import com.dao.LoanDao;
import com.dao.LoanDaoImpl;
import com.exception.InvalidLoanException;
import com.model.Loan;

public class LoanService {
	LoanDao loanDao=new LoanDaoImpl();

	public List<Loan> fetchAllLoanDetails() throws SQLException {
		return loanDao.fetchAllLoanDetails();
	}

	public Loan getLoanById(List<Loan> list, int id) throws InvalidLoanException {
		for(Loan l:list) {
			if(l.getId()==id)
				return l;
		}
		throw new InvalidLoanException("Loan Id Not Found!!Please enter the correct Loan Id");
	}

}

package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Loan;

public interface LoanDao {

	List<Loan> fetchAllLoanDetails() throws SQLException;

}

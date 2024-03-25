package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Loan;
import com.util.DbUtil;

public class LoanDaoImpl implements LoanDao {

	@Override
	public List<Loan> fetchAllLoanDetails() throws SQLException {
		List<Loan> list=new ArrayList<>();
		Connection conn=DbUtil.getDBConn();
		String sql="select *from loan";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		while(rst.next()) {
			int id=rst.getInt("id");
			int customerId=rst.getInt("customer_id");
			double principalAmount=rst.getDouble("principal_amount");
			int interestRate=rst.getInt("interest_rate");
			int loanTerm=rst.getInt("loan_term");
			String loanType=rst.getString("loan_type");
			String loanStatus=rst.getString("loan_status");
			Loan l=new Loan(id,customerId,principalAmount,interestRate,loanTerm,loanType,loanStatus);
			list.add(l);
		}
		DbUtil.dbClose();
		return list;
	}

}

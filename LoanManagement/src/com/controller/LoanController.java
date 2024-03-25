package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.exception.InvalidLoanException;
import com.model.Loan;
import com.service.LoanService;

public class LoanController {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		LoanService loanService=new LoanService();
		while(true) {
			System.out.println("*****************LOAN OPERATION***********************");
			System.out.println("Press 1: To Get All Loan Details");
			System.out.println("Press 1: To Get Loan by Id");
			System.out.println("Press 1: ");
			System.out.println("Press 1: ");
			System.out.println("Press 0: To exit");
			int input=sc.nextInt();
			if(input==0) {
				System.out.println("Thank you !!!Exiting !!!! ");
				break;
			}
			switch(input) {
			case 1:
				try {
					List<Loan> list=loanService.fetchAllLoanDetails();
					System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s%-15s%s", "Loan Id",
							"Customer Id", "Principal Amount", "Interest Rate", "Loan Term", "Loan Type", "Loan Status"));
					for(Loan l:list) {
						System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s%-15s%s",l.getId(),l.getCustomerId(),l.getPrincipalAmount(),l.getInterestRate(),l.getLoanTerm(),l.getLoanType(),l.getLoanStatus()));
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				List<Loan> list;
				try {
					list = loanService.fetchAllLoanDetails();
					System.out.println("Enter the loan Id");
					int id=sc.nextInt();
					sc.nextLine();
					Loan l=loanService.getLoanById(list,id);
					System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s%-15s%s", "Loan Id",
							"Customer Id", "Principal Amount", "Interest Rate", "Loan Term", "Loan Type", "Loan Status"));
					System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s%-15s%s",l.getId(),l.getCustomerId(),l.getPrincipalAmount(),l.getInterestRate(),l.getLoanTerm(),l.getLoanType(),l.getLoanStatus()));
					
				} catch (SQLException | InvalidLoanException e) {
					System.out.println(e.getMessage());
				}
		}
	}
	}
}

	



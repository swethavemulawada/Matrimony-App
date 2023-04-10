package com.matrimony.g.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
    @Entity
	@Table(name="payment")
	public class Payment {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		
		private int id;
		@NotEmpty
		@Size(min = 3, message = "cadidateName should be min 3 chars")
		@Column(name = "candidate_Name", nullable = false)
	    private String candidateName;
		@NotEmpty
		@Size(min = 2, message = "bank name should be min 2 chars")
	    @Column(name = "bank_Name", nullable = false)
	    private String bankName;
		@Column(name = "accountNumber", nullable = false)
		@Size(min = 6, message = "bank name should be min 6 chars")
	    private String accountNo;
		
	    @Column(name = "ifscCode", nullable = false)
	    @Pattern(regexp = "^[A-Z]{4}[A-Z0-9]{6}$",message="Enter a valid IFSC code Ex:HDFC987654")
	    private String ifscCode;
	    @Size(min = 2, message = "Amount should be min 2 chars")
	    @Column(name = "amount", nullable = false)
	    private String amount;
	    @OneToOne
	  
	    private Manager manager;
	    
	 
		public Manager getManager() {
			return manager;
		}

		public void setManager(Manager manager) {
			this.manager = manager;
		}

		public int getId() {
			return id;
		}

		public void setId(int Id) {
			this.id = Id;
		}

		public String getCandidateName() {
			return candidateName;
		}

		public void setCandidateName(String candidateName) {
			this.candidateName = candidateName;
		}

		public String getBankName() {
			return bankName;
		}

		public void setBankName(String bankName) {
			this.bankName = bankName;
		}

		public String getAccountNo() {
			return accountNo;
		}

		public void setAccountNo(String accountNo) {
			this.accountNo = accountNo;
		}

		public String getIfscCode() {
			return ifscCode;
		}

		public void setIfscCode(String ifscCode) {
			this.ifscCode = ifscCode;
		}

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}

				

				
				}




package net.project.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Payments")

public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long payment_id;
	
	@Column(name = "customer_name")
	private String cus_name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "area_office")
	private String area_office;
	
	@Column(name = "card_num")
	private long card_num;
	
	@Column(name = "pay_amount")
	private long amount;
	
	@Column(name = "bill_id")
	private long bill_id;
	
	public Payment (){
		
	}
	
	
	public Payment(String cus_name, String email, String area_office, long card_num, long amount, long bill_id) {
		super();
		this.cus_name = cus_name;
		this.email = email;
		this.area_office = area_office;
		this.card_num = card_num;
		this.amount = amount;
		this.bill_id = bill_id;
	}
	
	public long getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(long payment_id) {
		this.payment_id = payment_id;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmial(String email) {
		this.email = email;
	}
	
	public String getArea_office() {
		return area_office;
	}
	public void setArea_office(String area_office) {
		this.area_office = area_office;
	}
	public long getCard_num() {
		return card_num;
	}
	public void setCard_num(long card_num) {
		this.card_num = card_num;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getBill_id() {
		return bill_id;
	}


	public void setBill_id(long bill_id) {
		this.bill_id = bill_id;
	}

	
	
}

package com.sales.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblVisit")
public class Visit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private Integer visit_id;
	
	private String cust_name;
	
	private String contact_person;
	
	private Long contact_no;
	
	private String interest_product;
	
	private String visit_subject;
	
	private String description;
	
	private LocalDate visit_datetime;
	
	private Boolean is_disabled;
	
	private Boolean is_deleted;
	
	private Integer emp_id;
	
	@ManyToOne
	@JoinColumn(name = "emp_id", insertable = false, updatable = false)
	@JsonIgnore
	private Employee employee;


	// overloaded constructor
	public Visit(String cust_name, String contact_person, Long contact_no, String interest_product,
			String visit_subject, String description, LocalDate visit_datetime, Boolean is_disabled, Boolean is_deleted,
			Integer emp_id) {
		this.cust_name = cust_name;
		this.contact_person = contact_person;
		this.contact_no = contact_no;
		this.interest_product = interest_product;
		this.visit_subject = visit_subject;
		this.description = description;
		this.visit_datetime = visit_datetime;
		this.is_disabled = is_disabled;
		this.is_deleted = is_deleted;
		this.emp_id = emp_id;
	}
	
	
}

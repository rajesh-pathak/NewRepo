package com.mo;
/*soxjvhoshofdhoh*/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tcomplaint")
public class Complaint {
	
	@Id
	@GeneratedValue
	@Column(name="compid")
	private int comp_id;
	@Column(name="complaints")
	private String complaints;
	public int getComp_id() {
		return comp_id;
	}
	public void setComp_id(int comp_id) {
		this.comp_id = comp_id;
	}
	
	
	public String getComplaints() {
		return complaints;
	}
	public void setComplaints(String complaints) {
		this.complaints = complaints;
	}
	public Complaint() {
		
		// TODO Auto-generated constructor stub
	}
	public Complaint(int comp_id, String complaints) {
		super();
		this.comp_id = comp_id;
		this.complaints = complaints;
	}
	
}

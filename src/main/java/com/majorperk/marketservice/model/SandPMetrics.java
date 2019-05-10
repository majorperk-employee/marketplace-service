package com.majorperk.marketservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name="sAndPMetrics")
@JsonPropertyOrder({"employee_id", "firstname", "lastname", "fullname", "team_id", "team_name", "location_id", "location_name", "prod_hours", "sales", "avg_speed_answer", "avg_handle", "first_call_resolution", "customer_satisfcation", "abstenteeism", "input_data_error", "contact_quality"})
public class SandPMetrics {

	@Id
	long employee_id;
	String firstname;
	String lastname;
	String fullname;
	int team_id;
	String team_name;
	int location_id;
	String location_name;
	double prod_hours;
	int sales;
	double avg_speed_answer;
	double avg_handle;
	double first_call_resolution;
	double customer_satisfcation;
	double abstenteeism;
	double input_data_error;
	double contact_quality;

	// DEFAULT, makes JPA happy.
	public SandPMetrics() {
		super();
	}
	
	public long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(long employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

	public double getProd_hours() {
		return prod_hours;
	}

	public void setProd_hours(double prod_hours) {
		this.prod_hours = prod_hours;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public double getAvg_speed_answer() {
		return avg_speed_answer;
	}

	public void setAvg_speed_answer(double avg_speed_answer) {
		this.avg_speed_answer = avg_speed_answer;
	}

	public double getAvg_handle() {
		return avg_handle;
	}

	public void setAvg_handle(double avg_handle) {
		this.avg_handle = avg_handle;
	}

	public double getFirst_call_resolution() {
		return first_call_resolution;
	}

	public void setFirst_call_resolution(double first_call_resolution) {
		this.first_call_resolution = first_call_resolution;
	}

	public double getCustomer_satisfcation() {
		return customer_satisfcation;
	}

	public void setCustomer_satisfcation(double customer_satisfcation) {
		this.customer_satisfcation = customer_satisfcation;
	}

	public double getAbstenteeism() {
		return abstenteeism;
	}

	public void setAbstenteeism(double abstenteeism) {
		this.abstenteeism = abstenteeism;
	}

	public double getInput_data_error() {
		return input_data_error;
	}

	public void setInput_data_error(double input_data_error) {
		this.input_data_error = input_data_error;
	}

	public double getContact_quality() {
		return contact_quality;
	}

	public void setContact_quality(double contact_quality) {
		this.contact_quality = contact_quality;
	}

}
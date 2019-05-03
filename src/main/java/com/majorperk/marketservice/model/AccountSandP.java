package com.majorperk.marketservice.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@Entity
//@Table(name="accountSandP")
@JsonPropertyOrder({ 
	
	
	"employee_id",
	"firstname", 
	"lastname", 
	"fullname",
	"team_id",
	"team_name",
	"location_id",
	"location_name",
	"prod_hours",
	"sales",
	"avg_speed_answer",
	"avg_handle",
	"first_call_resolution",
	"customer_satisfcation",	
	"abstenteeism",	
	"input_data_error",	
	"contact_quality"})
public class AccountSandP {

	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	Cart cart = new Cart();
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Purchase> purchases = new ArrayList<Purchase>();

	@OneToOne(cascade= CascadeType.ALL)
	private Tier tier;*/	
	
	String employee_id;
	String firstname;
	String lastname;
	String fullname;
	String team_id;
	String team_name;
	String location_id;
	String location_name;
	String prod_hours;
	String sales;
	String avg_speed_answer;
	String avg_handle;
	String first_call_resolution;
	String customer_satisfcation;
	String abstenteeism;
	String input_data_error;
	String contact_quality;

	// DEFAULT, makes JPA happy.
	public AccountSandP() {
		super();
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
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

	public String getTeam_id() {
		return team_id;
	}

	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getLocation_id() {
		return location_id;
	}

	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}

	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

	public String getProd_hours() {
		return prod_hours;
	}

	public void setProd_hours(String prod_hours) {
		this.prod_hours = prod_hours;
	}

	public String getSales() {
		return sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}

	public String getAvg_speed_answer() {
		return avg_speed_answer;
	}

	public void setAvg_speed_answer(String avg_speed_answer) {
		this.avg_speed_answer = avg_speed_answer;
	}

	public String getAvg_handle() {
		return avg_handle;
	}

	public void setAvg_handle(String avg_handle) {
		this.avg_handle = avg_handle;
	}

	public String getFirst_call_resolution() {
		return first_call_resolution;
	}

	public void setFirst_call_resolution(String first_call_resolution) {
		this.first_call_resolution = first_call_resolution;
	}

	public String getCustomer_satisfcation() {
		return customer_satisfcation;
	}

	public void setCustomer_satisfcation(String customer_satisfcation) {
		this.customer_satisfcation = customer_satisfcation;
	}

	public String getAbstenteeism() {
		return abstenteeism;
	}

	public void setAbstenteeism(String abstenteeism) {
		this.abstenteeism = abstenteeism;
	}

	public String getInput_data_error() {
		return input_data_error;
	}

	public void setInput_data_error(String input_data_error) {
		this.input_data_error = input_data_error;
	}

	public String getContact_quality() {
		return contact_quality;
	}

	public void setContact_quality(String contact_quality) {
		this.contact_quality = contact_quality;
	}
}
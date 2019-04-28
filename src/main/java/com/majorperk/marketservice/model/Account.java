package com.majorperk.marketservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	Cart cart = new Cart();
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Purchase> purchases = new ArrayList<Purchase>();

	@OneToOne(cascade= CascadeType.ALL)
	private Tier tier;
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String job;
	private String address;
	private String city;
	private String state;
	private String email;	
	private Integer zip;
	private String picture;
	private Integer points;
	private Integer totaldays;
	private double ontimedays;
	private Integer daystreak;
	

	// DEFAULT, makes JPA happy.
	public Account() {
		super();
	}

	public Account(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Account(String username, String password, String firstName, String lastName, String token, String job,
			Tier tier, String address, String city, String state, Integer zip, String picture, Integer points, 
			Integer totaldays, double ontimedays, Integer daystreak) {

		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.job = job;
		this.tier = tier;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.picture = picture;
		this.points = points;
		this.totaldays = totaldays;
		this.ontimedays = ontimedays;
		this.daystreak = daystreak;
	}

	@Override
	public String toString() {
		return "id: " + this.id + ", username: " + this.username + ", lastName, firstName:  " + this.lastName + ", "
				+ this.firstName;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Tier getTier() {
		return tier;
	}

	public void setTier(Tier tier) {
		this.tier = tier;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getTotaldays() {
		return totaldays;
	}

	public void setTotaldays(Integer totaldays) {
		this.totaldays = totaldays;
	}

	public double getOntimedays() {
		return ontimedays;
	}

	public void setOntimedays(double ontimedays) {
		this.ontimedays = ontimedays;
	}

	public Integer getDaystreak() {
		return daystreak;
	}

	public void setDaystreak(Integer daystreak) {
		this.daystreak = daystreak;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}
	
	public void addPurchase(Purchase purchase) {
		this.points -= purchase.cost;
		this.purchases.add(purchase);
	}
}
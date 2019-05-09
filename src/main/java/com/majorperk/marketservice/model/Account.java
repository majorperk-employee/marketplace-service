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
import javax.persistence.Table;

@Entity
@Table(name="account")
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
	
	@OneToOne(cascade = CascadeType.ALL)
	private SandPMetrics sAndPMetrics;
	
	private String phone;
	private String nickname;
	private String username;
	private String password;
	private boolean manager;
	private String email;
	private String picture;
	private Integer points;
	

	// DEFAULT, makes JPA happy.
	public Account() {
		super();
	}

	public Account(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
	}

	public Account(String username, String password, String firstName, String lastName, String token, String job,
			Tier tier, SandPMetrics sAndPMetrics, String address, String city, String state, Integer zip, String picture, Integer points, 
			Integer totaldays, double ontimedays, Integer daystreak) {

		this.username = username;
		this.password = password;
		this.tier = tier;
		this.sAndPMetrics = sAndPMetrics;
		this.picture = picture;
		this.points = points;
		}

	@Override
	public String toString() {
		return "id: " + this.id + ", username: " + this.username;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Tier getTier() {
		return tier;
	}

	public void setTier(Tier tier) {
		this.tier = tier;
	}

	public SandPMetrics getAccountSandP() {
		return sAndPMetrics;
	}

	public void setAccountSandP(SandPMetrics sAndPMetrics) {
		this.sAndPMetrics = sAndPMetrics;
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

	public SandPMetrics getsAndPMetrics() {
		return sAndPMetrics;
	}

	public void setsAndPMetrics(SandPMetrics sAndPMetrics) {
		this.sAndPMetrics = sAndPMetrics;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
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

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
package com.majorperk.marketservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.majorperk.marketservice.model.tango.TangoOrderResponse;

@Entity
@Table(name = "account")
public class Account {

	@Id
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart = new Cart();

	@OneToMany(cascade = CascadeType.ALL)
	private List<Purchase> purchases = new ArrayList<Purchase>();

	@OneToOne(cascade = CascadeType.ALL)
	private Tier tier = new Tier();

	@OneToOne(cascade = CascadeType.ALL)
	private SandPMetrics sAndPMetrics = new SandPMetrics();

	@OneToMany(cascade = CascadeType.ALL)
	private List<TangoOrderResponse> rewardLinks = new ArrayList<TangoOrderResponse>();

	private String phone;
	private String nickname;
	private String username;
	private String password;
	private boolean manager;
	private String email;
	private String picture;
	private Integer points;

	public void addPurchase(Purchase purchase) {
		this.points -= purchase.cost;
		this.purchases.add(purchase);
	}

	public void addRewardLink(TangoOrderResponse rewardLink) {
		this.points -= (rewardLink.getTotal() * this.tier.multiplier);
		this.rewardLinks.add(rewardLink);
	}

	// DEFAULT, makes JPA happy.
	public Account() {
		super();
	}

	public Account(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
	}

	public Account(String username, String password, Tier tier, SandPMetrics sAndPMetrics, String picture,
			Integer points) {
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

	public SandPMetrics getSAndPMetrics() {
		return sAndPMetrics;
	}

	public void setSAndPMetrics(SandPMetrics sAndPMetrics) {
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

	public List<TangoOrderResponse> getRewardLinks() {
		return rewardLinks;
	}

	public void setRewardLinks(List<TangoOrderResponse> rewardLinks) {
		this.rewardLinks = rewardLinks;
	}
}
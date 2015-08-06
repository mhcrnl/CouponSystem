package beans;

import java.util.Collection;

public class Company {
	long id;
	String compName;
	String password;
	String email;
	Collection<Coupon> coupons;

	Company() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		if (id > 99999999 && id < 1000000000) {
			this.id = id;
		}
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		if (compName != null) {
			this.compName = compName;
		}
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

	public Collection<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(Collection<Coupon> coupons) {
		this.coupons = coupons;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", compName=" + compName + ", password="
				+ password + ", email=" + email + ", coupons=" + coupons + "]";
	}

}

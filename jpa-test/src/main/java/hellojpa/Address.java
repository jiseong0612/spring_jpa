package hellojpa;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String city;
	private String Street;
	private String zipCode;
	
	public Address() {
	}
	
	public Address(String city, String street, String zipCode) {
		super();
		this.city = city;
		Street = street;
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
}

package sss.model;

public class Adress {

	int id ;
	String Street;
	String StreetNubmer;
	String City;
	String Country;
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getStreetNubmer() {
		return StreetNubmer;
	}
	public void setStreetNubmer(String streetNubmer) {
		StreetNubmer = streetNubmer;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public Adress(int id,String street, String streetNubmer, String city, String country) {
		super();
		this.id = id;
		Street = street;
		StreetNubmer = streetNubmer;
		City = city;
		Country = country;
	}
	public Adress(String street, String streetNubmer, String city, String country) {
		super();
	
		Street = street;
		StreetNubmer = streetNubmer;
		City = city;
		Country = country;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}

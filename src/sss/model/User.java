package sss.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	int id;
	String firstname;
	String lastname;
	String email;
	String phoneNumber;
	Adress Adress;
	String CardNumber;
	List<Language> SecondaryLanguages = new ArrayList<Language>();
	Language MainLanguage;
	public User(int id, String firstname, String lastname, String email, String phoneNumber, Adress adress,
			String cardNumber, List<Language> secondaryLanguages, Language mainLanguage) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		Adress = adress;
		CardNumber = cardNumber;
		SecondaryLanguages = secondaryLanguages;
		MainLanguage = mainLanguage;
	}
	public User(String firstname, String lastname, String email, String phoneNumber, Adress adress,String cardNumber,
			List<Language> secondaryLanguages, Language mainLanguage) {
		super();
		this.CardNumber = cardNumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		Adress = adress;
		SecondaryLanguages = secondaryLanguages;
		MainLanguage = mainLanguage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Adress getAdress() {
		return Adress;
	}
	public void setAdress(Adress adress) {
		Adress = adress;
	}
	public String getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}
	public List<Language> getSecondaryLanguages() {
		return SecondaryLanguages;
	}
	public void setSecondaryLanguages(List<Language> secondaryLanguages) {
		SecondaryLanguages = secondaryLanguages;
	}
	public Language getMainLanguage() {
		return MainLanguage;
	}
	public void setMainLanguage(Language mainLanguage) {
		MainLanguage = mainLanguage;
	}

}

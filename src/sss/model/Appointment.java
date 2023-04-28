package sss.model;

import java.time.LocalDateTime;

public class Appointment {
	int id;
	LocalDateTime StartDateTime;
	Coach coach;
	Client client;
	boolean reserved ;
	boolean canceled;
	int price;
	
	
	
	
	public LocalDateTime getStartDateTime() {
		return StartDateTime;
	}
	public void setStartDateTime(LocalDateTime startDateTime) {
		StartDateTime = startDateTime;
	}
	public Coach getCoach() {
		return coach;
	}
	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public boolean isReserved() {
		return reserved;
	}
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}
	public boolean isCanceled() {
		return canceled;
	}
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Appointment(LocalDateTime startDateTime, Coach coach,boolean reserved, boolean canceled,
			int price) {
		super();
		StartDateTime = startDateTime;
		this.coach = coach;
		this.reserved = reserved;
		this.canceled = canceled;
		this.price = price;
	}
	public Appointment( int id,LocalDateTime startDateTime, Coach coach, Client client, boolean reserved,
			boolean canceled, int price) {
		super();
		StartDateTime = startDateTime;
		this.id = id;
		this.coach = coach;
		this.client = client;
		this.reserved = reserved;
		this.canceled = canceled;
		this.price = price;
	}
	public int getId() {
		return id ;
	}
	public void setId(int id) {
		this.id = id;
	}


}

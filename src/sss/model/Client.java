package sss.model;

import java.util.*;

public class Client {

	User user;
	public Client(User user, Report report) {
		super();
		this.user = user;
		this.report = report;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Report getReport() {
		return report;
	}
	public void setReport(Report report) {
		this.report = report;
	}
	Report report;

}

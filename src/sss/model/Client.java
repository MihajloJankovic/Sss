package sss.model;

import java.util.*;

public class Client {
	private int id;
	User user;
	public Client(User user, Report report) {
		super();
		this.user = user;
		this.report = report;
	}
	public Client(int id, User user, Report report) {
		super();
		this.id = id;
		this.user = user;
		this.report = report;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

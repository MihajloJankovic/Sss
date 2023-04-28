package sss.model;

import java.util.ArrayList;
import java.util.List;

public class Report {
	private int id;
	private int user;
	private double height;
	private double weight;
	private String HealthStatus;
	List<Goal> goals = new ArrayList<Goal>();
	List<Props> props = new ArrayList<Props>();
	public Report(double height, double weight, String healthStatus, List<Goal> goals, List<Props> props,int user) {
		super();
		this.height = height;
		this.weight = weight;
		this.user = user;
		HealthStatus = healthStatus;
		this.goals = goals;
		this.props = props;
	}
	public Report(int id, double height, double weight, String healthStatus, List<Goal> goals, List<Props> props,int user) {
		super();
		this.id = id;
		this.user = user;
		this.height = height;
		this.weight = weight;
		HealthStatus = healthStatus;
		this.goals = goals;
		this.props = props;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getHealthStatus() {
		return HealthStatus;
	}
	public void setHealthStatus(String healthStatus) {
		HealthStatus = healthStatus;
	}
	public List<Goal> getGoals() {
		return goals;
	}
	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}
	public List<Props> getProps() {
		return props;
	}
	public void setProps(List<Props> props) {
		this.props = props;
	}
	

}

package sss.model;

import java.awt.Image;

public class Coach {
	int id;
	
	Rank rank;
	String degree;
	double Rating;
	public Coach(String degree) {
		super();
		this.rank = Rank.JUNIOR;
		Rating = 0;
		this.degree = degree;
	}
	public Coach(int id, Rank rank, double rating,String degree) {
		super();
		this.id = id;
		this.degree = degree;
		this.rank = rank;
		Rating = rating;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	public double getRating() {
		return Rating;
	}
	public void setRating(double rating) {
		Rating = rating;
	}
}

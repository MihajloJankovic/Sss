package sss.model;

import java.awt.Image;

public class Coach {
	int id;
	Image Degree;
	Image Certificate;
	Rank rank;
	double Rating;
	public Coach(Image degree, Image certificate, Rank rank, double rating) {
		super();
		Degree = degree;
		Certificate = certificate;
		this.rank = rank;
		Rating = rating;
	}
	public Coach(int id, Image degree, Image certificate, Rank rank, double rating) {
		super();
		this.id = id;
		Degree = degree;
		Certificate = certificate;
		this.rank = rank;
		Rating = rating;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Image getDegree() {
		return Degree;
	}
	public void setDegree(Image degree) {
		Degree = degree;
	}
	public Image getCertificate() {
		return Certificate;
	}
	public void setCertificate(Image certificate) {
		Certificate = certificate;
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

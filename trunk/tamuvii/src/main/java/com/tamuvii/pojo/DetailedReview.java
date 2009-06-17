package com.tamuvii.pojo;

import com.tamuvii.model.Review;

public class DetailedReview extends Review {
	
	private Integer numOpinions;
	private Integer mark; // Il voto che l'utente ha dato al film
	private String image; // L'immagine dell'utente che ha fatto la review

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getNumOpinions() {
		return numOpinions;
	}

	public void setNumOpinions(Integer numOpinions) {
		this.numOpinions = numOpinions;
	}

}
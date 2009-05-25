package com.tamuvii.pojo;

public class ShelfDirectorReport {
	
	private Integer director;
	private String name;
	private String surname;
	private String aka;
	private Integer numMovies;
	
	public String getAka() {
		return aka;
	}
	public void setAka(String aka) {
		this.aka = aka;
	}
	public Integer getDirector() {
		return director;
	}
	public void setDirector(Integer director) {
		this.director = director;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Integer getNumMovies() {
		return numMovies;
	}
	public void setNumMovies(Integer numMovies) {
		this.numMovies = numMovies;
	}

}
package com.saurav.entity;

import java.util.Objects;

import jakarta.persistence.*;

@Entity

public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String language;
	private String genre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", language=" + language + ", genre=" + genre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(genre, id, language, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(genre, other.genre) && Objects.equals(id, other.id)
				&& Objects.equals(language, other.language) && Objects.equals(name, other.name);
	}

}
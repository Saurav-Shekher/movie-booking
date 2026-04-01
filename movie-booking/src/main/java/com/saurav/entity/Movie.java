package com.saurav.entity;

import java.util.Objects;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String language;
	private String genre;

	

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
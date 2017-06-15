package ua.lviv.ltl.model;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "book")
public class Book extends BaseModel {

	public Book() {
	}

	public Book(String title, String description, int isbn) {
		this.title = title;
		this.description = description;
		this.isbn = isbn;
	}

	public Book(String title, String description, int isbn, List<Author> authors) {
		this.title = title;
		this.description = description;
		this.isbn = isbn;
		this.authors = authors;
	}

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "isbn")
	private int isbn;

	@Cascade({CascadeType.SAVE_UPDATE})
	@ManyToMany(mappedBy = "books",fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Author> authors;

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", description=" + description + ", isbn=" + isbn + ", authors=" 
				+ ", getId()=" + getId() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + isbn;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (isbn != other.isbn)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}

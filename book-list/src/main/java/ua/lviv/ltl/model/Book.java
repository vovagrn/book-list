package ua.lviv.ltl.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "book")
public class Book extends BaseModel implements Serializable{
	
	private static final long serialVersionUID = 2891926529837790140L;

	public Book() {
	}	

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "pageCount")
	private Integer pageCount;

	@Column(name = "language")
	@Enumerated(EnumType.STRING)
	private Language language;

	@Column(name = "publishYear")
	private Integer publishYear;
	
	@Lob()
	@Column(name = "image", columnDefinition = "MEDIUMBLOB")	
	private byte[] image;

	@Column(name = "isbn")
	private int isbn;
		
	@ManyToOne()
	@JoinColumn(name = "genre")
	private Genre genre;
	
	@ManyToOne()
	@JoinColumn(name = "publisher")
	private Publisher publisher;

	// @Cascade({CascadeType.SAVE_UPDATE})
	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "book_author", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "author_id") })
	private Set<Author> authors = new LinkedHashSet<>();

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

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Integer getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(Integer publishYear) {
		this.publishYear = publishYear;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + isbn;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((pageCount == null) ? 0 : pageCount.hashCode());
		result = prime * result + ((publishYear == null) ? 0 : publishYear.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (!Arrays.equals(image, other.image))
			return false;
		if (isbn != other.isbn)
			return false;
		if (language != other.language)
			return false;
		if (pageCount == null) {
			if (other.pageCount != null)
				return false;
		} else if (!pageCount.equals(other.pageCount))
			return false;
		if (publishYear == null) {
			if (other.publishYear != null)
				return false;
		} else if (!publishYear.equals(other.publishYear))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	

}

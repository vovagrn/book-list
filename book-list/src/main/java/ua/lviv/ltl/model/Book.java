package ua.lviv.ltl.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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

	

}

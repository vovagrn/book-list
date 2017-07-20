package ua.lviv.ltl.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre extends BaseModel implements Serializable {

	private static final long serialVersionUID = 7743254293406536363L;

	public Genre() {
	}

	public Genre(String name) {
		this.name = name;
	}

	public Genre(String name, Set<Book> books) {
		this.name = name;
		this.books = books;
	}

	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
	private Set<Book> books = new HashSet<Book>(0);

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return this.books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Genre other = (Genre) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}

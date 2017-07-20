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
@Table(name = "publisher")
public class Publisher extends BaseModel implements Serializable {

	private static final long serialVersionUID = -1270400233531979942L;

	public Publisher() {
    }

    public Publisher(String name) {
        this.name = name;
    }

    public Publisher(String name, Set<Book> books) {
        this.name = name;
        this.books = books;
    }
    
    @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)    
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
}

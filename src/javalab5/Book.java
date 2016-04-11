package javalab5;

import javafx.util.converter.IntegerStringConverter;
import javax.persistence.*;

/**
 *
 * @author Damian Darczuk
 */
@Entity
@Table(name = "BOOK")
@NamedQuery(name = "Book.findAll", query = "SELECT f FROM Book f")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;    
    @Column(name = "TITLE")
    private String title;
    
    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "AUTHOR", referencedColumnName = "id")    
    private Author author;
    
    public Book() {              
    }
    
    public Book(String title) {
        this.title = title;        
    }
    
    public Author getAuthor(){
        return this.author;
    }
        
    public void setAuthor(Author author) {
        this.author = author;
    }
        
    public String getTitle(){
        return this.title;
    }
        
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId(){
        return this.id;
    }
        
    public void setId(Integer title) {
        this.id = title;
    }
    
    public void setId(String title) {
        IntegerStringConverter conv = new IntegerStringConverter();
        int ti = conv.fromString(title);
        this.id = ti;
    }
}

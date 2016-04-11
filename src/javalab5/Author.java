/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalab5;

import java.io.Serializable;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.*;

/**
 *
 * @author Damian Darczuk
 */
@Entity
@Access(AccessType.PROPERTY)
@Table(name = "AUTHOR")
@NamedQuery(name = "Author.findAll", query = "SELECT f FROM Author f")
public class Author implements Serializable {
    
    
    private Integer id;
    private Integer author;
    
    private String name;
   
    private String surname; 
    
    private ObservableList<Book> books = FXCollections.observableArrayList();
    
    public Author() {
    } 
    
    @OneToMany(mappedBy = "author")//cascade = CascadeType.ALL,
    public List<Book> getBooks() {
        return this.books;
    }
    
    public void setBooks(List<Book> book){
        this.books = FXCollections.observableArrayList(book);
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    @Column(name = "NAME")
    public String getName() {
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    @Column(name = "SURNAME") 
    public String getSurname() {
        return this.surname;
    }
    
     public void setSurname(String surname){
        this.surname = surname;
    }
           
}

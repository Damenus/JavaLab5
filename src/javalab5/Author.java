/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalab5;

import java.io.Serializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.*;

/**
 *
 * @author Damian Darczuk
 */
@Entity
@Table(name = "AUTHOR")
@NamedQuery(name = "Author.findAll", query = "SELECT f FROM Author f")
public class Author implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;   
   // @OneToMany(mappedBy = "id")
  //  private ObservableList<Book> books = FXCollections.observableArrayList();

    public Author() {
    }  
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
     
    public String getSurname() {
        return this.surname;
    }
    
     public void setSurname(String surname){
        this.surname = surname;
    }
           
}

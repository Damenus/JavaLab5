/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalab5;

import javax.persistence.*;

/**
 *
 * @author Damian Darczuk
 */
@Entity
@Table(name = "authors")
public class Author {
    
    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private String surname;
    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "id")
    private Book book;
    
    
    Author(){
        
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
        
     public Book getBook() {
        return this.book;
    }
     
    public void setBook(Book book){
        this.book = book;
    }
    
}

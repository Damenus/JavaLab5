/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalab5;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Damian Darczuk
 */
public class FXMLDocumentController implements Initializable {
        
   @FXML
    TableColumn idAuthorColumn;
    @FXML
    TableColumn nameAuthorColumn;
    @FXML
    TableColumn surnameAuthorColumn;
    @FXML
    TableView<Author> authorTableView;
    
    @FXML
    TableColumn idBookColumn;
    @FXML
    TableColumn titleBookColumn;
    @FXML
    TableView<Book> bookTableView;    
    
    ObservableList<Book> books = FXCollections.observableArrayList();
    ObservableList<Author> authors = FXCollections.observableArrayList();
    
    private EntityManager em;
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaLab5PU");
        em = emf.createEntityManager();  
                
        authorTableView.setItems(authors);
        bookTableView.setItems(books);
         
        List<Author> dbAuthors = em.createNamedQuery("Author.findAll").getResultList();
        authors.addAll(dbAuthors);
        
        List<Book> dbBook = em.createNamedQuery("Book.findAll").getResultList();
        books.addAll(dbBook);
        
        authorTableView.setEditable(true);
        bookTableView.setEditable(true);
        
        IntegerStringConverter conv = new IntegerStringConverter();
        
        surnameAuthorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        surnameAuthorColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Author, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Author, String> event) {
                Author author = event.getRowValue();
                String newSName = event.getNewValue();
                author.setSurname(newSName);
                update(event.getRowValue());
            }
        });
        
        nameAuthorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameAuthorColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Author, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Author, String> event) {
                Author author = event.getRowValue();
                String newName = event.getNewValue();
                author.setName(newName);
                update(event.getRowValue());
            }
        });
        
        idAuthorColumn.setCellFactory(TextFieldTableCell.forTableColumn(conv));
        idAuthorColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Author, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Author, Integer> event) {
                Author author = event.getRowValue();
                int newId = event.getNewValue();
                author.setId(newId);
            }
        });
        
        titleBookColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        titleBookColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Book, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Book, String> event) {
                Book book = event.getRowValue();
                String newTitle = event.getNewValue();
                book.setTitle(newTitle);
                update(event.getRowValue());
            }            
        });        
               
        idBookColumn.setCellFactory(TextFieldTableCell.forTableColumn(conv));
        idBookColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Book, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Book, Integer> event) {
                Book book = event.getRowValue();
                int newId = event.getNewValue();
                book.setId(newId);
            }
        });
    }  
    
    @FXML
    private void newBookAction(ActionEvent ae) {
        Book book = new Book();
        book.setTitle("");
    }
    
    private void update(Author author){
        try {
            em.getTransaction().begin();
            em.merge(author);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
   }
    
    private void update(Book book){
         try {
            em.getTransaction().begin();
            em.merge(book);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }
    
    private void persist(Author author) {
        try {
            em.getTransaction().begin();
            em.persist(author);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }
    
    private void persist(Book book) {
        try {
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }
    
    private void remove(Author author){
        try {
            em.getTransaction().begin();
            em.remove(author);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }
    
    private void remove(Book book){
        try {
            em.getTransaction().begin();
            em.remove(book);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }
    
}

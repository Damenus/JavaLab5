/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalab5;

import java.net.URL;
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
    TableColumn idBookColumn;
    @FXML
    TableColumn titleBookColumn;
    @FXML
    TableView<Book> bookTableView;
    
    @FXML
    TableColumn idAuthorColumn;
    @FXML
    TableColumn nameAuthorColumn;
    @FXML
    TableColumn surnameAuthorColumn;
    @FXML
    TableView<Book> authorTableView;
    
    ObservableList<Book> books = FXCollections.observableArrayList();
    ObservableList<Author> authors = FXCollections.observableArrayList();
    
    private EntityManager em;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaLab5PU");
        em = emf.createEntityManager();
        
        
        titleBookColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        idBookColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>("pages"));
        
//      bookTableView.setItems(books);
//      bookTableView.setEditable(true);
//      setCellFactoryD(titleBookColumn);  
          
        titleBookColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        titleBookColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Book, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Book, String> event) {
                Book book = event.getRowValue();
                String newTitle = event.getNewValue();
                book.setTitle(newTitle);
            }            
        });        
        
        IntegerStringConverter conv = new IntegerStringConverter();
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
    
    void setCellFactoryD(TableColumn a){
        a.setCellFactory(TextFieldTableCell.forTableColumn());
        a.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Book, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Book, String> event) {
                Book book = event.getRowValue();
                String newTitle = event.getNewValue();
                book.setTitle(newTitle);
            }            
        });  
    }
    
}

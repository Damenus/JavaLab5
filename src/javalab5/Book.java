package javalab5;

import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.converter.IntegerStringConverter;
import javax.persistence.*;

/**
 *
 * @author Damian Darczuk
 */
@Entity
@Table(name = "books")
public class Book {
    
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column
    private StringProperty title = new SimpleStringProperty();
    
    @OneToMany(mappedBy = "book")
    private List<Author> authors;
                
    public Book() {
        title = new SimpleStringProperty("");       
    }
    
    public Book(String title) {
        this.title.set(title);        
    }
        
    public String getTitle(){
        return this.title.getValue();
    }
        
    public void setTitle(String title) {
        this.title.set(title);
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

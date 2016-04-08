package javalab5;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.converter.IntegerStringConverter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Damian Darczuk
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "book", propOrder = {"title", "pages"})
public class Book {
    
    private StringProperty title = new SimpleStringProperty();
    private IntegerProperty pages = new SimpleIntegerProperty();
            
    public Book() {
        title = new SimpleStringProperty("");
        pages = new SimpleIntegerProperty(0);
    }
    
    public Book(String title, int pages) {
        this.title.set(title);
        this.pages.set(pages);
    }
    
    public Book(String title, String pages) {
        this.title.set(title);        
        IntegerStringConverter conv = new IntegerStringConverter();
        int page = conv.fromString(pages);
        this.pages.set(page);
    }
    
    @XmlAttribute
    public String getTitle(){
        return this.title.getValue();
    }
    
    @XmlAttribute
    public int getPages() {
        return this.pages.get();
    }
    
    public void setTitle(String title) {
        this.title.set(title);
    }
    
    public void setPages(int pages) {
        this.pages.set(pages);
    }
    
}

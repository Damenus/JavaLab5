package javalab5;

import javafx.beans.property.StringProperty;
import javalab5.Author;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-08T22:07:49")
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile SingularAttribute<Book, Integer> id;
    public static volatile SingularAttribute<Book, StringProperty> title;
    public static volatile ListAttribute<Book, Author> authors;

}
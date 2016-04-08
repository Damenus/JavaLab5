package javalab5;

import javalab5.Book;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-08T22:09:27")
@StaticMetamodel(Author.class)
public class Author_ { 

    public static volatile SingularAttribute<Author, String> surname;
    public static volatile SingularAttribute<Author, Book> book;
    public static volatile SingularAttribute<Author, String> name;
    public static volatile SingularAttribute<Author, Integer> id;

}
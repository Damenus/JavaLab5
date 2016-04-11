# JavaLab5
Java: JPA
Fajny tutorial: http://www.homeandlearn.co.uk/java/creating_a_database_with_java.html

Następna laborka jest to samo z xml tylko na bazach danych, ale trzeba postawić server.
Na szczęście w netbeans jest już server baz danych, wystarczy uruchomić i skonfigurować.
Jak będziecie chcieli uruchomić magówJPA to musicie mieć baze danych zgodną z tym co jest w pliku persistence.xml (hasło użytkownik i serwer) i chyba stworzyć tabele tak jak ma gdzieś w pliku sql.
Potrzeny jest netbeans z javaEE, tak mi się wydaje bo JavaEE ma opcje serverowe a SE nie ma. Reinstalowałem netbeans do JavaEE,
ale w sumie pomogło dopiero to: http://stackoverflow.com/questions/29196489/netbeans-not-starting-java-db-server-with-jdk-1-8-0-40

EDIT: W projekcie do libraries trzeba dodać Java DB Driver
EDIT2: Problem z platformlogger: http://stackoverflow.com/questions/22562797/javafx8-sun-util-logging-platformlogger-not-found-exception-in-netbeans-8
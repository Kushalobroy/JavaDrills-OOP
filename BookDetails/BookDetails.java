package BookDetails;

import java.util.ArrayList;

class Book{
    private String title;
    private String author;
    private String ISBN;
    private static ArrayList<Book> bookCollection = new ArrayList<>();

    // Constructor
    public Book(String title, String author, String ISBN){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }
    public String getTitle(){return title;}
    public void setTitle(String title){this.title=title;}
    public String getAuthor(){return author;}
    public void setAuthor(String author){this.author=author;}
    public String getISBN(){return ISBN;}
    public void setISBN(String ISBN){this.ISBN=ISBN;}
    public static void addBook(Book book){bookCollection.add(book);}
    public static void removeBook(Book book){bookCollection.remove(book);}
    public static ArrayList<Book> getBookCollection(){return bookCollection;}

}

public class BookDetails {
    public static void main(String[] args){
        Book book1 = new Book("C", "Neha", "123456");
        Book book2 = new Book("DSA", "Kushal", "19876");
        Book.addBook(book1);
        Book.addBook(book2);
        ArrayList<Book> bookCollection = Book.getBookCollection();
        System.out.println("LIst of Books:");
        for(Book book: bookCollection){
            System.out.println(book.getTitle()+" by"+book.getAuthor()+" ,ISBN:"+book.getISBN());
        }
    }
}

import java.util.*;
class Book{
    private int id;
    private int pages;
    private String title;
    private String author;
    private double price;
    public Book(int id, int pages, String title, String author, double price) {
        this.id = id;
        this.pages = pages;
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public double getPrice(){return price;}
    public int getId(){return id;}
    public String getTitle(){return title;}
    public int getPages(){return pages;}
}
public class Solution21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[4];
        for(int i=0;i<4;i++){
            int id = sc.nextInt();
            sc.nextLine();
            int pages = sc.nextInt();
            sc.nextLine();
            String title = sc.nextLine();
            String author = sc.nextLine();
            double price = sc.nextDouble();
            sc.nextLine();
            books[i] = new Book(id, pages, title, author, price);
        }
        String tI = sc.nextLine();
        sc.close();
        Book[] books2 = findBookWithMaximumPrice(books);
        if(books2 != null){
            for(Book b:books2) System.out.println(b.getId()+" "+b.getTitle());
        }
        else System.out.println("No Book found with mentioned attribute");
        Book[] books3 = searchBookByTitle(books, tI);
        if(books3 != null){
            for(Book b:books3){
                System.out.println(b.getId());
                System.out.println(b.getPages());
            }
        }
        else System.out.println("No Book found with mentioned attribute");
    }
    public static Book[] searchBookByTitle(Book[] book, String title){
        Book[] fB = Arrays.stream(book).filter(b -> b.getTitle().equalsIgnoreCase(title)).toArray(Book[]::new);
        if(fB == null) return null;
        return fB;
    }
    public static Book[] findBookWithMaximumPrice(Book[] books){
        Arrays.sort(books, (b1,b2)->Double.compare(b2.getPrice(), b1.getPrice()));
        double hP = books[0].getPrice();
        Book[] fB = Arrays.stream(books).filter(b -> b.getPrice()==hP).toArray(Book[]::new);
        if(fB == null) return null;
        return fB;
    }
}

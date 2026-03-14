import java.util.*;
class Document{
    private int id;
    private String title;
    private String folderName;
    private int pages;

    public Document(int id, String title, String folderName, int pages){
        this.id = id;
        this.title = title;
        this.folderName = folderName;
        this.pages = pages;
    }
    public int getPages(){return pages;}
    public int getId(){return id;}
    public String getTitle(){return title;}
    public String getFolderName(){return folderName;}
}
public class Solution34 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Document[] documents = new Document[4];
        for(int i=0;i<4;i++){
            int id = sc.nextInt(); sc.nextLine();
            String title = sc.nextLine();
            String folderName = sc.nextLine();
            int pages = sc.nextInt(); sc.nextLine();
            documents[i] = new Document(id, title, folderName, pages);
        }
        Document[] documents2 = docsWithOddPages(documents);
        if(documents2 != null){
            for(Document d: documents2){
                System.out.println(d.getId()+" "+d.getTitle()+" "+d.getFolderName()+" "+d.getPages());
            }
        }
        else System.out.println("No such Documents are available");
        sc.close();
    }
    public static Document[] docsWithOddPages(Document[] documents){
        Document[] fD = Arrays.stream(documents).filter(d -> d.getPages()%2 !=0).toArray(Document[]::new);
        if(fD.length == 0) return null;
        return fD;
    }
}

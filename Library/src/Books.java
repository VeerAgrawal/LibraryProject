import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Books
{

    private String Title;
    private String Author;
    private String Genre;
    private String datePublished;
    Scanner sc;


    Books()
    {
        Title = "Americanah";
        Author = "Chimamanda Ngozi Adichie";
        Genre = "Romance Novel";
        datePublished = "06/04/2013"; //dd/mm/yyyy
        sc = new Scanner(System.in);
    }

    Books(String _Title, String _Author, String _Genre, String _datePublished)
    {
        Title = _Title;
        Author = _Author;
        Genre = _Genre;
        datePublished = _datePublished;
    }

    public String toString()
    {
        return Title + ", " + Author + ", " + Genre + ", Date Published:" + datePublished;
    }

    public void Donate()
    {
        try
        {
            System.out.println("Enter the title of the book:");
            String iTitle = sc.nextLine();
            System.out.println("Enter the Author's Name:");
            String iAuthor = sc.nextLine();
            System.out.println("Enter the Genre");
            String iGenre = sc.nextLine();
            System.out.println("Enter the Date Published(dd/mm/yyyy):");
            String idatePublished = sc.nextLine();
            Books b11 = new Books(iTitle, iAuthor, iGenre, idatePublished);
            FileWriter writer = new FileWriter("Library/Books.txt", true);
            writer.write( "\n" + b11.toString());
            writer.close();
            System.out.println("Thank you for your donation");

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }



    public String getTitle()
    {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

}

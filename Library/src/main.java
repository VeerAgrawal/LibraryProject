import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Stream;

public class main
{
    public static void main(String[] args)
    {

        Books b1 = new Books();
        Books b2 = new Books("The Great Gatsby", "F. Scott Fitzgerald", "Tragedy Novel", "10/05/1925");
        Books b3 = new Books("The Kite runner","Khaled Hosseini", "Drama Novel", "29/05/2003");
        Books b4 = new Books("The lord of the Rings", "J. R. R. Tolkien", "Fantasy Adventure Novel", "29/07/1954");
        Books b5 = new Books("To Kill a Mockingbird", "Harper Lee", "Thriller Novel", "11/07/1960");
        Books b6 = new Books("Steve Jobs", "Walter Isaacson", "Biography", "24/10/2011");
        Books b7 = new Books("Harry Potter and the Deathly Hallows", "J. K. Rowling", "Fantasy Novel", "21/07/2007");
        Books b8 = new Books("Diary of a Wimpy Kid: The Deep End", "Jeff Kinney", "Children's Graphic Novel", "27/10/2020");
        Books b9 = new Books("A Promised Land", "Barack Obama", "Biography/Autobiography", "17/11/2020");
        Books b10 = new Books("A Brief History of Time", "Stephen Hawking", "Popular science", "10/01/1988");

        File info = new File("Library/Books.txt");
       if (info.length() == 0) {
           try {
               info.getParentFile().mkdirs();
               info.createNewFile();
               FileWriter writer = new FileWriter("Library/Books.txt");

               writer.write(b1.toString());
               writer.write("\n");
               writer.write(b2.toString());
               writer.write("\n");
               writer.write(b3.toString());
               writer.write("\n");
               writer.write(b4.toString());
               writer.write("\n");
               writer.write(b5.toString());
               writer.write("\n");
               writer.write(b6.toString());
               writer.write("\n");
               writer.write(b7.toString());
               writer.write("\n");
               writer.write(b8.toString());
               writer.write("\n");
               writer.write(b9.toString());
               writer.write("\n");
               writer.write(b10.toString());
               writer.close();

           } catch (IOException e) {
               e.printStackTrace();
           }
       }


        SignupLogin enter = new SignupLogin();
        System.out.println("Welcome to Veer's library");
        System.out.println("Would you like to sign up or log in?");
        System.out.println("enter '1' to sign up and '2' to log in:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        try
        {
            int x = Integer.parseInt(input);
            switch (x)
            {
                case 1:
                    System.out.println("Welcome to the sign up page");
                    enter.Signup();
                    break;
                case 2:
                    enter.login();
                    break;
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Enter an Integer!");
            System.out.println("Exiting program...");
        }
        if (enter.isLogedIN == true)
        {
            do
                {
                System.out.println("What would you like to do?(Input a number)");
                System.out.println("1)Browse all books 2)Checkout a book 3)Donate a Book 4) return a book 5)View your history 6)Exit");
                String input1 = sc.nextLine();
                try
                {
                    int y = Integer.parseInt(input1);
                    switch (y)
                    {
                        case 1:
                            try
                            {
                                System.out.println("would you like to sort by alphabetical order?");
                                System.out.println("1=yes and 2=no");
                                Integer sort = sc.nextInt();


                                if (sort == 2)
                                {
                                    Scanner sc2 = new Scanner(info);
                                    while (sc2.hasNextLine())
                                    {
                                        String fromData = sc2.nextLine();
                                        System.out.println(fromData);
                                    }

                                }
                                else if (sort == 1)
                                {
                                    Scanner sc2 = new Scanner(info);
                                    ArrayList<String> information = new ArrayList<String>();
                                    while (sc2.hasNextLine())
                                    {
                                        String fromData = sc2.nextLine();
                                        information.add(fromData);
                                    }
                                    String[] array2 = information.toArray(new String[0]);
                                    array2 = Stream.of(array2).sorted().toArray(String[]::new);
                                    for (int i = 0; i < array2.length; i++)
                                    {
                                        System.out.println(array2[i]);
                                    }

                                }
                                else
                                {
                                    System.out.println("Enter 1 or 2");
                                }
                            }
                            catch (IOException | InputMismatchException e)
                            {
                                System.out.println("ENTER AN INTEGER");
                                //e.printStackTrace();
                            }

                            break;
                        case 2:
                            enter.CheckOut();
                            break;
                        case 3:
                            b1.Donate();
                            break;
                        case 4:
                            enter.Return();
                            break;
                        case 5:
                            enter.History();
                            break;
                        case 6:
                            System.out.println("Exiting program...");
                            System.exit(0);
                            break;
                    }
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Enter a Integer");
                }
            }
            while (enter.isLogedIN == true);
        }

    }

}

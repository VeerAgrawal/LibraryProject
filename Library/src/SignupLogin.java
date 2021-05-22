import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;

public class SignupLogin
{
    Scanner sc;
    public boolean isLogedIN;
    String User;


    SignupLogin()
    {

        sc = new Scanner(System.in);
        isLogedIN = false;
    }


    public void Signup()
    {

        System.out.println("Enter a Username:");
        String username = sc.nextLine();

        System.out.println("Enter a Password:");
        String password = sc.nextLine();

        System.out.println("Enter password again:");
        String passwordVerify = sc.nextLine();

        if (password.equals(passwordVerify))
        {
            File DATA = new File("Library/Users/" + username + ".txt");
            try
            {
                DATA.getParentFile().mkdirs();
                if (DATA.createNewFile())
                {
                    System.out.println("Acount created for user: " + username);
                    try
                    {
                        FileWriter writer = new FileWriter("Library/Users/"+username+".txt");
                        writer.write("Username:"+username);
                        writer.write("\n");
                        writer.write(password);

                        writer.close();
                    }
                    catch (IOException e)
                    {
                        System.out.println("Error with code");
                        e.printStackTrace();
                    }
                }
                else
                {
                    System.out.println("User '"+username+"' already exists. Try logging in.");
                }

            }
            catch (IOException e)
            {
                System.out.println("Error with code");
                e.printStackTrace();
            }
        }

        else
        {
            System.out.println("Password's do not match");
            System.out.println("exiting program...");
            System.exit(0);
        }

    }

    public void login()
    {
        System.out.println("Enter your username:");
        String username1 = sc.nextLine();
        System.out.println("Enter your password:");
        String password = sc.nextLine();

        File DATA1 = new File("Library/Users/" + username1 + ".txt");
        if (DATA1.exists())
        {
            try
            {
                Scanner sc1 = new Scanner(DATA1);

                ArrayList<String> lines = new ArrayList<String>();
                while (sc1.hasNextLine())
                {
                    String fromData = sc1.nextLine();
                    lines.add(fromData);
                }

                String[] array = lines.toArray(new String[0]);
                if (array[1].equals(password))
                {
                    isLogedIN = true;
                    System.out.println("Login successful");
                    User = username1;
                }
                else
                {
                    System.out.println("Password is incorrect");
                }

            }
            catch (IOException e)
            {
                System.out.println("Error with code");
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("The user '"+ username1 + "' does not exist");
            System.out.println("Go to sign up page");
        }

    }

    public void CheckOut()
    {
        try {
            System.out.println("Which book do you want to check out(enter number)");
            int x = sc.nextInt();
            int input1 = x - 1;

            FileWriter writer = new FileWriter("Library/Users/" + User + ".txt",true);
            File reader = new File("Library/Books.txt");
            Scanner sc1 = new Scanner(reader);
            ArrayList<String> information = new ArrayList<String>();
            while (sc1.hasNextLine())
            {
                String Data1 = sc1.nextLine();
                information.add(Data1);
            }

            String[] array2 = information.toArray(new String[0]);
            String[] title = array2[input1].split("[,]",0);
            LocalDate checkoutDate = LocalDate.now();
            writer.write("\n" + title[0] + "  | " + checkoutDate + " |  Not Returned" );
            writer.close();
            System.out.println("Check out Succesfull");
        }
        catch (InputMismatchException | IOException | ArrayIndexOutOfBoundsException e)
        {

            System.out.println("ENTER AN INTEGER THAT CORESPONDS TO AN AVALIABLE BOOK!!");
            System.exit(0);

        }

    }

    public void Return()
    {
        try
        {
            String path = "Library/Users/" + User + ".txt";
            File reader = new File(path);
            FileWriter writer = new FileWriter(path,true);

            Scanner sc1 = new Scanner(reader);

            ArrayList<String> information = new ArrayList<String>();
            int x = 0;
            while (sc1.hasNextLine())
            {
                String Data1 = sc1.nextLine();
                information.add(Data1);
                x = x + 1;
            }
            String[] array4 = information.toArray(new String[0]);
            for (int i = 2; i < x ; i++)
            {
                System.out.println(array4[i]);
            }

            System.out.println("which book do you want to return?");
            int input = sc.nextInt();
            input = input + 1;

            LocalDate returnDate = LocalDate.now();

            String y = array4[input].replaceAll("Not Returned", String.valueOf(returnDate));
            array4[input] = y;

            new FileOutputStream(path).close();

            for (int i = 0; i < array4.length; i++)
            {
                if (array4.length - 1 > i)
                {
                    writer.write(array4[i] + "\n");
                }
                else if (array4.length - 1 == i)
                {
                    writer.write(array4[i]);
                }
            }
            writer.close();



        }
        catch (IOException | InputMismatchException | ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Enter Valid Integer!!");
            System.out.println("Goodbye!!");
            System.exit(0);

        }

    }

    public void History()
    {
        try
        {
            File reader = new File("Library/Users/" + User + ".txt");
            Scanner sc1 = new Scanner(reader);
            int x = 0;
            ArrayList<String> information = new ArrayList<String>();
            while (sc1.hasNextLine())
            {
                String Data1 = sc1.nextLine();
                information.add(Data1);
                x = x +1;
            }
            String[] array3 = information.toArray(new String[0]);
            for (int i = 2; i < x ; i++)
            {
                System.out.println(array3[i]);
            }

        }
        catch (IOException e)
        {
            System.out.println("");
            e.printStackTrace();
        }
    }

    public boolean isLogedIN() {
        return isLogedIN;
    }

    public void setLogedIN(boolean logedIN) {
        isLogedIN = logedIN;
    }
}

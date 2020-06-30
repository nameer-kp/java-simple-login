
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
    private String username;
    private String password;
    private char repeat='y';
    private int choose;


    public User() throws SQLException {
        while (repeat == 'y') {
            Scanner scanner = new Scanner(System.in);
            System.out.printf("Enter UserName:");
            username = scanner.nextLine();
            System.out.printf("Enter Password:");
            password = scanner.nextLine();
            System.out.println("1.for creating account \n 2.for login to account");
            // option for login or creating
            choose = scanner.nextInt();

            //used to move scanner to next line
            scanner.nextLine();


            try {
                // postgres Driver registering
                Class.forName("org.postgresql.Driver");
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/login_console", "postgres", "123456");
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM login WHERE username='" + username + "'AND password='" + password + "'";

                // query2 is used to create new tuple in the database
                String query2 = "INSERT INTO public.login(\n"+
                        "username, password)\n" +
                        "\tVALUES ('"+username+"','"+password+"');";
                if (choose==2){         //login code
                ResultSet rs = statement.executeQuery(query);
                if (rs.next()) {
                    System.out.println("Login Successful");
                } else {
                    System.out.println("Creating new account"); //creating account if doesnt exist on database
                    statement.executeUpdate(query2);            // using executeUpdate since were not performing selection query
                    System.out.println("Account Created");
                        }
                statement.close();
                connection.close();
                }
                else if (choose ==1){       //account creation code
                    System.out.println("user choose account creation mode");
                    statement.executeUpdate(query2);            // using executeUpdate since were not performing selection query
                    System.out.println("Account Created");
                    statement.close();
                    connection.close();
                }
            }
                catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Do you want to repeat:");
            this.repeat = scanner.nextLine().charAt(0);
        }
    }
}
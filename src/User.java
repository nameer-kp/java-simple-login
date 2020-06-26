
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
    private String username;
    private String password;
    private int repeat=1;


    public User() throws SQLException {
        while (repeat == 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.printf("Enter UserName:");
            username = scanner.nextLine();
            System.out.printf("Enter Password:");
            password = scanner.nextLine();

            try {
                Class.forName("org.postgresql.Driver");
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/login_console", "postgres", "123456");
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM login WHERE username='" + username + "'AND password='" + password + "'";
                ResultSet rs = statement.executeQuery(query);
                if (rs.next()) {
                    System.out.println("Login Successful");
                } else {
                    System.out.println("Login Failed");
                }
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.printf("Do you want to repeat:");
            this.repeat = scanner.nextInt();
        }
    }
}
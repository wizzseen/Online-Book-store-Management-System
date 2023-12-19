import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Shop {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/(Data Base Name)";
    static final String USERNAME = "User Name";
    static final String PASSWORD = "Password";
    private static int choice;

    

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Scanner scanner = new Scanner(System.in);
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database.");


            
                System.out.println("1.Admininstrator");
                System.out.println("2.Customer");
                System.out.println("3.exit");

                

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        admin(connection);
                        break;
                    case 2:
                        customer(connection);
                        break;
                    
                    default:
                        System.out.println("Choose between 1 to 2");
                }
        
            
            
            
            
        } catch (ClassNotFoundException e) {
            
            e.printStackTrace();
        } catch (SQLException e) {
           
            e.printStackTrace();
        } 
    }


    
    
    public static  void admin(Connection connection){
        Scanner scanner = new Scanner(System.in);
        int admin_exit;
        while(true){
            admin_exit=0;
        System.out.println("Enter password:");
        String admin_password=scanner.nextLine();

        if (admin_password.equals(PASSWORD))
        
        {
            do{
            System.out.println("logged in as a admin");
            System.out.println("1.Add");
            System.out.println("2.update");
            System.out.println("3.delete");
            System.out.println("4.view Books");
            System.out.println("5.Exit");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                add(connection);
                break;
                case 2:
                update(connection);
                break;
                case 3:
                delete(connection);
                break;
                case 4:
                view(connection);
                break;
                case 5:
                System.out.println("Bye");
                break;
                default:
                System.out.println("Enter valid input ");
                break;
            }
        }while(choice!=5);

            break;

        }else{
            System.out.println("wrong password");
            
    }
}

    }public static void add(Connection connection){
        try {
            Scanner sc=new Scanner(System.in);

            System.out.println("Enter book name:");
            String book_na=sc.nextLine();
            
            System.out.println("Enter Book Price:");
            Integer book_p=sc.nextInt();

            String sql = "INSERT INTO books (book_name, book_price,details) VALUES ( ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book_na);
            statement.setInt(2, book_p);
            statement.setString(3, "Available");
            
            statement.executeUpdate();
            System.out.println("Book has been added Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void update(Connection connection){
        try{
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter the book ID to update:");
            int bookId = sc.nextInt();

            System.out.println("Enter the new book name:");
            sc.nextLine(); // Consume the newline character
            String newBookName = sc.nextLine();

            System.out.println("Enter the new book price:");
            int newBookPrice = sc.nextInt();

            String sql = "UPDATE books SET book_name = ?, book_price = ? WHERE book_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newBookName);
            statement.setInt(2, newBookPrice);
            statement.setInt(3, bookId);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Book updated successfully.");
            } else {
                System.out.println("No book found with the specified ID.");
            }

            statement.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void delete(Connection connection){
        try{
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter the book ID to delete:");
            int bookId = sc.nextInt();

            String sql = "DELETE FROM books WHERE book_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, bookId);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Book deleted successfully.");
            } else {
                System.out.println("No book found with the specified ID.");
            }

        }catch(SQLException e) {
            e.printStackTrace();
    }
    }

    public static void view(Connection connection) {
        try {
            String sql = "SELECT * FROM books";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Book List:");
            
            System.out.printf("%-10s | %-25s | %-10s | %-25s%n", "Book ID", "Book Name", "Book Price", "Book Details");
            
    
            while (resultSet.next()) {
                int bookId = resultSet.getInt("book_id");
                String bookName = resultSet.getString("book_name");
                int bookPrice = resultSet.getInt("book_price");
                String bookDetails = resultSet.getString("details");
    
                System.out.printf("%-10d | %-25s | $%-9d | %-25s%n", bookId, bookName, bookPrice, bookDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    
    
    
    
    
    
    
    
    
    
    
    public static void customer(Connection connection){
        int user_l;
        try{
            Scanner scanner=new Scanner(System.in);
             Statement statement = connection.createStatement();
        
System.out.println("1.New user");
System.out.println("2.Existing user");
 user_l=scanner.nextInt();

        if(user_l==1){
            new_user(connection);
        }else{
            old_user(connection);
        }




        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }

    public static void new_user(Connection connection){
            try{

                Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Online Store Sign-up!");
        System.out.println();

       
        System.out.print("Enter your name: ");
        String userName = sc.nextLine();

        System.out.print("Enter your password: ");
        String password = sc.nextLine();


        
       
        String sql = "INSERT INTO users (user_name, user_password) VALUES ( ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            statement.setString(2, password);
            
            statement.executeUpdate();
            System.out.println("Thank you for signing up!");
            

        





            }catch (SQLException e) {
            e.printStackTrace();
        }
    }







    public static void old_user(Connection connection){
        Scanner scanner=new Scanner(System.in);
        String passwordfromdb="";
        String details="";
         
        try{
            System.out.println("Enter your username:");
            String user_nam=scanner.nextLine();
            System.out.println("Enter password");
            String user_pass=scanner.nextLine();
        Statement statement=connection.createStatement();
        String query="SELECT user_password from users where user_name= ?";
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1,user_nam);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
             passwordfromdb=resultSet.getString("user_password");
        }if(passwordfromdb.equals(user_pass)){

            System.out.println("Logged in successfully ");
            
            view(connection);

            System.out.println("Enter Book ID you want to purchase:");
            int bookId = scanner.nextInt();

            // Check book availability and retrieve details
            String checkAvailabilityQuery = "SELECT details FROM books WHERE book_id = ?";
            PreparedStatement checkAvailabilityStatement = connection.prepareStatement(checkAvailabilityQuery);
            checkAvailabilityStatement.setInt(1, bookId);
            ResultSet detailsResultSet = checkAvailabilityStatement.executeQuery();

            if (detailsResultSet.next()) {
                details = detailsResultSet.getString("details");

                if (details.equals("Available")) {
                    System.out.println("Purchased");

                    // Update book status to "Sold"
                    String updateQuery = "UPDATE books SET details = ? WHERE book_id = ?";
                    PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                    updateStatement.setString(1, "Sold");
                    updateStatement.setInt(2, bookId);
                    updateStatement.executeUpdate();
                } else {
                    System.out.println("This book is sold for purchase.");
                }
            } else {
                System.out.println("Book not found.");
            }

            }else{
                System.out.println("Wrong password");
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }








    }
}


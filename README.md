carbon
# Online Book Store Management System

The Online Book Store Management System is a Java application designed to facilitate the management of an online book store. The system provides distinct functionalities for administrators and customers, offering a seamless experience for both user types.

## Overview

### Administrator Features:

Administrators have access to a range of operations for managing the store's book inventory:

- **Add Books:** Add new books to the store with details such as book name, price, and availability status.
- **Update Books:** Modify existing book details, including the book name and price.
- **Delete Books:** Remove books from the store's inventory.
- **View Books:** Display a list of available books, including their ID, name, price, and availability status.

### Customer Features:

Customers can interact with the system to explore and purchase books:

- **Sign Up:** New customers can sign up by providing a username and password.
- **Log In:** Existing customers can log in using their credentials.
- **View Books:** Customers can browse the list of available books.
- **Purchase Books:** Customers can purchase available books, and the system updates the availability status accordingly.

## Setup

1. **Clone the Repository:**
   ```bash
   https://github.com/wizzseen/Online-Book-store-Management-System.git```

**Database Setup:**
-Create a MySQL database with the name specified in the JDBC_URL variable ((Data Base Name)).
-Update the USERNAME and PASSWORD variables in the Shop class with your MySQL username and password

2. **Compile and Run:**
   ```bash
   javac Shop.java
    java Shop```
## Overview

Upon running the application, users will be prompted to choose between Administrator and Customer functionalities.

- **Administrator Functionality:**
  - Enter the correct password to access the admin menu.
  - Perform operations like adding, updating, deleting, and viewing books.

- **Customer Functionality:**
  - Sign up as a new user or log in as an existing user.
  - View available books and purchase those marked as "Available."

## Database Structure

The application uses a MySQL database with two tables:

### Books Table

- `book_id` (Primary Key)
- `book_name`
- `book_price`
- `details` (Indicates availability)

### Users Table

- `user_id` (Primary Key)
- `user_name`
- `user_password`

## Usage

1. **Administrator:**
   - Run the application.
   - Enter the correct password to access the admin menu.
   - Perform various operations on books.

2. **Customer:**
   - Run the application.
   - Choose to sign up or log in.
   - View available books and make purchases.

## Contributing

1. Fork the project.
2. Create a new branch (`git checkout -b feature/new-feature`).
3. Make changes and commit them (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature/new-feature`).
5. Open a pull request.





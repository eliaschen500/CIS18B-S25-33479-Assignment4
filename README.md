# CIS18B-S25-33479-Assignment4
# Java Library Checkout System

This Java console application simulates a digital library checkout system. Users can browse books by genre, check out available titles, and return them. The system uses Java Collections, the Iterator Design Pattern, and custom exception handling to demonstrate principles of object-oriented programming.

## Features

- Organizes books by genre using a HashMap<String, List<Book>>.
- Custom iterator returns only available books for a specific genre.
- Users can check out and return books.
- Includes custom exception handling:
  - BookNotAvailableException: thrown when a book is already checked out.
  - BookNotFoundException: thrown when a requested book is not in the library.
- Console-based interactive interface.
- Modular and extensible object-oriented design.

## How to Compile and Run

1. Open your terminal and navigate to the project directory.
2. Compile all `.java` files:
3. Run the main program: 'java LibraryTest'

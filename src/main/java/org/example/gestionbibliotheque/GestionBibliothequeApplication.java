package org.example.gestionbibliotheque;

import org.example.gestionbibliotheque.dao.entities.*;
import org.example.gestionbibliotheque.dao.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class GestionBibliothequeApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private User1Repository user1Repository;

    public static void main(String[] args) {
        SpringApplication.run(GestionBibliothequeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Creating sample categories
        Category category1 = Category.builder().name("Fiction").description("Fiction books").build();
        Category category2 = Category.builder().name("Non-Fiction").description("Non-Fiction books").build();
        categoryRepository.save(category1);
        categoryRepository.save(category2);
        // Log categories
        categoryRepository.findAll().forEach(category -> System.out.println("Saved Category: " + category.getName()));

        // Creating sample books
        Book book1 = Book.builder()
                .title("Les Miserables")
                .availableCopies(10)
                .totalCopies(20)
                .publishedDate(LocalDate.of(1862, 4, 3))  // Use LocalDate here
                .description("A novel by Victor Hugo")
                .isbn("153")
                .author("Victor Hugo")
                .category(category1)
                .build();

        Book book2 = Book.builder()
                .title("1984")
                .availableCopies(5)
                .totalCopies(10)
                .publishedDate(LocalDate.of(1949, 6, 8))  // Use LocalDate here
                .description("A novel by George Orwell")
                .isbn("1984")
                .author("George Orwell")
                .category(category1)
                .build();

        Book book3 = Book.builder()
                .title("Antigone")
                .availableCopies(10)
                .totalCopies(20)
                .publishedDate(LocalDate.of(1862, 4, 3))  // Use LocalDate here
                .description("A novel by Jean Anouilh")
                .isbn("155")
                .author("Jean Anouilh")
                .category(category2)
                .build();

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);

        // Creating sample users
        User1 user1 = User1.builder()
                .username("john_doe")
                .password("password")
                .email("john_doe@example.com")
                .fullName("John Doe")
                .role("Member")
                .membershipStartDate(LocalDate.now())
                .build();

        User1 user2 = User1.builder()
                .username("jane_doe")
                .password("password")
                .email("jane_doe@example.com")
                .fullName("Jane Doe")
                .role("Member")
                .membershipStartDate(LocalDate.now())
                .build();

        user1Repository.save(user1);
        user1Repository.save(user2);

        // Creating sample loans
        Loan loan1 = Loan.builder()
                .loanDate(LocalDate.now())
                .dueDate(LocalDate.now().plusWeeks(2))
                .loanPrice(5.0)
                .user1(user1)
                .book(book1)
                .build();

        loanRepository.save(loan1);

        // Creating sample reservations
        Reservation reservation1 = Reservation.builder()
                .reservationDate(LocalDate.now())
                .status("Pending")
                .user1(user2)
                .book(book2)
                .build();

        reservationRepository.save(reservation1);

        // Creating sample reviews
        Review review1 = Review.builder()
                .rating(5)
                .comment("Amazing book!")
                .reviewDate(LocalDate.now())
                .user1(user1)
                .book(book1)
                .build();

        reviewRepository.save(review1);

        // Display the data to verify insertion
        /*bookRepository.findAll().forEach(System.out::println);
        categoryRepository.findAll().forEach(System.out::println);
        user1Repository.findAll().forEach(System.out::println);
        loanRepository.findAll().forEach(System.out::println);
        reservationRepository.findAll().forEach(System.out::println);
        reviewRepository.findAll().forEach(System.out::println);*/
    }
}

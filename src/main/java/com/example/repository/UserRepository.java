package com.example.repository;

import com.example.model.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    //* SELECT queries
    @Query("SELECT * FROM users ORDER BY id ASC")
    List<User> findAllUsers();

    @Query("SELECT * FROM users WHERE first_name = :first_name AND last_name = :last_name")
    User findUserByName(String first_name, String last_name);

    @Query("SELECT * FROM users WHERE id = :userId")
    User findUserById(int userId);

    //* UPDATE queries
    @Modifying
    @Query("UPDATE users SET borrowed_book = :borrowed_book WHERE id = :userId")
    void updateUserBorrowedBook(String borrowed_book, int userId);

    @Modifying
    @Query("UPDATE users SET borrowed_book = NULL WHERE id = :userId")
    void updateUserReturnedBook(int userId);

    //* INSERT and DELETE
    @Modifying
    @Query("INSERT INTO users VALUES (NULL, :first_name, :last_name, NULL)")
    void addUser(String first_name, String last_name);

    @Modifying
    @Query("DELETE FROM users WHERE id = :userId")
    void deleteUser(int userId);


}

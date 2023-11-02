package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("users")
public class User {
    @Id
    public int id;
    @Column("first_name")

    public String firstName;
    @Column("last_name")

    public String lastName;
    @Column("borrowed_book")
    public String borrowedBook;

    public String fullName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(String borrowedBook) {
        this.borrowedBook = borrowedBook;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(borrowedBook, user.borrowedBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, borrowedBook);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", borrowedBook='" + borrowedBook + '\'' +
                '}';
    }
}

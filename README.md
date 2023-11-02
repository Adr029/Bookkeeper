# Bookkeeper

<div align="left">
  
  ![Android Studio](https://img.shields.io/badge/Android_Studio-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white) 
  ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
  ![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
  ![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
  ![VSCode](https://img.shields.io/badge/VSCode-0078D4?style=for-the-badge&logo=visual%20studio%20code&logoColor=white)
  [![Trello](https://img.shields.io/badge/Trello-0052CC?style=for-the-badge&logo=trello&logoColor=white)](https://trello.com/b/GoLZJhWn/bookkeeper)

</div>

Bookkeeper is a simple library management system I created to learn about the Spring framework along with the basics of frontend web development. 
The system is heavily under development, especially the frontend part, and you may view my progress and future plans on [Trello](https://trello.com/b/GoLZJhWn/bookkeeper).

## Features

Bookkeeper contains very simplified functionalities which I made to create a demonstration of implementing CRUD operations.

### User Side

- **Create Account**
- **View Books**
- **Borrow Books**
- **Return Books**
- **Delete Account**

### Admin Side

- **View Books Details**
- **View User Details**
- **Add Books**
- **Delete Books**
- **Edit Book Details**

### Notes

- The operations are simplified at the moment.
- The system assumes a one-to-one relationship between books and users.
  - One user may only borrow one book at a time, and only one copy of a book exists.
- I focused on backend development which is why the frontend looks simple at the moment.

## Tools Used

**Backend:**
- Java
- Spring

**Frontend:**
- HTML
- CSS
- Thymeleaf

**Editors:**
- IntelliJ IDEA
- Visual Studio Code

**Database:**
- MySQL
- Spring Data

# Bookkeeper

<div align="left">
  
  ![Android Studio](https://img.shields.io/badge/Android_Studio-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white) 
  ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
  ![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
  ![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
  ![VSCode](https://img.shields.io/badge/VSCode-0078D4?style=for-the-badge&logo=visual%20studio%20code&logoColor=white)

</div>

![bookkeeper banner](https://github.com/Adr029/Bookkeeper/assets/108637165/c365fe98-d4a7-44ab-8dbb-5f6979ae5215)


Bookkeeper is a simple library management system I created to learn about the Spring framework along with the basics of frontend web development. 
The system is heavily under development, especially the frontend part, and you may view my progress and future plans on [Trello](https://trello.com/b/GoLZJhWn/bookkeeper).

For ease of viewing, static HTML files are provided in the "*static-html-offline*" folder to view the concept without having to setup a Spring environment.

<details>
  <summary>Screenshots</summary>
  
  Login Page
  ![login](https://github.com/Adr029/Bookkeeper/assets/108637165/7adbf6a6-97ea-42a0-81b0-4a15078ee44f)

  Admin View
  ![admin1](https://github.com/Adr029/Bookkeeper/assets/108637165/e1fad697-0310-48b6-b7cc-22fb19092ac2)
  ![admin2](https://github.com/Adr029/Bookkeeper/assets/108637165/d1281ca4-1768-43eb-bd5d-8e462a848f04)

  User View
  ![user](https://github.com/Adr029/Bookkeeper/assets/108637165/43d19376-ad5c-41af-b797-f96212ebc3fb)


</details>

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
- Alignment of items in the frontend part are in progress.

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

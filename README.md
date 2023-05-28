# Group 4 - OOP Case Study

This repository contains the case study files for our Object-Oriented Programming (OOP) subject. The case study focuses on applying OOP principles and concepts to solve real-world problems.

## Table of Contents

- [Introduction](https://github.com/ImShawnTheSheep/OOP-CaseStudy#introduction)
- [Folder Structure](https://github.com/ImShawnTheSheep/OOP-CaseStudy#folder-structure)
- [Case Study Overview](https://github.com/ImShawnTheSheep/OOP-CaseStudy#case-study-overview)
- [Getting Started](https://github.com/ImShawnTheSheep/OOP-CaseStudy#getting-started)
- [Our Team](https://github.com/ImShawnTheSheep/OOP-CaseStudy#our-team)

## Introduction

Welcome to **Group 4 - OOP Case Study** repository! This repository serves as a central location for our group's case study files, allowing us to collaborate, track changes, and maintain version control effectively.

In this case study, we explore implementation of two real-world systems using object-oriented programming principles using Java. These case studies provide an opportunity to understand and practice OOP concepts such as encapsulation, inheritance, polymorphism, and abstraction.

## Folder Structure

```
.
├── Inventory Management System/
│   ├── Inventory.java
│   ├── InventoryManagement.java
│   ├── Run.java
│   ├── Util.java
├── Library Management System/
│   ├── Book.java
│   ├── Library.java
│   ├── LibraryManagement.java
│   ├── Run.java
├── .gitignore
├── CODEOWNERS
├── README.md
```

## Case Study Overview

### Case Study 1: Inventory Management System

Create a Java program that allows users to manage an inventory by adding items with their respective quantities, removing items from the inventory, and checking the quantity of items in the inventory. If one transaction is done (for example, after adding 1 item to the inventory), the user must be allowed to choose another action until the user chooses to exit the program.

It must use an **_Inventory_** class to manage the items and an **_InventoryManagement_** class for the user interface (console).

The details inputted by the user after the program execution is **not required** to be persistent.

### Case Study 2: Library Management System

Create a Java program that simulates a library management system where users can add books, remove books, display available books, borrow books, and return books. If one transaction is done (for example, after adding 1 book), the user must be allowed to choose another action until the user chooses to exit the program.

It must use a **_Book_** class to represent a book and a **_Library_** class to manage the books and their availability. Also, use a **_LibraryManagement_** class that will act as the user interface (console) for interacting with the system.

Additional Requirements:

- The book’s attributes must include an ID, title, author, and availability status.
- The book’s ID must be automatically incremented.
- In returning, borrowing, and returning books, the user must be only allowed to input the book’s ID.
- The program must utilize the practice of using proper modifiers and encapsulation.

The details inputted by the user after the program execution is **not required** to be persistent.

## Getting Started

### Prerequisites

- [Java Development Kit 20](https://www.oracle.com/java/technologies/downloads/#java20)
- [Text Editor/IDE](https://www.turing.com/blog/best-java-ides-and-editors/)

### Installation

1. Clone the repository.

```sh
git clone https://github.com/ImShawnTheSheep/OOP-CaseStudy.git
```

2. Open the project folder using your preferred text editor/IDE.

3. Run the program.
```sh
cd <folder_name>
```
```sh
javac Run.java
```
```sh
java Run
```

## Our Team

<div align="center">
  <div>
    <img
    src="https://github.com/ImShawnTheSheep/OOP-CaseStudy/blob/assets/shawn.jpg"
    alt="Jumawan, Shawn Michael"
    width="240"
    height="240"
    />
    <p>
      <b>Jumawan, Shawn Michael </b>
      <i>(Technical Project Manager)</i>
    </p>
  </div>
  <div>
    <img
    src="https://github.com/ImShawnTheSheep/OOP-CaseStudy/blob/assets/kc.jpg"
    alt="Domingo, Kirsten Charles"
    width="240"
    height="240"
    />
    <p>
      <b>Domingo, Kirsten Charles</b>
      <i>(Senior Developer, UI/UX Specialist)</i>
    </p>
  </div>
  <div>
    <img
        src="https://github.com/ImShawnTheSheep/OOP-CaseStudy/blob/assets/mao.jpg"
        alt="Lopez, Maui Mark Daniel"
        width="250"
        height="240"
      />
    <p>
      <b>Lopez, Maui Mark Daniel </b>
      <i>(Senior Developer, Backend Architect)</i>
    </p>
  </div>
  <div>
    <img
    src="https://github.com/ImShawnTheSheep/OOP-CaseStudy/blob/assets/kyla.jpg"
    alt="Baledoya, Kyla Keith"
    width="240"
    height="240"
    />
    <p>
      <b>Baledoya, Kyla Keith </b>
      <i>(Junior Developer, UI Design Assistant)</i>
    </p>
  </div>
</div>

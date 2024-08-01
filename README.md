# Student Exam System

## Overview

Welcome to the Student Exam System! This project is designed to streamline the process of managing student exams, from creating exams to recording student responses and generating results. This system aims to provide an efficient and user-friendly interface for both administrators and students. This project showcases my skills in full-stack development using modern technologies and best practices.

## Purpose

The primary purpose of the Student Exam System is to simulate:
- Setting up an exam for students
- Taking an exam by a student and record responses
- Scoring by teachers and result generation

## Tech Stack

The project utilizes the following technologies:

- **Backend**:
  - Java Spring Boot: framework for building the backend services.
  - Hibernate ORM: For object-relational mapping and database interactions.
  - Maven: For project management and dependency resolution.
- **Frontend**:
  - JSP (JavaServer Pages): For rendering dynamic web pages.
- **Database**:
  - MySQL: For persistent data storage.
- **Build Tools**:
  - Maven Wrapper: For consistent build environment across different machines.

## Main Design

### Controllers

- **ExamApiController**: Handles API requests related to exams.
- **ExamController**: Manages the flow of exam-related web pages.
- **MainController**: Handles the main navigation and welcome page.
- **StudentApiController**: Manages API requests related to student data.

### Entities

- **Exam**: Represents an exam with its details.
- **ExamQuestion**: Represents a question within an exam.
- **QuestionOption**: Represents multiple-choice options for a question.
- **StudentAnswer**: Stores a student's response to a question.
- **StudentEntity**: Represents student details.
- **StudentExam**: Represents the association between students and exams.
- **Topic**: Represents the subject or topic of an exam.

### Repositories

- **ExamRepository**: Interface for CRUD operations on `Exam` entities.
- **QuestionOptionRepository**: Interface for CRUD operations on `QuestionOption` entities.
- **QuestionRepository**: Interface for CRUD operations on `ExamQuestion` entities.
- **StudentAnswerRepository**: Interface for CRUD operations on `StudentAnswer` entities.
- **StudentEntityRepository**: Interface for CRUD operations on `StudentEntity` entities.
- **StudentExamRepository**: Interface for CRUD operations on `StudentExam` entities.
- **TopicRepository**: Interface for CRUD operations on `Topic` entities.

### Services

- **MasterDataService**: Provides business logic and handles the interaction between controllers and repositories.

### Web Pages (JSP)

- **chooseexam.jsp**: Page for selecting an exam.
- **exampage.jsp**: Page for taking the exam.
- **resultPage.jsp**: Page displaying the exam results.
- **studentdetails.jsp**: Page displaying student details.
- **welcome.jsp**: Welcome and main navigation page.

## Overall Logic

1. **User Interaction**: Users (administrators and students) interact with the system through a web interface.
2. **Exam Management**: Administrators can create and manage exams, including questions and options, through the provided web pages.
3. **Taking Exams**: Students log in and select an exam to take. Their responses are recorded and stored in the database using Hibernate ORM.
4. **Result Generation**: The system evaluates student responses and generates results, which can be viewed by both students and administrators.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- MySQL Database

### Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/aditya-parab/student-exam-system.git
   ```
2. Navigate to the project directory:
   ```bash
   cd student-exam-system/spring-examSystem
   ```
3. Set up the MySQL database:
   - Create a database named `student_exam_system`.
   - Update the database configuration in `src/main/resources/application.properties` with your MySQL credentials.
4. Build the project using Maven:
   ```bash
   ./mvnw clean install
   ```
5. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
6. Access the application at `http://localhost:8080`.
7. Done!

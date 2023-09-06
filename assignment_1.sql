CREATE DATABASE Assignment_1
USE DATABASE Assignment_1
/*=====================Students table===================*/
CREATE TABLE Students
(
student_id char(3) NOT NULL PRIMARY KEY,
FName nvarchar(30) NOT NULL ,
LName nvarchar(30) NOT NULL ,
DoB DATE NOT NULL , /* YYYY-MM-DD*/
Major nvarchar(30) NOT NULL
);
/*=====================Courses table===================*/
CREATE TABLE Courses
(
Course_ID char(3) NOT NULL PRIMARY KEY,
CName nvarchar(25) NOT NULL ,
Credits INT /* */
);
/*=====================Enrollment table===================*/
CREATE TABLE Enrollment
(
	EnrollmentID char(4) PRIMARY KEY,
    /* Add StudentID as a foreign key later*/
    /* Add CourseID as a foreign key later*/
	grade nvarchar(30) NOT NULL
);
/*=====================Professors table===================*/
CREATE TABLE Enrollment
(
	ProfessorID char(4) PRIMARY KEY,
    FName nvarchar(30) NOT NULL ,
    LName nvarchar(30) NOT NULL ,
    department nvarchar(30)

);
/*=====================Teaches table===================*/
CREATE TABLE Teaches
(
	TeachID char(4) PRIMARY KEY,
    /* Add ProfessorID as a foreign key later*/
    /* Add CourseID as a foreign key later*/
);

/*===================== Foreign Key===================*/
/*==========Enrollment=========*/
ALTER TABLE Enrollment
ADD CONSTRAINT fk_StudentID
FOREIGN KEY (StudentID) REFERENCES Students (StudentID);

ALTER TABLE Enrollment
ADD CONSTRAINT fk_CourseID
FOREIGN KEY (CourseID) REFERENCES Courses (CourseID);
/*=========Teaches===========*/
ALTER TABLE Teaches 
ADD CONSTRAINT fk_ProfessorID
FOREIGN KEY (ProfessorID) REFERENCES Professors (ProfessorID);

ALTER TABLE Teaches 
ADD CONSTRAINT fk_CourseID
FOREIGN KEY (CourseID) REFERENCES Courses (CourseID);
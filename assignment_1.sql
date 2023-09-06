/*=====================Students table===================*/
CREATE TABLE Students
(
    StudentID char(3) NOT NULL PRIMARY KEY,
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
	StudentID char(3),
	Course_ID char(3),
	FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
	FOREIGN KEY (Course_ID) REFERENCES Courses(Course_ID),
    /* Add StudentID as a foreign key later*/
    /* Add CourseID as a foreign key later*/
	grade nvarchar(30) NOT NULL
);
/*=====================Professors table===================*/
CREATE TABLE Professors
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
	ProfessorID char(4),
	FOREIGN KEY (ProfessorID) REFERENCES Professors(ProfessorID),
	Course_ID char(3),
	FOREIGN KEY (Course_ID) REFERENCES Courses(Course_ID)
    /* Add ProfessorID as a foreign key later*/
    /* Add CourseID as a foreign key later*/
);

/*===================== Foreign Key===================*/
/*==========Enrollment=========*/
/*
ALTER TABLE Enrollment
ADD FOREIGN KEY (StudentID) REFERENCES Students(StudentID);

ALTER TABLE Enrollment
ADD FOREIGN KEY (CourseID) REFERENCES Courses(CourseID);
*/
/*=========Teaches===========*/
/*
ALTER TABLE Teaches 
ADD FOREIGN KEY (ProfessorID) REFERENCES Professors(ProfessorID);

ALTER TABLE Teaches 
ADD FOREIGN KEY (CourseID) REFERENCES Courses(CourseID);
*/
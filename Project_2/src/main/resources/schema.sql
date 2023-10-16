DROP TABLE Students IF EXISTS;
DROP TABLE Courses IF EXISTS;
DROP TABLE Enrollment IF EXISTS;
DROP TABLE Professors IF EXISTS;
DROP TABLE Teaches IF EXISTS;

CREATE TABLE Test
(
    StudentID char(4) NOT NULL PRIMARY KEY,
    FName nvarchar(30) NOT NULL ,
    LName nvarchar(30) NOT NULL ,
    DoB DATE NOT NULL , /* YYYY-MM-DD*/
    Major nvarchar(30) NOT NULL
);

/*=====================Students table===================*/
CREATE TABLE Students
(
    StudentID char(4) NOT NULL PRIMARY KEY,
    FName nvarchar(30) NOT NULL ,
    LName nvarchar(30) NOT NULL ,
    DoB DATE NOT NULL , /* YYYY-MM-DD*/
    Major nvarchar(30) NOT NULL
);
/*=====================Courses table===================*/
CREATE TABLE Courses
(
    CourseID char(4) NOT NULL PRIMARY KEY,
    CName nvarchar(25) NOT NULL ,
    Credits INT
);
/*=====================Enrollment table===================*/
CREATE TABLE Enrollment
(
	EnrollmentID char(4) PRIMARY KEY,
	StudentID char(4),
	CourseID char(4),
	FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
	FOREIGN KEY (CourseID) REFERENCES Courses(CourseID),
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
	CourseID char(4),
	FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
);

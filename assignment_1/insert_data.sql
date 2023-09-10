/* Make note that you must surround values with quotes in a lot of cases*/
/* DATE datatypes need to be inclosed in quotes and are in the format of 'YYYY-MM-DD'

/* 
- Course IDs and names that student with ID 1234 (Austin Adams) has enrolled in: (BI01) Introduction to Biology, (BI02) Biological Principles, (BI03) Evolution, (CS01) Introduction to Computing
- Students who Major in Comp sci: Bradley Baxter (1256), Damien Duncan (1290), Florence Fisher (1201), Issac Irvine (1207), Julia Johnson (1209)
- From Comp sci majors, students who got an "F" grade: Bradley Baxter (1256), Issac Irvine (1207)
- All professors teach courses of more than 2 credits except for Elizabeth Hayes (1114) & Greta Stanton (1117), and professors Leonardo Salazar (1115) & Russell Donovan (1118) who do not teach any courses
- Student Florence Fisher (1201) is not enrolled in any course
- Course names and ids that no professor teaches: Data Security (CS05), History of Music (MU02)
- Professor names and ids who teach comp sci major students: Omar Diaz (1101), Alyssa Todd (1102), Emmanuel Connolly (1103), Jean Wagner (1104), Michael Giles (1105), Larry Collier (1106), Ruth Ferguson (1108), Raymond Aguilar (1116), Greta Stanton (1117)
(some courses taught by multiple professors, let me know if this ends up being an issue for sql)
*/

/* Students Table Data Values, 10 Values */
INSERT INTO Students (StudentID, FName, LName, DoB, Major) Values (1234, 'Austin', 'Adams', '2000-01-01', 'Biology');
INSERT INTO Students (StudentID, FName, LName, DoB, Major) Values (1256, 'Bradley', 'Baxter', '2002-02-02', 'Comp. Sci.');
INSERT INTO Students (StudentID, FName, LName, DoB, Major) Values (1278, 'Candace', 'Cooper', '2001-05-06', 'Physics');
INSERT INTO Students (StudentID, FName, LName, DoB, Major) Values (1290, 'Damien', 'Duncan', '2001-11-20', 'Comp. Sci.');
INSERT INTO Students (StudentID, FName, LName, DoB, Major) Values (1212, 'Elena', 'Evans', '2000-07-25', 'Biology');
INSERT INTO Students (StudentID, FName, LName, DoB, Major) Values (1201, 'Florence', 'Fisher', '2002-04-02', 'Comp. Sci.');
INSERT INTO Students (StudentID, FName, LName, DoB, Major) Values (1203, 'Georgia', 'Green', '2003-08-01', 'Mathematics');
INSERT INTO Students (StudentID, FName, LName, DoB, Major) Values (1205, 'Heath', 'Hughes', '2002-08-17', 'Music');
INSERT INTO Students (StudentID, FName, LName, DoB, Major) Values (1207, 'Issac', 'Irvine', '2000-06-28', 'Comp. Sci.');
INSERT INTO Students (StudentID, FName, LName, DoB, Major) Values (1209, 'Julia', 'Johnson', '2002-02-13', 'Comp. Sci.');

/* Courses Table Data Values, 20 Values */
INSERT INTO Courses (CourseID, CName, Credits) Values ('CS01', 'Introduction to Computing', 3);
INSERT INTO Courses (CourseID, CName, Credits) Values ('CS02', 'Software Development', 4);
INSERT INTO Courses (CourseID, CName, Credits) Values ('CS03', 'Java Principles', 3);
INSERT INTO Courses (CourseID, CName, Credits) Values ('CS04', 'Python Principles', 3);
INSERT INTO Courses (CourseID, CName, Credits) Values ('CS05', 'Data Security', 4);
INSERT INTO Courses (CourseID, CName, Credits) Values ('CS06', 'Data Science', 4);
INSERT INTO Courses (CourseID, CName, Credits) Values ('MA01', 'Calculus I', 4);
INSERT INTO Courses (CourseID, CName, Credits) Values ('MA02', 'Calculus II', 4);
INSERT INTO Courses (CourseID, CName, Credits) Values ('MA03', 'Linear Algebra', 3);
INSERT INTO Courses (CourseID, CName, Credits) Values ('PH01', 'Introduction to Physics', 3);
INSERT INTO Courses (CourseID, CName, Credits) Values ('PH02', 'Mechanics', 4);
INSERT INTO Courses (CourseID, CName, Credits) Values ('BI01', 'Introduction to Biology', 3);
INSERT INTO Courses (CourseID, CName, Credits) Values ('BI02', 'Biological Principles', 3);
INSERT INTO Courses (CourseID, CName, Credits) Values ('BI03', 'Evolution', 4);
INSERT INTO Courses (CourseID, CName, Credits) Values ('MU01', 'Music Theory', 1);
INSERT INTO Courses (CourseID, CName, Credits) Values ('MU02', 'History of Music', 3);
INSERT INTO Courses (CourseID, CName, Credits) Values ('MU03', 'Music and Film', 2);
INSERT INTO Courses (CourseID, CName, Credits) Values ('ST01', 'Statistics Principles', 3);
INSERT INTO Courses (CourseID, CName, Credits) Values ('ST02', 'Probability', 3);
INSERT INTO Courses (CourseID, CName, Credits) Values ('ST03', 'Research in Statistics', 1);

/* Enrollment Table Data Values, 28 Values */
INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1001', '1234', 'BI01', 'A');
INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1002', '1234', 'BI02', 'B');
INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1003', '1234', 'BI03', 'A');
INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1004', '1234', 'CS01', 'A');

INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1005', '1256', 'CS02', 'F');
INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1006', '1256', 'CS04', 'B');
INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1007', '1256', 'CS06', 'A');

INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1008', '1278', 'PH01', 'A');
INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1009', '1278', 'PH02', 'B');
INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1010', '1278', 'ST01', 'A');

INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1011', '1290', 'CS01', 'A');

INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1012', '1212', 'BI01', 'A');
INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1013', '1212', 'BI02', 'D');
INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1014', '1212', 'BI03', 'F');

INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1015', '1203', 'MA01', 'A');
INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1016', '1203', 'MA03', 'A');

INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1017', '1205', 'MU01', 'B');
INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1018', '1205', 'MU03', 'B');
INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1019', '1205', 'CS01', 'A');

INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1020', '1207', 'CS01', 'A');
INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1021', '1207', 'CS02', 'A');
INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1022', '1207', 'MA02', 'F');
INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1023', '1207', 'ST01', 'A');

INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1024', '1209', 'CS03', 'A');
INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1025', '1209', 'MA01', 'B');
INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1026', '1209', 'PH01', 'C');
INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1027', '1209', 'CS06', 'A');
INSERT INTO Enrollment (EnrollmentID, StudentID, CourseID, grade) Values ('1028', '1209', 'ST03', 'A');

/* Professors Table Data Values, 18 Values */
INSERT INTO Professors (ProfessorID, FName, LName, department) Values ('1101', 'Omar', 'Diaz', 'Comp. Sci.');
INSERT INTO Professors (ProfessorID, FName, LName, department) Values ('1102', 'Alyssa', 'Todd', 'Comp. Sci.');
INSERT INTO Professors (ProfessorID, FName, LName, department) Values ('1103', 'Emmanuel', 'Connolly', 'Comp. Sci.');
INSERT INTO Professors (ProfessorID, FName, LName, department) Values ('1104', 'Jean', 'Wagner', 'Comp. Sci.');
INSERT INTO Professors (ProfessorID, FName, LName, department) Values ('1105', 'Michael', 'Giles', 'Mathematics');
INSERT INTO Professors (ProfessorID, FName, LName, department) Values ('1106', 'Larry', 'Collier', 'Mathematics');
INSERT INTO Professors (ProfessorID, FName, LName, department) Values ('1107', 'Brian', 'Montes', 'Mathematics');
INSERT INTO Professors (ProfessorID, FName, LName, department) Values ('1108', 'Ruth', 'Ferguson', 'Physics');
INSERT INTO Professors (ProfessorID, FName, LName, department) Values ('1109', 'Connor', 'Jackson', 'Physics');
INSERT INTO Professors (ProfessorID, FName, LName, department) Values ('1110', 'Tobias', 'Curry', 'Biology');
INSERT INTO Professors (ProfessorID, FName, LName, department) Values ('1111', 'Jordan', 'Dunlap', 'Biology');
INSERT INTO Professors (ProfessorID, FName, LName, department) Values ('1112', 'Hudson', 'Wallace', 'Biology');
INSERT INTO Professors (ProfessorID, FName, LName, department) Values ('1113', 'Rebecca', 'Peck', 'Biology');
INSERT INTO Professors (ProfessorID, FName, LName, department) Values ('1114', 'Elizabeth', 'Hayes', 'Music');
INSERT INTO Professors (ProfessorID, FName, LName, department) Values ('1115', 'Leonardo', 'Salazar', 'Music');
INSERT INTO Professors (ProfessorID, FName, LName, department) Values ('1116', 'Raymond', 'Aguilar', 'Statistics');
INSERT INTO Professors (ProfessorID, FName, LName, department) Values ('1117', 'Greta', 'Stanton', 'Statistics');
INSERT INTO Professors (ProfessorID, FName, LName, department) Values ('1118', 'Russell', 'Donovan', 'Statistics');

/* Teaches Table Data Values, 25 Values */
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1301', '1101', 'CS01');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1302', '1101', 'CS02');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1303', '1101', 'CS04');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1304', '1102', 'CS01');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1305', '1102', 'CS03');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1306', '1103', 'CS06');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1307', '1104', 'CS03');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1308', '1104', 'CS04');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1309', '1105', 'MA01');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1310', '1106', 'MA01');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1311', '1106', 'MA02');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1312', '1107', 'MA03');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1313', '1108', 'PH01');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1314', '1109', 'PH02');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1315', '1110', 'BI01');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1316', '1110', 'BI02');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1317', '1111', 'BI01');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1318', '1111', 'BI02');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1319', '1112', 'BI03');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1320', '1113', 'BI02');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1321', '1114', 'MU01');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1322', '1114', 'MU03');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1323', '1116', 'ST01');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1324', '1116', 'ST02');
INSERT INTO Teaches (TeachID, ProfessorID, CourseID) Values ('1325', '1117', 'ST03');

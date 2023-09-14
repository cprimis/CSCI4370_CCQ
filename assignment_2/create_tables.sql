/*Entity Sets*/
CREATE TABLE Employee
(
    employeeID char(4) NOT NULL PRIMARY KEY,
    name nvarchar(30) NOT NULL ,
    department nvarchar(30) NOT NULL ,
    job_title nvarchar(30) NOT NULL
);

CREATE TABLE Doctor
(
    doctorID char(4) NOT NULL PRIMARY KEY,
    name nvarchar(30) NOT NULL ,
    department nvarchar(30) NOT NULL
);

CREATE TABLE Pharmacist
(
    pharmacistID char(4) NOT NULL PRIMARY KEY,
    name nvarchar(30) NOT NULL
);

CREATE TABLE LabTechnician
(
    labtechID char(4) NOT NULL PRIMARY KEY,
    name nvarchar(30) NOT NULL
);

CREATE TABLE Patient
(
    patientID char(4) NOT NULL PRIMARY KEY,
    name nvarchar(30) NOT NULL ,
    DoB DATE NOT NULL /* YYYY-MM-DD*/
);

CREATE TABLE LabTest
(
    labtestID char(4) NOT NULL PRIMARY KEY,
    date DATE NOT NULL , /* YYYY-MM-DD*/
    type nvarchar(30) NOT NULL ,
    result char(3) NOT NULL ,
    doctorID char(4) ,
    patientID char(4) ,
    FOREIGN KEY (doctorID) REFERENCES Doctor(doctorID) , /*orders relationship*/
    FOREIGN KEY (patientID) REFERENCES Patient(patientID) /*receives relationship*/
);

CREATE TABLE Prescription
(
    prescriptionID char(4) NOT NULL PRIMARY KEY,
    date DATE NOT NULL , /* YYYY-MM-DD*/
    doctor nvarchar(30) NOT NULL ,
    patient nvarchar(30) NOT NULL ,
    amount nvarchar(30) NOT NULL
);

CREATE TABLE Medication
(
    medicationID char(4) NOT NULL PRIMARY KEY ,
    name nvarchar(30) NOT NULL ,
    dosage nvarchar(30) NOT NULL ,
    price nvarchar(30) NOT NULL , 
    patientID char(4) ,
    pharmacistID char(4) ,
    FOREIGN KEY (patientID) REFERENCES Patient(patientID) , /*receives relationship*/
    FOREIGN KEY (pharmacistID) REFERENCES Pharmacist(pharmacistID) /*dispense relationship*/
);

CREATE TABLE Case
(
    caseID char(4) NOT NULL PRIMARY KEY ,
    doctorID char(4) ,
    pharmacistID char(4) ,
    labtechID char(4) ,
    FOREIGN KEY (doctorID) REFERENCES Doctor(doctorID) , 
    FOREIGN KEY (pharmacistID) REFERENCES Pharmacist(pharmacistID) ,
    FOREIGN KEY (labtechID) REFERENCES LabTechnician(labtechID) 
); 

/*Relationship Sets*/
specialize
attends
prescribes
checks
performs

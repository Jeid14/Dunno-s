CREATE TABLE personList(
id INTEGER UNIQUE,
FirstName VARCHAR NOT NULL,
LastName VARCHAR NOT NULL,
City VARCHAR NOT NULL,
age INTEGER
);

INSERT INTO personList(id,FirstName,LastName,City,age) VALUES
(2,'Anna','Kava','Kiev',26),
(3,'Anastasiya','Serienko','Kharkiv',30),
(77,'Roma','Mazur','Kharkiv',29);
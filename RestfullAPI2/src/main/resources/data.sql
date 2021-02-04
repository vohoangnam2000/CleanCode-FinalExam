
INSERT INTO User(id,email, name, password) VALUES
(1,'vohoangnam@luvina.net', 'vohoangnam', 'abc123');

INSERT INTO Teacher(id,experiences,phone) VALUES
(1,'6', '0223143232');

INSERT INTO User(id,email, name, password) VALUES
(2,'dotuananh@luvina.net', 'dotuananh', 'abc123');

INSERT INTO Teacher(id,experiences,phone) VALUES
(2,'6', '0223143232');

INSERT INTO Course(id,name, description, location,opened,TEACHER_ID) VALUES
(1,'Spring Boot Fundamental', 'Spring Boot Fundamental', 'Hanoi CS1','02112020',1);

INSERT INTO Course(id,name, description, location,opened,teacher_id) VALUES
(2,'Spring Boot Microservice', 'Spring Boot Microservice', 'Hanoi CS2','02112020',1);

INSERT INTO Course(id,name, description, location,opened,teacher_id) VALUES
(3,'Spring Boot Cloud', 'Spring Boot Cloud', 'Hanoi CS1','02112020',2);
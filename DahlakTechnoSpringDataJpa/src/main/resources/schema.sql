Drop TABLE IF EXISTS course_student cascade ;
Drop TABLE IF EXISTS student  CASCADE ;
DROP TABLE IF EXISTS course  CASCADE ;
Drop TABLE IF EXISTS passport CASCADE ;
DROP TABLE IF EXISTS teacher CASCADE ;
CREATE TABLE teacher (
                           teacher_id INTEGER NOT NULL AUTO_INCREMENT,
                           teacher_name varchar(255) DEFAULT NULL,
                           PRIMARY KEY (teacher_id)
) ;
commit ;
CREATE TABLE passport(
                            passport_id INTEGER NOT NULL AUTO_INCREMENT ,
                            passport_name varchar(128) NOT NULL,
                            PRIMARY KEY (passport_id)
) ;
commit ;
CREATE TABLE student (
                           student_id INTEGER NOT NULL AUTO_INCREMENT ,
                           student_name varchar(128) DEFAULT NULL,
                           passport_id INTEGER DEFAULT NULL,
                           PRIMARY KEY (student_id),
   FOREIGN KEY (passport_id) REFERENCES passport (passport_id)
) ;
commit ;
CREATE TABLE course (
                          course_id INTEGER NOT NULL AUTO_INCREMENT,
                          course_name varchar(128) DEFAULT NULL,
                          teacher_id INTEGER DEFAULT NULL,
                          student_id INTEGER DEFAULT NULL,
                          PRIMARY KEY (course_id),
                          FOREIGN KEY (teacher_id) REFERENCES teacher (teacher_id)
) ;
commit ;
CREATE TABLE course_student (
                                  course_id INTEGER NOT NULL,
                                  student_id INTEGER NOT NULL,
                                  PRIMARY KEY (course_id,student_id),
                                  FOREIGN KEY (student_id) REFERENCES student (student_id),
                                   FOREIGN KEY (course_id) REFERENCES course (course_id)
) ;
COMMIT ;




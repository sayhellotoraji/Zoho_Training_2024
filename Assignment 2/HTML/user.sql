use user_details;

drop table user_info;

create table user_info(
    user_id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(24) NOT NULL,
    email VARCHAR(36) NOT NULL,
    age INT NOT NULL,
    mobile_no CHAR(10) NOT NULL,
    gender CHAR(12) NOT NULL,
    dob Date Not Null,
    login_password VARCHAR(24) NOT NULL,
    PRIMARY KEY(user_id)
);


INSERT INTO user_info(user_name, email, age, mobile_no, gender, dob, login_password) 
VALUES('Rajasekar T', 'raj@outlook.com', 27, '9999999999', 'MALE', '2024-02-24', 'JFSWD2');


select * from user_info;

use user_details;


create table user_info(
    user_id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(24) NOT NULL,
    email VARCHAR(36) NOT NULL,
    age INT NOT NULL,
    mobile_no CHAR(10) NOT NULL,
    gender CHAR(12) NOT NULL,
    login_password VARCHAR(24) NOT NULL,
    PRIMARY KEY(user_id)
);


INSERT INTO user_info(user_name, email, age, mobile_no, gender, login_password) 
VALUES('Rajasekar T', 'raj@outlook.com', 27, '9999999999', 'MALE', 'JFSWD2');


select * from user_info;

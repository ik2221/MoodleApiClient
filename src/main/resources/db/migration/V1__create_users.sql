CREATE TABLE IF NOT EXISTS users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255)
);

INSERT INTO users (first_name, last_name, email) VALUES ('John', 'Doe', 'j.doe@mail.xyz');
INSERT INTO users (first_name, last_name, email) VALUES ('Jane', 'Doe', 'j.doe@mail.xyz');

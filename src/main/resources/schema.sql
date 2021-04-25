DROP TABLE IF EXISTS statistics;

CREATE TABLE statistics (
    id INT AUTO_INCREMENT PRIMARY KEY,
    login varchar(255) NOT NULL UNIQUE,
    request_count INT8 NOT NULL
);

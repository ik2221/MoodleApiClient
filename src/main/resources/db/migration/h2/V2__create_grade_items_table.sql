CREATE TABLE grade_items (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    item_name VARCHAR(255),
    item_type VARCHAR(255),
    item_module VARCHAR(255),
    item_instance INT,

    grade_raw INT,
    grade_min INT,
    grade_max INT,

    grade_date_graded INT,
    feedback VARCHAR(255)
);

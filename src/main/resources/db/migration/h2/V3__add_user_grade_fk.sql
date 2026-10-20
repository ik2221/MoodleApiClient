-- Create the parent table first
CREATE TABLE user_grades (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    course_id INT NOT NULL,
    user_id INT NOT NULL,
    user_full_name VARCHAR(255)
);

-- Add the FK column to the existing child table
ALTER TABLE grade_items
    ADD COLUMN user_grade_id BIGINT;

ALTER TABLE grade_items
    ADD CONSTRAINT fk_grade_item_user_grade
        FOREIGN KEY (user_grade_id) REFERENCES user_grades(id);

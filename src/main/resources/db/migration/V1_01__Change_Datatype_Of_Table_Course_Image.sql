use course_for_sell;

ALTER TABLE courses
    MODIFY COLUMN image LONGBLOB;


ALTER TABLE courses
    MODIFY COLUMN price DECIMAL(11,2);
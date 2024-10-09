create table roles
(
    id   int primary key auto_increment,
    name varchar(20) unique not null
);

CREATE TABLE users
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    full_name  VARCHAR(255)        NOT NULL,
    username   VARCHAR(255),
    email      VARCHAR(255) UNIQUE NOT NULL,
    phone      VARCHAR(10) UNIQUE  NOT NULL,
    password   VARCHAR(255)        NOT NULL,
    role_id    int,
    foreign key (role_id) references roles (id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE categories
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE courses
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(255) UNIQUE NOT NULL,
    description TEXT                NOT NULL,
    price       DECIMAL(10, 2)      NOT NULL,
    image       BLOB                NOT NULL,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE TABLE lessons
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE contents
(
    id    BIGINT PRIMARY KEY AUTO_INCREMENT,
    name  VARCHAR(255) UNIQUE NOT NULL,
    text  LONGTEXT,
    video LONGBLOB
);

CREATE TABLE subcategories
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(50) UNIQUE NOT NULL,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE TABLE orders
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    order_date TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
    total      DECIMAL(10, 2) NOT NULL,
    status     VARCHAR(50) DEFAULT 'Pending',
    user_id    BIGINT,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE ratings
(
    id        BIGINT PRIMARY KEY AUTO_INCREMENT,
    content   LONGTEXT NOT NULL,
    stars     INT DEFAULT 1,
    user_id   BIGINT,
    course_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (course_id) REFERENCES courses (id)
);

CREATE TABLE course_lessons
(
    course_id BIGINT,
    lesson_id BIGINT,
    FOREIGN KEY (course_id) REFERENCES courses (id),
    FOREIGN KEY (lesson_id) REFERENCES lessons (id)
);

CREATE TABLE lesson_contents
(
    lesson_id  BIGINT,
    content_id BIGINT,
    FOREIGN KEY (lesson_id) REFERENCES lessons (id),
    FOREIGN KEY (content_id) REFERENCES contents (id)
);

CREATE TABLE order_courses
(
    order_id  BIGINT,
    course_id BIGINT,
    FOREIGN KEY (order_id) REFERENCES orders (id),
    FOREIGN KEY (course_id) REFERENCES courses (id)
);

INSERT INTO roles (name)
VALUES ('ADMIN');
INSERT INTO roles (name)
VALUES ('USER');

INSERT INTO users (full_name, email, phone, password, role_id)
VALUES ('John Doe', 'john@example.com', '1234567890', 'password123', 1);

INSERT INTO users (full_name, email, phone, password, role_id)
VALUES ('Jane Smith', 'jane@example.com', '0987654321', 'password456', 2);

INSERT INTO categories (name)
VALUES ('Development');
INSERT INTO categories (name)
VALUES ('Design');

INSERT INTO courses (name, description, price, image, category_id)
VALUES ('Java Programming', 'Learn Java from basics to advanced', 199.99, 'sampleImage', 1);

INSERT INTO courses (name, description, price, image, category_id)
VALUES ('Graphic Design Basics', 'Introduction to graphic design concepts', 99.99, 'sampleImage2', 2);

INSERT INTO lessons (name)
VALUES ('Introduction to Java');
INSERT INTO lessons (name)
VALUES ('Java Syntax and Variables');

INSERT INTO subcategories (name, category_id)
VALUES ('Java', 1);

INSERT INTO subcategories (name, category_id)
VALUES ('Photoshop', 2);

INSERT INTO orders (total, status, user_id)
VALUES (199.99, 'Completed', 1);

INSERT INTO orders (total, status, user_id)
VALUES (99.99, 'Pending', 2);

INSERT INTO ratings (content, stars, user_id, course_id)
VALUES ('Great course!', 5, 1, 1);

INSERT INTO ratings (content, stars, user_id, course_id)
VALUES ('Very informative', 4, 2, 2);

INSERT INTO course_lessons (course_id, lesson_id)
VALUES (1, 1);

INSERT INTO course_lessons (course_id, lesson_id)
VALUES (1, 2);

INSERT INTO order_courses (order_id, course_id)
VALUES (1, 1);

INSERT INTO order_courses (order_id, course_id)
VALUES (2, 2);


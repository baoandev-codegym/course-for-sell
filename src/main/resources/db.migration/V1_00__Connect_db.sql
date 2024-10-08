CREATE TABLe users
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    fullname   VARCHAR(255)        NOT NULL,
    email      VARCHAR(255) UNIQUE NOT NULL,
    phone      VARCHAR(10) UNIQUE  NOT NULL,
    password   VARCHAR(255)        NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

create table roles
(
    id   int primary key auto_increment,
    name varchar(20) unique not null
);

create table users_roles
(
    user_id bigint,
    role_id int,
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

CREATE TABLE categories
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE courses
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(255) UNIQUE NOT NULL,
    description TEXT                NOT NULL,
    price       DECIMAL(10, 2)      NOT NULL,
    image       BLOB                NOT NULL,
    category_id BIGINT,
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
    category_id BIGINT,
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

CREATE TABLE courses_lessons
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



